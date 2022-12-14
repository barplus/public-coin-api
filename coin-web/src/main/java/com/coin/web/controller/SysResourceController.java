package com.coin.web.controller;

import com.coin.req.SysResourceReq;
import com.coin.rsp.SysResourceRsp;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.SysResourceService;
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
import java.util.List;

@RestController
@RequestMapping("/resource")
public class SysResourceController {

    private static final Logger logger = LoggerFactory.getLogger(SysResourceController.class);

    @Resource
    private SysResourceService resourceService;

    @PostMapping("/add")
    @OfficeSecure
    public MyResp add(@RequestBody SysResourceReq req){
        logger.info("resource-add-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getResourceType(), "资源类型", req.getResourceCode(), "资源编码",
                    req.getResourceName(), "资源名称");
            if(valid != null){
                return valid;
            }
            resourceService.addSysResource(req);
            return new MyResp(CodeCons.SUCCESS, "添加成功");
        }catch(BizException e){
            logger.error("resource-add-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("resource-add-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "添加失败");
    }

    @PostMapping("/del")
    @OfficeSecure
    public MyResp del(@RequestBody SysResourceReq req){
        logger.info("resource-del-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getResourceCode(), "资源编码");
            if(valid != null){
                return valid;
            }
            resourceService.deleteByCode(req.getResourceCode());
            return new MyResp(CodeCons.SUCCESS, "删除成功");
        }catch(BizException e){
            logger.error("resource-del-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("resource-del-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "删除失败");
    }

    @PostMapping("/update")
    @OfficeSecure
    public MyResp update(@RequestBody SysResourceReq req){
        logger.info("resource-update-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getId(), "id");
            if(valid != null){
                return valid;
            }
            resourceService.update(req);
            return new MyResp(CodeCons.SUCCESS, "保存成功");
        }catch(BizException e){
            logger.error("resource-update-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("resource-update-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "保存失败");
    }

    @PostMapping("/queryList")
    @OfficeSecure(fastQuery = true)
    public MyResp pageList(@RequestBody SysResourceReq req){
        logger.info("resource-queryList-req={}", req);
        try{
            List<SysResourceRsp> list = resourceService.getSysResources(req);
            return new MyResp(CodeCons.SUCCESS, "", list);
        }catch(BizException e){
            logger.error("resource-queryList-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("resource-queryList-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/getAllSysResources")
    @OfficeSecure
    public MyResp getAllSysResources(@RequestBody SysResourceReq req){
        logger.info("resource-getAllSysResources-req={}", req);
        try{
            List<SysResourceRsp> list = resourceService.getAllSysResources(req.getRoleCode(), req.getOnlyAuth());
            return new MyResp(CodeCons.SUCCESS, "", list);
        }catch(BizException e){
            logger.error("resource-getAllSysResources-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("resource-getAllSysResources-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

}
