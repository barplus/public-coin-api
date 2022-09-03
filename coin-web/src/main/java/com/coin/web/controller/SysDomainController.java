package com.coin.web.controller;

import com.coin.entity.TSysDomain;
import com.coin.req.SysDomainReq;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.SysDomainService;
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

@RestController
@RequestMapping("/domain")
public class SysDomainController {

    private static final Logger logger = LoggerFactory.getLogger(SysDomainController.class);

    @Resource
    private SysDomainService domainService;

    @PostMapping("/pageList")
    @OfficeSecure(fastQuery = true)
    public MyResp pageList(@RequestBody SysDomainReq req){
        logger.info("domain-pageList-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getPageNum(), "页码", req.getPageSize(), "分页大小");
            if(valid != null){
                return valid;
            }
            PageInfo<TSysDomain> page = domainService.pageList(req);
            return new MyResp(CodeCons.SUCCESS, "", page);
        }catch(BizException e){
            logger.error("domain-pageList-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("domain-pageList-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/createBatch")
    @OfficeSecure
    public MyResp createBatch(@RequestBody SysDomainReq req){
        logger.info("domain-createBatch-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getSysName(), "系统名称", req.getDomainUrl(), "域名地址", req.getNum(), "数量");
            if(valid != null){
                return valid;
            }
            domainService.createBatch(req);
            return new MyResp(CodeCons.SUCCESS, "生成成功");
        }catch(BizException e){
            logger.error("domain-createBatch-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("domain-createBatch-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "生成失败");
    }

    @PostMapping("/update")
    @OfficeSecure
    public MyResp update(@RequestBody SysDomainReq req){
        logger.info("domain-update-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getId(), "id");
            if(valid != null){
                return valid;
            }
            domainService.update(req);
            return new MyResp(CodeCons.SUCCESS, "修改成功");
        }catch(BizException e){
            logger.error("domain-update-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("domain-update-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "修改失败");
    }

}
