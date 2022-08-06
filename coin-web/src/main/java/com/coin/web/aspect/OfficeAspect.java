package com.coin.web.aspect;

import com.coin.entity.SysUser;
import com.coin.req.CommonReq;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.SysUserService;
import com.coin.service.constant.CodeCons;
import com.coin.service.util.RedisUtil;
import com.coin.web.annotation.OfficeSecure;
import com.coin.web.utils.IpUtils;
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
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            CommonReq req = null;
            for(Object obj:pj.getArgs()){
                if(obj instanceof CommonReq){
                    req = (CommonReq)obj;
                    break;
                }
            }
            String method = request.getServletPath();
            String[] noLoginPath = {"/user/login"};
            String loginName = request.getHeader("loginName");
            if(!ArrayUtils.contains(noLoginPath, method) && StringUtils.isBlank(loginName)){
                return new MyResp(CodeCons.ERROR, "登录名 不能为空");
            }
            String[] fastQueryPath = {""};
            long waitSec = 2000l;
            if(ArrayUtils.contains(fastQueryPath, method)){
                waitSec = 300l;
            }
            if(!redisUtil.setNx(loginName+method, "1", waitSec)){
                return new MyResp(CodeCons.ERROR, "请求太快，请稍后");
            }
            if(!ArrayUtils.contains(noLoginPath, method)){
                SysUser sysUser = sysUserService.getUserByLoginName(loginName);
                if(sysUser == null){
                    return new MyResp(CodeCons.ERROR, "非法用户请求");
                }
            }
            logger.info("loginName={}, request-ip={}", loginName, IpUtils.getIpAddr(request));
            if(StringUtils.isNotBlank(loginName)){
                req.setLoginName(loginName);
            }
            return pj.proceed();
        } catch (Exception e){
            logger.error("officeSecure-ex", e);
        } catch (Throwable t) {
            logger.error("officeSecure-tb", t);
        }
        return null;
    }

}
