package com.coin.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contest")
public class ContestController {

    private static final Logger logger = LoggerFactory.getLogger(ContestController.class);

//    @Resource
//    private SysUserService userService;
//    @Resource
//    private RedisUtil redisUtil;
//
//    @PostMapping("/pageList")
//    @OfficeSecure
//    public MyResp pageList(@RequestBody SysUserReq req){
//        logger.info("custPrize-pageList-req={}", req);
//        try{
//            MyResp valid = ParamUtil.NotBlankValid(req.getPageNum(), "页码", req.getPageSize(), "分页大小");
//            if(valid != null){
//                return valid;
//            }
//            PageInfo<SysUserRsp> page = userService.pageList(req);
//            return new MyResp(CodeCons.SUCCESS, "", page);
//        }catch(BizException e){
//            logger.error("custPrize-pageList-BizException", e);
//            return new MyResp(e.getCode(), e.getErrMsg());
//        }catch(Exception e){
//            logger.error("custPrize-pageList-Exception", e);
//        }
//        return new MyResp(CodeCons.ERROR, "请求失败");
//    }
//
//    @PostMapping("/login")
//    @OfficeSecure(needLogin = false)
//    public MyResp login(@RequestBody SysUserReq req){
//        logger.info("user-login-req={}", req);
//        try{
//            MyResp valid = ParamUtil.NotBlankValid(req.getLoginName(), "登录名", req.getLoginPass(), "登录密码");
//            if(valid != null){
//                return valid;
//            }
//            TSysUser user = userService.getUserByLoginName(req.getLoginName());
//            if(user == null){
//                return new MyResp(CodeCons.ERROR, "用户不存在");
//            }
//
//            if(!MD5Util.MD5(req.getLoginPass()).equals(user.getLoginPass())){
//                return new MyResp(CodeCons.ERROR, "密码输入错误");
//            }
//            if(user.getStatus().intValue() == 0){
//                return new MyResp(CodeCons.ERROR, "用户已被禁用");
//            }
//            String tokenKey = BizCons.SYS_OFFICE + user.getLoginName() + ":token";
//            String oldToken = redisUtil.get(tokenKey);
//            if(StringUtils.isNotBlank(oldToken)){
//                redisUtil.remove(oldToken);
//                redisUtil.remove(tokenKey);
//            }
//            user.setLoginPass(null);
//            String token = MD5Util.MD5(user.getLoginName() + System.currentTimeMillis() + BizUtil.getStringRandom(5, 1));
//            redisUtil.set(token, user.getLoginName(), 1800);
//            redisUtil.set(tokenKey, token, 1800);
//            return new MyResp(CodeCons.SUCCESS, token, user);
//        }catch(Exception e){
//            logger.error("user-login-error", e);
//        }
//        return new MyResp(CodeCons.ERROR, "请求失败");
//    }
//
//    @PostMapping("/logout")
//    @OfficeSecure
//    public MyResp logout(@RequestBody SysUserReq req){
//        logger.info("user-logout-req={}", req);
//        try{
//            TSysUser user = userService.getUserByLoginName(req.getLoginName());
//            String tokenKey = BizCons.SYS_OFFICE + user.getLoginName()+":token";
//            if(redisUtil.get(tokenKey) != null){
//                String oldToken = redisUtil.get(redisUtil.get(tokenKey));
//                if(oldToken != null){
//                    redisUtil.remove(redisUtil.get(tokenKey));
//                }
//                redisUtil.remove(tokenKey);
//            }
//            return new MyResp(CodeCons.SUCCESS, "退出成功");
//        }catch(Exception e){
//            logger.error("user-logout-error", e);
//        }
//        return new MyResp(CodeCons.ERROR, "请求失败");
//    }
//
//    @PostMapping("/updatePass")
//    @OfficeSecure
//    public MyResp updatePass(@RequestBody SysUserReq req){
//        logger.info("user-updatePass-req={}", req);
//        try{
//            MyResp valid = ParamUtil.NotBlankValid(req.getLoginPass(), "原密码", req.getNewPass(), "新密码");
//            if(valid != null){
//                return valid;
//            }
//            if(req.getLoginPass().equals(req.getNewPass())){
//                return new MyResp(CodeCons.ERROR, "新密码不能和原密码相同");
//            }
//            userService.updatePass(req);
//            this.logout(req);
//            return new MyResp(CodeCons.SUCCESS, "修改成功，请重新登录");
//        }catch(BizException e){
//            logger.error("user-updatePass-error", e);
//            return new MyResp(e.getCode(), e.getErrMsg());
//        }catch(Exception e){
//            logger.error("user-updatePass-error", e);
//        }
//        return new MyResp(CodeCons.ERROR, "修改失败");
//    }
//
//    @PostMapping("/update")
//    @OfficeSecure
//    public MyResp update(@RequestBody SysUserReq req){
//        logger.info("user-update-req={}", req);
//        try{
//            MyResp valid = ParamUtil.NotBlankValid(req.getId(), "id");
//            if(valid != null){
//                return valid;
//            }
//            userService.update(req);
//            return new MyResp(CodeCons.SUCCESS, "修改成功");
//        }catch(BizException e){
//            logger.error("user-update-error", e);
//            return new MyResp(e.getCode(), e.getErrMsg());
//        }catch(Exception e){
//            logger.error("user-update-error", e);
//        }
//        return new MyResp(CodeCons.ERROR, "修改失败");
//    }

}