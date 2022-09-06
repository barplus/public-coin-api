package com.coin.web.aspect;

import com.coin.entity.TSysUser;
import com.coin.req.CommonReq;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.SysResourceService;
import com.coin.service.SysRoleResourceService;
import com.coin.service.SysUserService;
import com.coin.service.constant.BizCons;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.RedisUtil;
import com.coin.service.util.StrUtil;
import com.coin.web.annotation.OfficeSecure;
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
@Order(6)
public class OfficeAspect {

    private static final Logger logger = LoggerFactory.getLogger(OfficeAspect.class);
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysResourceService sysResourceService;
    @Resource
    private SysRoleResourceService sysRoleResourceService;
    @Resource
    private RedisUtil redisUtil;

    @Around(value="within(com.coin.web.controller.*Controller) && @annotation(officeSecure)")
    public Object officeSecure(ProceedingJoinPoint pj, OfficeSecure officeSecure){
        try{
            CommonReq req = this.getReq(pj);
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            String method = request.getServletPath();

            String token = StrUtil.getStr(request.getHeader("token"));
            long waitMill = 1688l;
            if(officeSecure.doDownLoad()){
                waitMill = 16168l;
                token = req.getToken();
            }
            String loginName = redisUtil.get(token);
            if(StringUtils.isBlank(loginName) && officeSecure.needLogin()){
                return new MyResp(CodeCons.LOGIN_OUT, "登录已过期，请重新登录");
            }
            if(!officeSecure.needLogin()){
                loginName = req.getLoginName();
            }
            if(officeSecure.fastQuery()){
                waitMill = 168l;
            }
            if(!redisUtil.setNx(loginName+method, "1", waitMill)){
                return new MyResp(CodeCons.ERROR, "请求太快，请稍后");
            }
            if(officeSecure.needLogin()){
                TSysUser sysUser = sysUserService.getUserByLoginName(loginName);
                if(sysUser == null){
                    return new MyResp(CodeCons.ERROR, "非法用户请求");
                }
//                if(StringUtils.isBlank(sysUser.getRoleCode())){
//                    return new MyResp(CodeCons.ERROR, "账号尚未分配角色，请联系系统管理员");
//                }
//                if(officeSecure.doAuth()){
//                    TSysResource sysResource = sysResourceService.getLikePath(method);
//                    if(sysResource == null){
//                        return new MyResp(CodeCons.ERROR, "用户资源权限不足，请联系系统管理员");
//                    }
//                    TSysRoleResource roleResource = sysRoleResourceService.getInfoByRoleCodeAndResCode(sysUser.getRoleCode(), sysResource.getResourceCode());
//                    if(roleResource == null){
//                        return new MyResp(CodeCons.ERROR, "用户角色权限不足，请联系系统管理员");
//                    }
//                }
            }
            String tokenKey = BizCons.SYS_OFFICE + loginName + ":token";
            logger.info("loginName={}, request-ip={}", loginName, IpUtils.getIpAddr(request));
            redisUtil.setExpire(token, 1800l);
            redisUtil.setExpire(tokenKey, 1800l);
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
