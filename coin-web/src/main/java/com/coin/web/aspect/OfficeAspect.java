package com.coin.web.aspect;

import com.coin.entity.SysUser;
import com.coin.req.office.OfficeReq;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.SysUserService;
import com.coin.service.constant.CodeCons;
import com.coin.web.annotation.OfficeSecure;
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

    @Around(value="within(com.coin.web.controller.office.*Controller) && @annotation(officeSecure)")
    public Object officeSecure(ProceedingJoinPoint pj, OfficeSecure officeSecure){
        try{
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            OfficeReq req = null;
            for(Object obj:pj.getArgs()){
                if(obj instanceof OfficeReq){
                    req = (OfficeReq)obj;
                    break;
                }
            }
            String loginName = request.getHeader("loginName");
            if(StringUtils.isBlank(loginName)){
                return new MyResp(CodeCons.ERROR, "登录名 不能为空");
            }
            SysUser sysUser = sysUserService.getUserByLoginName(loginName);
            if(sysUser == null){
                return new MyResp(CodeCons.ERROR, "非法用户请求");
            }
            req.setLoginName(loginName);
            return pj.proceed();
        } catch (Exception e){
            logger.error("officeSecure-ex", e);
        } catch (Throwable t) {
            logger.error("officeSecure-tb", t);
        }
        return null;
    }

}
