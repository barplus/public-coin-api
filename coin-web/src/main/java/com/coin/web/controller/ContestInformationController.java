package com.coin.web.controller;

import com.coin.entity.TContestInformation;
import com.coin.req.ContestInformationReq;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.ContestInformationService;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.ParamUtil;
import com.coin.web.annotation.CommonSecure;
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
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/contestInformation")
public class ContestInformationController {

    private static final Logger logger = LoggerFactory.getLogger(ContestInformationController.class);

    @Resource
    private ContestInformationService contestInformationService;

    @PostMapping("/pageList")
    @OfficeSecure(fastQuery = true)
    public MyResp pageList(@RequestBody ContestInformationReq req){
        logger.info("contestInformation-pageList-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getPageNum(), "页码", req.getPageSize(), "分页大小");
            if(valid != null){
                return valid;
            }
            PageInfo<TContestInformation> page = contestInformationService.pageList(req);
            return new MyResp(CodeCons.SUCCESS, "", page);
        }catch(BizException e){
            logger.error("contestInformation-pageList-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contestInformation-pageList-error", e);
        }
        return new MyResp(CodeCons.ERROR, "查询失败");
    }

    @PostMapping("/getList")
    @CommonSecure(needLogin = false)
    public MyResp getList(@RequestBody ContestInformationReq req){
        logger.info("contestInformation-getList-req={}", req);
        try{
            Date now = new Date();
            req.setPageNum(1);
            req.setPageSize(10000);
            req.setShowDate(now);
            req.setStatus(1);
            req.setIsPublish(1);
            req.setPublishDate(now);
            List<TContestInformation> list = contestInformationService.pageList(req).getList();
            return new MyResp(CodeCons.SUCCESS, "", list);
        }catch(BizException e){
            logger.error("contestInformation-getList-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contestInformation-getList-error", e);
        }
        return new MyResp(CodeCons.ERROR, "查询失败");
    }

    @PostMapping("/add")
    @OfficeSecure
    public MyResp add(@RequestBody ContestInformationReq req){
        logger.info("contestInformation-add-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getInformationTitle(), "标题", req.getInformationContent(), "内容",
                    req.getInformationPic(), "缩略图", req.getIsPublish(), "是否发布");
            if(valid != null){
                return valid;
            }
            contestInformationService.add(req);
            return new MyResp(CodeCons.SUCCESS, "添加成功");
        }catch(BizException e){
            logger.error("contestInformation-add-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contestInformation-add-error", e);
        }
        return new MyResp(CodeCons.ERROR, "修改失败");
    }

    @PostMapping("/update")
    @OfficeSecure
    public MyResp update(@RequestBody ContestInformationReq req){
        logger.info("contestInformation-update-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getId(), "id");
            if(valid != null){
                return valid;
            }
            contestInformationService.update(req);
            return new MyResp(CodeCons.SUCCESS, "保存成功");
        }catch(BizException e){
            logger.error("contestInformation-update-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contestInformation-update-error", e);
        }
        return new MyResp(CodeCons.ERROR, "修改失败");
    }

    @PostMapping("/del")
    @OfficeSecure
    public MyResp del(@RequestBody ContestInformationReq req){
        logger.info("contestInformation-del-req={}", req);
        try{
            if(req.getId() == null && StringUtils.isBlank(req.getIds())){
                return new MyResp(CodeCons.ERROR, "id 不能为空");
            }
            contestInformationService.delete(req);
            return new MyResp(CodeCons.SUCCESS, "删除成功");
        }catch(BizException e){
            logger.error("contestInformation-del-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contestInformation-del-error", e);
        }
        return new MyResp(CodeCons.ERROR, "删除失败");
    }

}