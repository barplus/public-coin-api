package com.coin.web.aspect;

import com.coin.entity.Customer;
import com.coin.req.CommonReq;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.CustomerService;
import com.coin.service.constant.CodeCons;
import com.coin.service.util.RedisUtil;
import com.coin.service.util.StrUtil;
import com.coin.web.annotation.CommonSecure;
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
            String token = StrUtil.getStr(request.getHeader("token"));
            String loginName = redisUtil.get(token);
            String[] noLoginPath = {"/customer/login"};
            String[] fastQueryPath = {"/custPrize/pageList"};
            long waitSec = 3000l;
            if(ArrayUtils.contains(fastQueryPath, method)){
                waitSec = 500l;
            }
            if(ArrayUtils.contains(noLoginPath, method)){
                loginName = req.getLoginName();
            }
            if(StringUtils.isBlank(loginName)){
                return new MyResp(CodeCons.LOGIN_OUT, "登录已过期，请重新登录");
            }
            if(!redisUtil.setNx(loginName+method, "1", waitSec)){
                return new MyResp(CodeCons.ERROR, "请求太快，请稍后");
            }
            if(!ArrayUtils.contains(noLoginPath, method)){
                Customer customer = customerService.getInfoByLoginName(loginName);
                if(customer == null || customer.getStatus() != 1){
                    return new MyResp(CodeCons.CUSTOMER_NO_EXISTS, "用户不存在或已失效");
                }
            }
            logger.info("loginName={}, request-ip={}", loginName, IpUtils.getIpAddr(request));
            redisUtil.setExpire(token, 1800l);
            redisUtil.setExpire(loginName+":token", 1800);
            req.setLoginName(loginName);
            return pj.proceed();
        } catch (Exception e){
            logger.error("commonSecure-ex", e);
        } catch (Throwable t) {
            logger.error("commonSecure-tb", t);
        }
        return null;
    }

}
