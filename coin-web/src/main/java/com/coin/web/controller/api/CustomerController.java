package com.coin.web.controller.api;

import com.coin.req.api.CustomerReq;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.CustomerService;
import com.coin.service.constant.CodeCons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Resource
    private CustomerService customerService;

    @PostMapping("/login")
    public MyResp login(@RequestBody CustomerReq req){
        try{
//            MyResp valid = ParamUtil.NotBlankValid(req.getLoginName(), "loginName", req.getLoginPass(), "loginPass");
//            if(valid != null){
//                return valid;
//            }
//            SysUser user = userService.getUserByLoginName(req.getLoginName());
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
//            user.setLoginPass(null);
            return new MyResp(CodeCons.SUCCESS, "");
        }catch(Exception e){
            logger.error("getCoins-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

}
