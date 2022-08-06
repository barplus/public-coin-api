package com.coin.web.controller;

import com.coin.entity.Prize;
import com.coin.req.PrizeReq;
import com.coin.rsp.PrizeRsp;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.PrizeService;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.ParamUtil;
import com.coin.web.annotation.OfficeSecure;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/prize")
public class PrizeController {

    private static final Logger logger = LoggerFactory.getLogger(PrizeController.class);

    @Resource
    private PrizeService prizeService;

    @PostMapping("/add")
    @OfficeSecure
    public MyResp login(@RequestBody PrizeReq req) {
        logger.info("prize-login-req={}", req);
        try {
            MyResp valid = ParamUtil.NotBlankValid(req.getPrizeName(), "奖品名称", req.getAmount(), "奖品价值",
                    req.getMaxNum(), "总投放数", req.getRate(), "中奖率");
            if (valid != null) {
                return valid;
            }
            prizeService.addPrize(req);
            return new MyResp(CodeCons.SUCCESS, "保存成功");
        }catch (BizException e){
            logger.error("prize-add-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("prize-add-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/updateStatus")
    @OfficeSecure
    public MyResp updateStatus(@RequestBody PrizeReq req) {
        logger.info("prize-updateStatus-req={}", req);
        try {
            MyResp valid = ParamUtil.NotBlankValid(req.getId(), "id", req.getStatus(), "状态");
            if (valid != null) {
                return valid;
            }
            prizeService.updateStatus(req);
            return new MyResp(CodeCons.SUCCESS, "修改成功");
        }catch (BizException e){
            logger.error("prize-updateStatus-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("prize-updateStatus-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/updateInfo")
    @OfficeSecure
    public MyResp updateInfo(@RequestBody PrizeReq req) {
        logger.info("prize-updateInfo-req={}", req);
        try {
            MyResp valid = ParamUtil.NotBlankValid(req.getId(), "id");
            if (valid != null) {
                return valid;
            }
            prizeService.updateInfo(req);
            return new MyResp(CodeCons.SUCCESS, "保存成功");
        }catch (BizException e){
            logger.error("prize-updateInfo-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("prize-updateInfo-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/pageList")
    @OfficeSecure
    public MyResp pageList(@RequestBody PrizeReq req){
        logger.info("prize-pageList-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getPageNum(), "页码", req.getPageSize(), "分页大小");
            if(valid != null){
                return valid;
            }
            req.setNameLike("Y");
            PageInfo<Prize> page = prizeService.pageList(req);
            return new MyResp(CodeCons.SUCCESS, "", page);
        }catch(Exception e){
            logger.error("prize-pageList-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/prizeList")
    public MyResp prizeList(@RequestBody PrizeReq req){
        logger.info("prize-prizeList-req={}", req);
        try{
            List<PrizeRsp> list = prizeService.pageDatas(req);
            return new MyResp(CodeCons.SUCCESS, "", list);
        }catch(Exception e){
            logger.error("prize-prizeList-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

}
