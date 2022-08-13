package com.coin.web.controller;

import com.coin.entity.Dict;
import com.coin.req.DictReq;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.DictService;
import com.coin.service.constant.CodeCons;
import com.coin.service.util.ParamUtil;
import com.coin.web.annotation.OfficeSecure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/dict")
public class DictController {

    private static final Logger logger = LoggerFactory.getLogger(DictController.class);

    @Resource
    private DictService dictService;

    @PostMapping("/getDicts")
    @OfficeSecure
    public MyResp pageList(@RequestBody DictReq req){
        logger.info("dict-getDicts-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getDictType());
            if(valid != null){
                return valid;
            }
            List<Dict> list = dictService.getListByType(req.getDictType());
            return new MyResp(CodeCons.SUCCESS, "", list);
        }catch(Exception e){
            logger.error("dict-getDicts-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

}
