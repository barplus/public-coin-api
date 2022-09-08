package com.coin.web.controller;

import com.coin.entity.TAgentEventConfig;
import com.coin.req.AgentEventReq;
import com.coin.service.AgentEventService;
import com.coin.service.BizEntity.MyResp;
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
@RequestMapping("/agentEvent")
public class AgentEventController {

    private static final Logger logger = LoggerFactory.getLogger(AgentEventController.class);

    @Resource
    private AgentEventService agentEventService;

    @PostMapping("/add")
    @OfficeSecure
    public MyResp add(@RequestBody AgentEventReq req){
        logger.info("agentEvent-add-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getEventIndex(), "活动序号", req.getStatus(), "状态",
                    req.getEventName(), "活动名称");
            if(valid != null){
                return valid;
            }
            agentEventService.addEvent(req);
            return new MyResp(CodeCons.SUCCESS, "保存成功");
        }catch(BizException e){
            logger.error("agentEvent-add-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("agentEvent-add-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/update")
    @OfficeSecure
    public MyResp update(@RequestBody AgentEventReq req){
        logger.info("agentEvent-update-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getId(), "id", req.getEventIndex(), "活动序号", req.getStatus(), "状态",
                    req.getEventName(), "活动名称");
            if(valid != null){
                return valid;
            }
            agentEventService.update(req);
            return new MyResp(CodeCons.SUCCESS, "保存成功");
        }catch(BizException e){
            logger.error("agentEvent-update-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("agentEvent-update-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/getByIndex")
    @OfficeSecure
    public MyResp getByIndex(@RequestBody AgentEventReq req){
        logger.info("agentEvent-getByIndex-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getEventIndex(), "活动序号");
            if(valid != null){
                return valid;
            }
            TAgentEventConfig agentEventConfig = agentEventService.getByIndex(req.getEventIndex());
            return new MyResp(CodeCons.SUCCESS, "", agentEventConfig);
        }catch(BizException e){
            logger.error("agentEvent-getByIndex-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("agentEvent-getByIndex-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

}
