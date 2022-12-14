package com.coin.web.controller;

import com.coin.req.ContestReq;
import com.coin.rsp.ContestRsp;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.ContestService;
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
import java.util.List;

@RestController
@RequestMapping("/contest")
public class ContestController {

    private static final Logger logger = LoggerFactory.getLogger(ContestController.class);

    @Resource
    private ContestService contestService;

    @PostMapping("/add")
    @OfficeSecure
    public MyResp add(@RequestBody ContestReq req){
        logger.info("contest-add-req={}", req);
        try{
            MyResp valid1 = ParamUtil.NotBlankValid(req.getContestType(), "比赛类型", req.getContestName(), "联赛名称",
                    req.getIsHot(), "是否热门", req.getIsRecommend(), "是否推单", req.getTeamFirst(), "主队名称", req.getTeamSecond(), "客户名称",
                    req.getTeamFirstPic(), "主队Logo", req.getTeamSecondPic(), "客队Logo", req.getContestDate(), "开赛时间",
                    req.getShowDateStart(), "开始展示时间", req.getShowDateEnd(), "结束展示时间");
            if(valid1 != null){
                return valid1;
            }
            if(req.getIsRecommend().intValue() == 1){
                MyResp valid2 = ParamUtil.NotBlankValid(req.getTeamFirstWinNum(), "主队胜利场数", req.getTeamFirstWinRate(), "主队赢盘率",
                        req.getTeamFirstAvgNum(), "主队场均进球", req.getTeamFirstAvgLossNum(), "主队场均失球", req.getTeamSecondWinNum(), "客队胜利场数",
                        req.getTeamSecondWinRate(), "客队赢盘率", req.getTeamSecondAvgNum(), "客队场均进球数", req.getTeamSecondAvgLossNum(), "客队场均失球数",
                        req.getTeamFirstWinOdds(), "主队胜赔率", req.getDrawOdds(), "平局赔率", req.getTeamSecondWinOdds(), "客队胜赔率",
                        req.getTeamFirstConcedeOdds(), "主队让球和赔率", req.getTeamSecondConcedeOdds(), "客队让球和赔率", req.getTeamFirstBigSmallOdds(),
                        "主队大/小球和赔率", req.getTeamSecondBigSmallOdds(), "客队大/小球和赔率", req.getRecommendOdds(), "推荐", req.getContestAnalysis(), "赛事分析");
                if(valid2 != null){
                    return valid2;
                }
            }
            contestService.addContest(req);
            return new MyResp(CodeCons.SUCCESS, "添加成功");
        }catch(BizException e){
            logger.error("contest-add-error", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contest-add-error", e);
        }
        return new MyResp(CodeCons.ERROR, "添加失败");
    }

    @PostMapping("/update")
    @OfficeSecure
    public MyResp update(@RequestBody ContestReq req){
        logger.info("contest-update-req={}", req);
        try{
            MyResp valid1 = ParamUtil.NotBlankValid(req.getId(), "id", req.getContestType(), "比赛类型", req.getContestName(), "联赛名称",
                    req.getIsHot(), "是否热门", req.getIsRecommend(), "是否推单", req.getTeamFirst(), "主队名称", req.getTeamSecond(), "客户名称",
                    req.getTeamFirstPic(), "主队Logo", req.getTeamSecondPic(), "客队Logo", req.getContestDate(), "开赛时间",
                    req.getShowDateStart(), "开始展示时间", req.getShowDateEnd(), "结束展示时间", req.getIsPublish(), "是否发布");
            if(valid1 != null){
                return valid1;
            }
            if(req.getIsRecommend() != null && req.getIsRecommend().intValue() == 1){
                MyResp valid2 = ParamUtil.NotBlankValid(req.getTeamFirstWinNum(), "主队胜利场数", req.getTeamFirstWinRate(), "主队赢盘率",
                        req.getTeamFirstAvgNum(), "主队场均进球", req.getTeamFirstAvgLossNum(), "主队场均失球", req.getTeamSecondWinNum(), "客队胜利场数",
                        req.getTeamSecondWinRate(), "客队赢盘率", req.getTeamSecondAvgNum(), "客队场均进球数", req.getTeamSecondAvgLossNum(), "客队场均失球数",
                        req.getTeamFirstWinOdds(), "主队胜赔率", req.getDrawOdds(), "平局赔率", req.getTeamSecondWinOdds(), "客队胜赔率",
                        req.getTeamFirstConcedeOdds(), "主队让球和赔率", req.getTeamSecondConcedeOdds(), "客队让球和赔率", req.getTeamFirstBigSmallOdds(),
                        "主队大/小球和赔率", req.getTeamSecondBigSmallOdds(), "客队大/小球和赔率", req.getRecommendOdds(), "推荐", req.getContestAnalysis(), "赛事分析");
                if(valid2 != null){
                    return valid2;
                }
            }
            contestService.update(req);
            return new MyResp(CodeCons.SUCCESS, "保存成功");
        }catch(BizException e){
            logger.error("contest-update-error", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contest-update-error", e);
        }
        return new MyResp(CodeCons.ERROR, "保存失败");
    }

    @PostMapping("/updateResult")
    @OfficeSecure
    public MyResp updateResult(@RequestBody ContestReq req){
        logger.info("contest-updateResult-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getId(), "id");
            if(valid != null){
                return valid;
            }
            contestService.updateResult(req);
            return new MyResp(CodeCons.SUCCESS, "保存成功");
        }catch(BizException e){
            logger.error("contest-updateResult-error", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contest-updateResult-error", e);
        }
        return new MyResp(CodeCons.ERROR, "保存失败");
    }

    @PostMapping("/delResultBatch")
    @OfficeSecure
    public MyResp delResultBatch(@RequestBody ContestReq req){
        logger.info("contest-delResultBatch-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getIds(), "ids");
            if(valid != null){
                return valid;
            }
            contestService.delResultBatch(req);
            return new MyResp(CodeCons.SUCCESS, "保存成功");
        }catch(BizException e){
            logger.error("contest-delResultBatch-error", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contest-delResultBatch-error", e);
        }
        return new MyResp(CodeCons.ERROR, "保存失败");
    }

    @PostMapping("/updateStatus")
    @OfficeSecure
    public MyResp updateStatus(@RequestBody ContestReq req){
        logger.info("contest-updateStatus-req={}", req);
        try{
            MyResp valid1 = ParamUtil.NotBlankValid(req.getId(), "id", req.getStatus(), "status");
            if(valid1 != null){
                return valid1;
            }
            contestService.updateStatus(req);
            return new MyResp(CodeCons.SUCCESS, "修改成功");
        }catch(BizException e){
            logger.error("contest-updateStatus-error", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contest-updateStatus-error", e);
        }
        return new MyResp(CodeCons.ERROR, "修改失败");
    }

    @PostMapping("/del")
    @OfficeSecure
    public MyResp del(@RequestBody ContestReq req){
        logger.info("contest-del-req={}", req);
        try{
            if(req.getId() == null && StringUtils.isBlank(req.getIds())){
                return new MyResp(CodeCons.ERROR, "id 不能为空");
            }
            contestService.delete(req);
            return new MyResp(CodeCons.SUCCESS, "删除成功");
        }catch(BizException e){
            logger.error("contest-del-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contest-del-error", e);
        }
        return new MyResp(CodeCons.ERROR, "删除失败");
    }

    @PostMapping("/getListByType")
    @CommonSecure(needLogin = false, fastQuery = true)
    public MyResp getListByType(@RequestBody ContestReq req){
        logger.info("contest-getListByType-req={}", req);
        try{
            List<ContestRsp> list = contestService.getListByType(req);
            return new MyResp(CodeCons.SUCCESS, "", list);
        }catch(BizException e){
            logger.error("contest-getListByType-error", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contest-getListByType-error", e);
        }
        return new MyResp(CodeCons.ERROR, "查询失败");
    }

    @PostMapping("/getResultByType")
    @CommonSecure(needLogin = false, fastQuery = true)
    public MyResp getResultByType(@RequestBody ContestReq req){
        logger.info("contest-getResultByType-req={}", req);
        try{
            req.setQueryResult(true);
            req.setIsHot(1);
            req.setNeedDetail(2);
            List<ContestRsp> list = contestService.getListByType(req);
            return new MyResp(CodeCons.SUCCESS, "", list);
        }catch(BizException e){
            logger.error("contest-getResultByType-error", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contest-getResultByType-error", e);
        }
        return new MyResp(CodeCons.ERROR, "查询失败");
    }

    @PostMapping("/getById")
    @CommonSecure(needLogin = false, fastQuery = true)
    public MyResp getById(@RequestBody ContestReq req){
        logger.info("contest-getById-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getId(), "id");
            if(valid != null){
                return valid;
            }
            ContestRsp rsp = contestService.getById(req.getId());
            return new MyResp(CodeCons.SUCCESS, "", rsp);
        }catch(BizException e){
            logger.error("contest-getById-error", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contest-getById-error", e);
        }
        return new MyResp(CodeCons.ERROR, "查询失败");
    }

    @PostMapping("/pageList")
    @OfficeSecure
    public MyResp getDatasByType(@RequestBody ContestReq req){
        logger.info("contest-pageList-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getPageNum(), "pageNum", req.getPageSize(), "pageSize");
            if(valid != null){
                return valid;
            }
            PageInfo<ContestRsp> page = contestService.pageList(req);
            return new MyResp(CodeCons.SUCCESS, "", page);
        }catch(BizException e){
            logger.error("contest-pageList-error", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contest-pageList-error", e);
        }
        return new MyResp(CodeCons.ERROR, "查询失败");
    }

    @PostMapping("/pageResultList")
    @OfficeSecure
    public MyResp pageResultList(@RequestBody ContestReq req){
        logger.info("contest-pageResultList-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getPageNum(), "pageNum", req.getPageSize(), "pageSize");
            if(valid != null){
                return valid;
            }
            req.setQueryResult(true);
            req.setIsHot(1);
            req.setNeedDetail(2);
            PageInfo<ContestRsp> page = contestService.pageList(req);
            return new MyResp(CodeCons.SUCCESS, "", page);
        }catch(BizException e){
            logger.error("contest-pageResultList-error", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contest-pageResultList-error", e);
        }
        return new MyResp(CodeCons.ERROR, "查询失败");
    }

}