package com.coin.web.controller;

import com.coin.entity.TContest;
import com.coin.req.ContestReq;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.ContestService;
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
@RequestMapping("/contest")
public class ContestController {

    private static final Logger logger = LoggerFactory.getLogger(ContestController.class);

    @Resource
    private ContestService contestService;

    @PostMapping("/add")
    @OfficeSecure
    public MyResp update(@RequestBody ContestReq req){
        logger.info("contest-add-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getContestType(), "比赛类型", req.getContestName(), "比赛名称",
                    req.getContestDate(), "比赛时间", req.getTeamFirst(), "甲队", req.getTeamSecond(), "乙队");
            if(valid != null){
                return valid;
            }
            contestService.addContest(req);
            return new MyResp(CodeCons.SUCCESS, "添加成功");
        }catch(BizException e){
            logger.error("contest-add-error", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contest-add-error", e);
        }
        return new MyResp(CodeCons.ERROR, "修改失败");
    }

    @PostMapping("/getListByType")
    @OfficeSecure
    public MyResp getListByType(@RequestBody ContestReq req){
        logger.info("contest-getListByType-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getContestType(), "比赛类型");
            if(valid != null){
                return valid;
            }
            List<TContest> list = contestService.getListByType(req.getContestType());
            return new MyResp(CodeCons.SUCCESS, "", list);
        }catch(BizException e){
            logger.error("contest-getListByType-error", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("contest-getListByType-error", e);
        }
        return new MyResp(CodeCons.ERROR, "查询失败");
    }

}