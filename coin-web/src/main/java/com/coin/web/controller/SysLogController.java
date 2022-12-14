package com.coin.web.controller;

import com.coin.req.SysLogReq;
import com.coin.rsp.SysLogAgentRsp;
import com.coin.rsp.SysLogRsp;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.SysLogService;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.ParamUtil;
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
@RequestMapping("/sysLog")
public class SysLogController {

    private static final Logger logger = LoggerFactory.getLogger(SysLogController.class);

    @Resource
    private SysLogService sysLogService;

    @PostMapping("/pageList")
    @OfficeSecure
    public MyResp pageList(@RequestBody SysLogReq req){
        logger.info("sysLog-pageList-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getPageNum(), "页码", req.getPageSize(), "分页大小");
            if(valid != null){
                return valid;
            }
            req.setLogTypes("1,2");
            PageInfo<SysLogRsp> page = sysLogService.pageList(req);
            return new MyResp(CodeCons.SUCCESS, "", page);
        }catch(BizException e){
            logger.error("sysLog-pageList-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("sysLog-pageList-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/pageAgentLogList")
    @OfficeSecure
    public MyResp pageAgentLogList(@RequestBody SysLogReq req){
        logger.info("sysLog-pageAgentLogList-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getPageNum(), "页码", req.getPageSize(), "分页大小");
            if(valid != null){
                return valid;
            }
            req.setLogTypes("4,5,6,7");
            PageInfo<SysLogRsp> page = sysLogService.pageList(req);
            return new MyResp(CodeCons.SUCCESS, "", page);
        }catch(BizException e){
            logger.error("sysLog-pageAgentLogList-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("sysLog-pageAgentLogList-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @RequestMapping("/exportDatas")
    @OfficeSecure(doDownLoad = true)
    public MyResp exportDatas(SysLogReq req, HttpServletResponse response){
        logger.info("sysLog-exportDatas-req={}", req);
        try{
            req.setPageNum(1);
            req.setPageSize(20000);
            req.setLogTypes("1,2");
            PageInfo<SysLogRsp> page = sysLogService.pageList(req);
            List<SysLogRsp> sysLogRsps = page.getList();
            FileUtil.exportExcel(sysLogRsps, SysLogRsp.class, "操作日志.xlsx", response);
        }catch(BizException e){
            logger.error("sysLog-exportDatas-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("sysLog-exportDatas-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "导出失败");
    }

    @RequestMapping("/exportAgentDatas")
    @OfficeSecure(doDownLoad = true)
    public MyResp exportAgentDatas(SysLogReq req, HttpServletResponse response){
        logger.info("sysLog-exportAgentDatas-req={}", req);
        try{
            req.setPageNum(1);
            req.setPageSize(20000);
            req.setLogTypes("4,5,6,7");
            req.setOrderBy(" id desc");
            List<SysLogAgentRsp> list = sysLogService.getAgentLogList(req);
            FileUtil.exportExcel(list, SysLogAgentRsp.class, "操作日志.xlsx", response);
        }catch(BizException e){
            logger.error("sysLog-exportAgentDatas-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("sysLog-exportAgentDatas-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "导出失败");
    }

}
