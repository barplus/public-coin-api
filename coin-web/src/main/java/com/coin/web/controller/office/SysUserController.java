package com.coin.web.controller.office;

import com.coin.entity.SysUser;
import com.coin.req.office.SysUserReq;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.SysUserService;
import com.coin.service.constant.CodeCons;
import com.coin.service.util.MD5Util;
import com.coin.service.util.ParamUtil;
import com.coin.utils.RedisUtil;
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
    public MyResp login(@RequestBody SysUserReq req){
        try{
            redisUtil.set("name", "zhangsan");
            Object o = redisUtil.get("name");
            MyResp valid = ParamUtil.NotBlankValid(req.getLoginName(), "loginName", req.getLoginPass(), "loginPass");
            if(valid != null){
                return valid;
            }
            SysUser user = userService.getUserByLoginName(req.getLoginName());
            if(user == null){
                return new MyResp(CodeCons.ERROR, "用户不存在");
            }

            if(!MD5Util.MD5(req.getLoginPass()).equals(user.getLoginPass())){
                return new MyResp(CodeCons.ERROR, "密码输入错误");
            }
            if(user.getStatus().intValue() == 0){
                return new MyResp(CodeCons.ERROR, "用户已被禁用");
            }
            user.setLoginPass(null);
            return new MyResp(CodeCons.SUCCESS, "", user);
        }catch(Exception e){
            logger.error("getCoins-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

}
