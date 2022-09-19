package com.coin.web.controller;

import com.coin.entity.TContestEvent;
import com.coin.req.ContestEventReq;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.ContestEventService;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.ParamUtil;
import com.coin.web.annotation.OfficeSecure;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/contestEvent")
public class ContestEventController {

    private static final Logger logger = LoggerFactory.getLogger(ContestEventController.class);

    @Resource
    private ContestEventService contestEventService;

    @PostMapping("/pageList")
    @OfficeSecure(fastQuery = true)
    public MyResp pageList(@RequestBody ContestEventReq req){
        logger.info("contestEvent-pageList-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getPageNum(), "页码", req.getPageSize(), "分页大小");
            if(valid != null){
                return valid;
            }
            PageInfo<TContestEvent> page = contestEventService.pageList(req);
            return new MyResp(CodeCons.SUCCESS, "", page);
        }catch(BizException e){
            logger.error("contestEvent-pageList-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contestEvent-pageList-error", e);
        }
        return new MyResp(CodeCons.ERROR, "查询失败");
    }

    @PostMapping("/add")
    @OfficeSecure
    public MyResp add(@RequestBody ContestEventReq req){
        logger.info("contestEvent-add-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getEventTitle(), "标题", req.getIsJump(), "是否跳转", req.getEventPic(), "图片",
                    req.getEventTag(), "活动标签", req.getIsPublish(), "是否发布");
            if(valid != null){
                return valid;
            }
            if(req.getIsJump().intValue() == 1){
                if(StringUtils.isBlank(req.getJumpUrl())){
                    return new MyResp(CodeCons.ERROR, "跳转地址 不能为空");
                }
            }
            contestEventService.add(req);
            return new MyResp(CodeCons.SUCCESS, "添加成功");
        }catch(BizException e){
            logger.error("contestEvent-add-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contestEvent-add-error", e);
        }
        return new MyResp(CodeCons.ERROR, "修改失败");
    }

    @PostMapping("/update")
    @OfficeSecure
    public MyResp update(@RequestBody ContestEventReq req){
        logger.info("contestEvent-update-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getId(), "id");
            if(valid != null){
                return valid;
            }
            contestEventService.update(req);
            return new MyResp(CodeCons.SUCCESS, "保存成功");
        }catch(BizException e){
            logger.error("contestEvent-update-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contestEvent-update-error", e);
        }
        return new MyResp(CodeCons.ERROR, "修改失败");
    }

    @PostMapping("/del")
    @OfficeSecure
    public MyResp del(@RequestBody ContestEventReq req){
        logger.info("contestEvent-del-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getId(), "id");
            if(valid != null){
                return valid;
            }
            contestEventService.delete(req.getId(), req.getLoginName());
            return new MyResp(CodeCons.SUCCESS, "删除成功");
        }catch(BizException e){
            logger.error("contestEvent-del-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contestEvent-del-error", e);
        }
        return new MyResp(CodeCons.ERROR, "删除失败");
    }

}