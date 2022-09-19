package com.coin.web.controller;

import com.coin.req.CommonReq;
import com.coin.req.ContestSponsorshipLogoReq;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.ContestSponsorshipLogoService;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.ParamUtil;
import com.coin.web.annotation.OfficeSecure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/contestSponsorshipLogo")
public class ContestSponsorshipLogoController {

    private static final Logger logger = LoggerFactory.getLogger(ContestSponsorshipLogoController.class);

    @Resource
    private ContestSponsorshipLogoService contestSponsorshipLogoService;

    @PostMapping("/add")
    @OfficeSecure
    public MyResp add(@RequestBody ContestSponsorshipLogoReq req){
        logger.info("contestSponsorshipLogo-add-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getUrl(), "url", req.getShortNum(), "序号");
            if(valid != null){
                return valid;
            }
            contestSponsorshipLogoService.add(req);
            return new MyResp(CodeCons.SUCCESS, "保存成功");
        }catch(BizException e){
            logger.error("contestSponsorshipLogo-add-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contestSponsorshipLogo-add-error", e);
        }
        return new MyResp(CodeCons.ERROR, "保存失败");
    }

    @PostMapping("/del")
    @OfficeSecure
    public MyResp del(@RequestBody CommonReq req){
        logger.info("contestSponsorshipLogo-del-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getId(), "id");
            if(valid != null){
                return valid;
            }
            contestSponsorshipLogoService.delete(req.getId(), req.getLoginName());
            return new MyResp(CodeCons.SUCCESS, "删除成功");
        }catch(BizException e){
            logger.error("contestSponsorshipLogo-del-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contestSponsorshipLogo-del-error", e);
        }
        return new MyResp(CodeCons.ERROR, "删除失败");
    }

}