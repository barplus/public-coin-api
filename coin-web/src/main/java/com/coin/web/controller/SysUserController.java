package com.coin.web.controller;

import com.coin.entity.TSysUser;
import com.coin.req.SysUserReq;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.SysUserService;
import com.coin.service.constant.BizCons;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.BizUtil;
import com.coin.service.util.MD5Util;
import com.coin.service.util.ParamUtil;
import com.coin.service.util.RedisUtil;
import com.coin.web.annotation.OfficeSecure;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class SysUserController {

    private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Resource
    private SysUserService userService;
    @Resource
    private RedisUtil redisUtil;

    @PostMapping("/login")
    @OfficeSecure
    public MyResp login(@RequestBody SysUserReq req){
        logger.info("user-login-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getLoginName(), "登录名", req.getLoginPass(), "登录密码");
            if(valid != null){
                return valid;
            }
            TSysUser user = userService.getUserByLoginName(req.getLoginName());
            if(user == null){
                return new MyResp(CodeCons.ERROR, "用户不存在");
            }

            if(!MD5Util.MD5(req.getLoginPass()).equals(user.getLoginPass())){
                return new MyResp(CodeCons.ERROR, "密码输入错误");
            }
            if(user.getStatus().intValue() == 0){
                return new MyResp(CodeCons.ERROR, "用户已被禁用");
            }
            String tokenKey = BizCons.SYS_OFFICE + user.getLoginName() + ":token";
            String oldToken = redisUtil.get(tokenKey);
            if(StringUtils.isNotBlank(oldToken)){
                redisUtil.remove(oldToken);
                redisUtil.remove(tokenKey);
            }
            user.setLoginPass(null);
            String token = MD5Util.MD5(user.getLoginName() + System.currentTimeMillis() + BizUtil.getStringRandom(5, 1));
            redisUtil.set(token, user.getLoginName(), 1800);
            redisUtil.set(tokenKey, token, 1800);
            return new MyResp(CodeCons.SUCCESS, token, user);
        }catch(Exception e){
            logger.error("user-login-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/logout")
    @OfficeSecure
    public MyResp logout(@RequestBody SysUserReq req){
        logger.info("user-logout-req={}", req);
        try{
            TSysUser user = userService.getUserByLoginName(req.getLoginName());
            String tokenKey = BizCons.SYS_OFFICE + user.getLoginName()+":token";
            if(redisUtil.get(tokenKey) != null){
                String oldToken = redisUtil.get(redisUtil.get(tokenKey));
                if(oldToken != null){
                    redisUtil.remove(redisUtil.get(tokenKey));
                }
                redisUtil.remove(tokenKey);
            }
            return new MyResp(CodeCons.SUCCESS, "退出成功");
        }catch(Exception e){
            logger.error("user-logout-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/updatePass")
    @OfficeSecure
    public MyResp updatePass(@RequestBody SysUserReq req){
        logger.info("user-updatePass-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getLoginPass(), "原密码", req.getNewPass(), "新密码");
            if(valid != null){
                return valid;
            }
            if(req.getLoginPass().equals(req.getNewPass())){
                return new MyResp(CodeCons.ERROR, "新密码不能和原密码相同");
            }
            userService.updatePass(req);
            this.logout(req);
            return new MyResp(CodeCons.SUCCESS, "修改成功，请重新登录");
        }catch(BizException e){
            logger.error("user-updatePass-error", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("user-updatePass-error", e);
        }
        return new MyResp(CodeCons.ERROR, "修改失败");
    }

}
