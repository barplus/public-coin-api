package com.coin.web.aspect;

import com.coin.req.api.CommonReq;
import com.coin.utils.StrUtil;
import com.coin.web.annotation.CommonSecure;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
@Order(3)
public class CommonAspect {

    private static final Logger logger = LoggerFactory.getLogger(CommonAspect.class);

    @Around(value="within(com.coin.web.controller.*Controller) && @annotation(commonSecure)")
    public Object commonSecure(ProceedingJoinPoint pj, CommonSecure commonSecure){
        try{
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            HttpServletResponse response = attributes.getResponse();
            CommonReq req = null;
            for(Object obj:pj.getArgs()){
                if(obj instanceof CommonReq){
                    req = (CommonReq)obj;
                    break;
                }
            }
            String token = StrUtil.getStr(request.getAttribute("token"));
            return pj.proceed();
        } catch (Exception e){
            logger.error("commonSecure-ex", e);
        } catch (Throwable t) {
            logger.error("commonSecure-tb", t);
        }
        return null;
    }

}
