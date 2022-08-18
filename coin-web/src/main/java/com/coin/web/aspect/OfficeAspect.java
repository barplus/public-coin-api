package com.coin.web.aspect;

import com.coin.entity.TSysUser;
import com.coin.req.CommonReq;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.SysUserService;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.RedisUtil;
import com.coin.service.util.StrUtil;
import com.coin.web.annotation.OfficeSecure;
import com.coin.web.utils.IpUtils;
import com.coin.web.utils.ParamUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Order(6)
public class OfficeAspect {

    private static final Logger logger = LoggerFactory.getLogger(OfficeAspect.class);
    @Resource
    private SysUserService sysUserService;
    @Resource
    private RedisUtil redisUtil;

    @Around(value="within(com.coin.web.controller.*Controller) && @annotation(officeSecure)")
    public Object officeSecure(ProceedingJoinPoint pj, OfficeSecure officeSecure){
        try{
            CommonReq req = this.getReq(pj);
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            String method = request.getServletPath();
            String[] noNeedLoginPath = {"/user/login"};
            String[] downLoadPath = {"/custPrize/exportDatas"};
            String token = StrUtil.getStr(request.getHeader("token"));
            if(ArrayUtils.contains(downLoadPath, method)){
                token = req.getToken();
            }
            String loginName = redisUtil.get(token);
            if(StringUtils.isBlank(loginName) && !ArrayUtils.contains(noNeedLoginPath, method)){
                return new MyResp(CodeCons.LOGIN_OUT, "登录已过期，请重新登录");
            }
            if(StringUtils.isBlank(loginName)){
                if(!ArrayUtils.contains(noNeedLoginPath, method)){
                    return new MyResp(CodeCons.ERROR, "登录名 不能为空");
                }
                loginName = req.getLoginName();
            }
            String[] fastQueryPath = {"/prize/pageList", "/customer/pageList", "/custPrize/pageDatas"};
            long waitMill = 1688l;
            if(ArrayUtils.contains(fastQueryPath, method)){
                waitMill = 168l;
            }
            if(!redisUtil.setNx(loginName+method, "1", waitMill)){
                return new MyResp(CodeCons.ERROR, "请求太快，请稍后");
            }
            if(!ArrayUtils.contains(noNeedLoginPath, method)){
                TSysUser sysUser = sysUserService.getUserByLoginName(loginName);
                if(sysUser == null){
                    return new MyResp(CodeCons.ERROR, "非法用户请求");
                }
            }
            logger.info("loginName={}, request-ip={}", loginName, IpUtils.getIpAddr(request));
            redisUtil.setExpire(token, 1800l);
            redisUtil.setExpire(loginName+":office:token", 1800l);
            req.setLoginName(loginName);
            return pj.proceed();
        } catch (BizException e){
            logger.error("officeSecure-be", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        } catch (Exception e){
            logger.error("officeSecure-ex", e);
        } catch (Throwable t) {
            logger.error("officeSecure-tb", t);
        }
        return null;
    }

    private CommonReq getReq(ProceedingJoinPoint pj){
        CommonReq req = null;
        Object object = null;
        for(Object obj:pj.getArgs()){
            if(obj instanceof CommonReq){
                req = (CommonReq)obj;
                object = obj;
                break;
            }
        }
        if(req == null){
            throw new BizException(CodeCons.ERROR, "请求参数格式错误");
        }
        ParamUtil.xssCheck(object);
        return req;
    }

}
