package com.coin.web.controller;

import com.coin.req.ContestReq;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.ContestService;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.web.annotation.OfficeSecure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/contest")
public class ContestController {

    private static final Logger logger = LoggerFactory.getLogger(ContestController.class);

    @Resource
    private ContestService contestService;

    @PostMapping("/add")
    @OfficeSecure
    public MyResp update(@RequestBody ContestReq req){
        logger.info("user-update-req={}", req);
        try{
//            MyResp valid = ParamUtil.NotBlankValid(req.getId(), "id");
//            if(valid != null){
//                return valid;
//            }
//            userService.update(req);
            return new MyResp(CodeCons.SUCCESS, "修改成功");
        }catch(BizException e){
            logger.error("user-update-error", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("user-update-error", e);
        }
        return new MyResp(CodeCons.ERROR, "修改失败");
    }

}