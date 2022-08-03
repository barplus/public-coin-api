package com.coin.web.controller;

import com.coin.entity.Customer;
import com.coin.req.api.CustomerReq;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.CustomerService;
import com.coin.service.constant.CodeCons;
import com.coin.service.util.MD5Util;
import com.coin.service.util.ParamUtil;
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
            MyResp valid = ParamUtil.NotBlankValid(req.getLoginName(), "登录名", req.getLoginPass(), "登陆密码");
            if(valid != null){
                return valid;
            }
            Customer customer = customerService.getInfoByLoginName(req.getLoginName());
            if(customer == null){
                customerService.createCustomer(req.getLoginName(), MD5Util.MD5(req.getLoginPass()));
                customer = customerService.getInfoByLoginName(req.getLoginName());
            }
            if(!MD5Util.MD5(req.getLoginPass()).equals(customer.getLoginPass())){
                return new MyResp(CodeCons.ERROR, "密码输入错误");
            }
            customer.setLoginPass(null);
            return new MyResp(CodeCons.SUCCESS, "", customer);
        }catch(Exception e){
            logger.error("customer-login-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

}
