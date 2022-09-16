package com.coin.web.aspect;

import com.coin.entity.TCustomer;
import com.coin.req.CommonReq;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.CustomerService;
import com.coin.service.constant.BizCons;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.RedisUtil;
import com.coin.service.util.StrUtil;
import com.coin.web.annotation.CommonSecure;
import com.coin.web.utils.IpUtils;
import com.coin.web.utils.ParamUtil;
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
@Order(3)
public class CommonAspect {

    private static final Logger logger = LoggerFactory.getLogger(CommonAspect.class);
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private CustomerService customerService;

    @Around(value="within(com.coin.web.controller.*Controller) && @annotation(commonSecure)")
    public Object commonSecure(ProceedingJoinPoint pj, CommonSecure commonSecure){
        try{
            CommonReq req = this.getReq(pj);
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            String method = request.getServletPath();
            String token = StrUtil.getStr(request.getHeader("token"));
            String loginName = redisUtil.get(token);
            if(StringUtils.isBlank(loginName) && commonSecure.needLogin()){
                return new MyResp(CodeCons.LOGIN_OUT, "登录已过期，请重新登录");
            }
            long waitMill = BizCons.SYS_REQ_INTERVAL_M;
            if(commonSecure.fastQuery()){
                waitMill = BizCons.SYS_REQ_INTERVAL_S;
            }
            if(!commonSecure.needLogin()){
                loginName = req.getLoginName();
            }
            if(!redisUtil.setNx(loginName+method, "1", waitMill)){
                return new MyResp(CodeCons.REQ_TOO_FAST, "请求太快，请稍后");
            }
            if(commonSecure.needLogin()){
                TCustomer customer = customerService.getInfoByLoginName(loginName);
                if(customer == null || customer.getStatus() != 1){
                    return new MyResp(CodeCons.CUSTOMER_NO_EXISTS, "用户不存在或已失效");
                }
            }
            customerService.clearLotteryNum();
            String tokenKey = RedisUtil.getApiKey(loginName + ":token");
            logger.info("loginName={}, request-ip={}", loginName, IpUtils.getIpAddr(request));
            redisUtil.setExpire(token, BizCons.SESSION_OUT_TIME);
            redisUtil.setExpire(tokenKey, BizCons.SESSION_OUT_TIME);
            req.setLoginName(loginName);
            return pj.proceed();
        } catch (BizException e){
            logger.error("commonSecure-be", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        } catch (Exception e){
            logger.error("commonSecure-ex", e);
        } catch (Throwable t) {
            logger.error("commonSecure-tb", t);
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
