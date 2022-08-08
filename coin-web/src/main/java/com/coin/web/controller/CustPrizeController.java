package com.coin.web.controller;

import com.coin.entity.CustPrize;
import com.coin.req.CustPrizeReq;
import com.coin.rsp.CustPrizeRsp;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.CustPrizeService;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.ParamUtil;
import com.coin.web.annotation.CommonSecure;
import com.coin.web.annotation.OfficeSecure;
import com.coin.web.utils.FileUtil;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
            MyResp valid = ParamUtil.NotBlankValid(req.getPageNum(), "页码", req.getPageSize(), "分页大小");
            if(valid != null){
                return valid;
            }
            PageInfo<CustPrize> page = custPrizeService.pageList(req);
            return new MyResp(CodeCons.SUCCESS, "", page);
        }catch(BizException e){
            logger.error("custPrize-pageList-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("custPrize-pageList-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/pageDatas")
    @OfficeSecure
    public MyResp pageDatas(@RequestBody CustPrizeReq req){
        logger.info("custPrize-pageDatas-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getPageNum(), "页码", req.getPageSize(), "分页大小");
            if(valid != null){
                return valid;
            }
            PageInfo<CustPrizeRsp> page = custPrizeService.pageDatas(req);
            return new MyResp(CodeCons.SUCCESS, "", page);
        }catch(BizException e){
            logger.error("custPrize-pageDatas-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("custPrize-pageDatas-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @RequestMapping("/exportDatas")
    @OfficeSecure
    public void exportDatas(@RequestBody CustPrizeReq req, HttpServletResponse response){
        logger.info("custPrize-exportDatas-req={}", req);
        try{
            req.setPageNum(1);
            req.setPageSize(20000);
            PageInfo<CustPrizeRsp> page = custPrizeService.pageDatas(req);
            List<CustPrizeRsp> custPrizeRsps = page.getList();
            FileUtil.exportExcel(custPrizeRsps, CustPrizeRsp.class, "中奖记录.xlsx", response);
        }catch(BizException e){
            logger.error("custPrize-exportDatas-BizException", e);
        }catch(Exception e){
            logger.error("custPrize-exportDatas-Exception", e);
        }
    }

    @PostMapping("/custPrizeRecord")
    public MyResp custPrizeRecord(){
        try{
            List<String> list = custPrizeService.custPrizeRecord();
            return new MyResp(CodeCons.SUCCESS, "", list);
        }catch(BizException e){
            logger.error("custPrize-custPrizeRecord-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("custPrize-custPrizeRecord-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

}
