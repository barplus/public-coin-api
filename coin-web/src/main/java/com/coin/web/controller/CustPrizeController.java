package com.coin.web.controller;

import com.coin.req.CustPrizeReq;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.CustPrizeService;
import com.coin.service.constant.CodeCons;
import com.coin.web.annotation.CommonSecure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/custPrize")
public class CustPrizeController {

    private static final Logger logger = LoggerFactory.getLogger(CustPrizeController.class);

    @Resource
    private CustPrizeService custPrizeService;

    @PostMapping("/pageList")
    @CommonSecure
    public MyResp pageList(@RequestBody CustPrizeReq req){
        logger.info("custPrize-pageList-req={}", req);
        try{
//            MyResp valid = ParamUtil.NotBlankValid(req.getPageNum(), "页码", req.getPageSize(), "分页大小",
//                    );
//            if(valid != null){
//                return valid;
//            }
//            PageInfo<Prize> page = prizeService.pageList(req);
            return new MyResp(CodeCons.SUCCESS, "");
        }catch(Exception e){
            logger.error("custPrize-pageList-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

//    @Resource
//    private CustomerService customerService;
//    @Resource
//    private RedisUtil redisUtil;
//
//    @PostMapping("/login")
//    @CommonSecure
//    public MyResp login(@RequestBody CustomerReq req){
//        try{
//            MyResp valid = ParamUtil.NotBlankValid(req.getLoginName(), "登录名", req.getLoginPass(), "登陆密码");
//            if(valid != null){
//                return valid;
//            }
//            Customer customer = customerService.getInfoByLoginName(req.getLoginName());
//            if(customer == null){
//                customerService.createCustomer(req.getLoginName(), MD5Util.MD5(req.getLoginPass()));
//                customer = customerService.getInfoByLoginName(req.getLoginName());
//            }
//            if(!MD5Util.MD5(req.getLoginPass()).equals(customer.getLoginPass())){
//                return new MyResp(CodeCons.ERROR, "密码输入错误");
//            }
//            customer.setLoginPass(null);
//            String token = MD5Util.MD5(customer.getLoginName() + System.currentTimeMillis());
//            redisUtil.set(token, customer.getLoginName(), 1800);
//            return new MyResp(CodeCons.SUCCESS, token, customer);
//        }catch(Exception e){
//            logger.error("customer-login-error", e);
//        }
//        return new MyResp(CodeCons.ERROR, "请求失败");
//    }

//    @PostMapping("/doLottery")
//    @CommonSecure
//    public MyResp doLottery(@RequestBody CommonReq req){
//        try{
//            Prize prize = customerService.doLottery(req.getLoginName());
//            if(prize == null){
//                return new MyResp(CodeCons.SUCCESS, "本次抽奖未中奖，请您再接再厉", null);
//            }
//            return new MyResp(CodeCons.SUCCESS, "", prize);
//        }catch(BizException e){
//            logger.error("customer-doLottery-BizException", e);
//            return new MyResp(e.getCode(), e.getErrMsg());
//        }catch(Exception e){
//            logger.error("customer-doLottery-Exception", e);
//        }
//        return new MyResp(CodeCons.ERROR, "请求失败");
//    }

}