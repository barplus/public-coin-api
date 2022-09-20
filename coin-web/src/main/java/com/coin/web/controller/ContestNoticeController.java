package com.coin.web.controller;

import com.coin.entity.TContestNotice;
import com.coin.req.ContestNoticeReq;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.ContestNoticeService;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.ParamUtil;
import com.coin.web.annotation.CommonSecure;
import com.coin.web.annotation.OfficeSecure;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/contestNotice")
public class ContestNoticeController {

    private static final Logger logger = LoggerFactory.getLogger(ContestNoticeController.class);

    @Resource
    private ContestNoticeService contestNoticeService;

    @PostMapping("/pageList")
    @OfficeSecure(fastQuery = true)
    public MyResp pageList(@RequestBody ContestNoticeReq req){
        logger.info("contestNotice-pageList-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getPageNum(), "页码", req.getPageSize(), "分页大小");
            if(valid != null){
                return valid;
            }
            PageInfo<TContestNotice> page = contestNoticeService.pageList(req);
            return new MyResp(CodeCons.SUCCESS, "", page);
        }catch(BizException e){
            logger.error("contestNotice-pageList-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contestNotice-pageList-error", e);
        }
        return new MyResp(CodeCons.ERROR, "查询失败");
    }

    @PostMapping("/getList")
    @CommonSecure
    public MyResp getList(@RequestBody ContestNoticeReq req){
        logger.info("contestNotice-getList-req={}", req);
        try{
            Date now = new Date();
            req.setPageNum(1);
            req.setPageSize(10000);
            req.setShowDate(now);
            req.setStatus(1);
            req.setIsPublish(1);
            req.setPublishDate(now);
            req.setTopDate(now);
            List<TContestNotice> list = contestNoticeService.pageList(req).getList();
            if(!CollectionUtils.isEmpty(list)){
                List<Integer> notInIdList = new ArrayList<>();
                for(TContestNotice contestNotice:list){
                    notInIdList.add(contestNotice.getId());
                }
                req.setNotInIdList(notInIdList);
            };
            req.setTopDate(null);
            list.addAll(contestNoticeService.pageList(req).getList());
            return new MyResp(CodeCons.SUCCESS, "", list);
        }catch(BizException e){
            logger.error("contestNotice-getList-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contestNotice-getList-error", e);
        }
        return new MyResp(CodeCons.ERROR, "查询失败");
    }

    @PostMapping("/add")
    @OfficeSecure
    public MyResp add(@RequestBody ContestNoticeReq req){
        logger.info("contestNotice-add-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getNoticeTitle(), "标题", req.getNoticeContent(), "内容",
                    req.getIsPublish(), "是否发布");
            if(valid != null){
                return valid;
            }
            contestNoticeService.add(req);
            return new MyResp(CodeCons.SUCCESS, "添加成功");
        }catch(BizException e){
            logger.error("contestNotice-add-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contestNotice-add-error", e);
        }
        return new MyResp(CodeCons.ERROR, "修改失败");
    }

    @PostMapping("/update")
    @OfficeSecure
    public MyResp update(@RequestBody ContestNoticeReq req){
        logger.info("contestNotice-update-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getId(), "id");
            if(valid != null){
                return valid;
            }
            contestNoticeService.update(req);
            return new MyResp(CodeCons.SUCCESS, "保存成功");
        }catch(BizException e){
            logger.error("contestNotice-update-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contestNotice-update-error", e);
        }
        return new MyResp(CodeCons.ERROR, "修改失败");
    }

    @PostMapping("/del")
    @OfficeSecure
    public MyResp del(@RequestBody ContestNoticeReq req){
        logger.info("contestNotice-del-req={}", req);
        try{
            if(req.getId() == null && StringUtils.isBlank(req.getIds())){
                return new MyResp(CodeCons.ERROR, "id 不能为空");
            }
            contestNoticeService.delete(req);
            return new MyResp(CodeCons.SUCCESS, "删除成功");
        }catch(BizException e){
            logger.error("contestNotice-del-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contestNotice-del-error", e);
        }
        return new MyResp(CodeCons.ERROR, "删除失败");
    }

}