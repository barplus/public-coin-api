package com.coin.web.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.coin.req.AgentConfigReq;
import com.coin.rsp.AgentConfigRsp;
import com.coin.service.AgentConfigService;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.DateUtil;
import com.coin.service.util.ParamUtil;
import com.coin.web.annotation.CommonSecure;
import com.coin.web.annotation.OfficeSecure;
import com.coin.web.utils.FileUtil;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/agentConfig")
public class AgentConfigController {

    private static final Logger logger = LoggerFactory.getLogger(AgentConfigController.class);

    @Value("${upload.url}")
    private String picUrl;
    @Resource
    private AgentConfigService agentConfigService;

    @PostMapping("/add")
    @OfficeSecure
    public MyResp add(@RequestBody AgentConfigReq req){
        logger.info("agentConfig-add-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getUserName(), "业务人员");
            if(valid != null){
                return valid;
            }
            String activityLink = agentConfigService.add(req);
            return new MyResp(CodeCons.SUCCESS, "保存成功", activityLink);
        }catch(BizException e){
            logger.error("agentConfig-add-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("agentConfig-add-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/getByAgentCode")
    @CommonSecure(needLogin = false)
    public MyResp getByAgentCode(@RequestBody AgentConfigReq req){
        logger.info("agentConfig-getByAgentCode-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getAgentCode(), "代理号码");
            if(valid != null){
                return valid;
            }
            AgentConfigRsp rsp = agentConfigService.getByAgentCode(req);
            return new MyResp(CodeCons.SUCCESS, "", rsp);
        }catch(BizException e){
            logger.error("agentConfig-getByAgentCode-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("agentConfig-getByAgentCode-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @RequestMapping(value = "/importBatchAdd")
    @OfficeSecure
    public MyResp importCustomerList(AgentConfigReq req, @RequestPart("file") MultipartFile file) {
        logger.info("agentConfig-importBatchAdd-req={}", req);
        ImportParams params = new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(1);
        try {
            List<AgentConfigRsp> list = ExcelImportUtil.importExcel(file.getInputStream(), AgentConfigRsp.class, params);
            String fileName = DateUtil.getTodayStr(DateUtil.ms_dt_format) + file.getOriginalFilename();
            File newFile = new File(picUrl +'/'+ fileName);
            if (!newFile.getParentFile().exists()) {
                newFile.getParentFile().mkdirs();
            }
            file.transferTo(newFile);

            agentConfigService.importAgentConfigList(list, req.getLoginName(), fileName);
            return new MyResp(CodeCons.SUCCESS, "导入成功");
        } catch (BizException e) {
            logger.error("agentConfig-importBatchAdd-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        } catch (Exception e) {
            logger.error("agentConfig-importBatchAdd-error", e);
        }
        return new MyResp(CodeCons.ERROR, "导入失败");
    }

    @PostMapping("/update")
    @OfficeSecure
    public MyResp update(@RequestBody AgentConfigReq req){
        logger.info("agentConfig-add-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getId(), "id", req.getUserName(), "userName");
            if(valid != null){
                return valid;
            }
            agentConfigService.update(req);
            return new MyResp(CodeCons.SUCCESS, "保存成功");
        }catch(BizException e){
            logger.error("agentConfig-update-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("agentConfig-update-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/delete")
    @OfficeSecure
    public MyResp delete(@RequestBody AgentConfigReq req){
        logger.info("agentConfig-delete-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getId(), "id");
            if(valid != null){
                return valid;
            }
            agentConfigService.delete(req.getId(), req.getLoginName());
            return new MyResp(CodeCons.SUCCESS, "删除成功");
        }catch(BizException e){
            logger.error("agentConfig-delete-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("agentConfig-delete-error", e);
        }
        return new MyResp(CodeCons.ERROR, "删除失败");
    }

    @PostMapping("/pageDatas")
    @OfficeSecure(fastQuery = true)
    public MyResp pageList(@RequestBody AgentConfigReq req){
        logger.info("custPrize-pageDatas-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getPageNum(), "页码", req.getPageSize(), "分页大小");
            if(valid != null){
                return valid;
            }
            PageInfo<AgentConfigRsp> page = agentConfigService.pageList(req);
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
    @OfficeSecure(doDownLoad = true)
    public MyResp exportDatas(AgentConfigReq req, HttpServletResponse response){
        logger.info("agentConfig-exportDatas-req={}", req);
        try{
            req.setPageNum(1);
            req.setPageSize(20000);
            PageInfo<AgentConfigRsp> page = agentConfigService.pageList(req);
            List<AgentConfigRsp> rsps = page.getList();
            FileUtil.exportExcel(rsps, AgentConfigRsp.class, DateUtil.getTodayStr()+"代理招商配置.xlsx", response);
        }catch(BizException e){
            logger.error("agentConfig-exportDatas-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("agentConfig-exportDatas-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "导出失败");
    }

}
