package com.coin.service.impl;

import com.coin.entity.TContest;
import com.coin.entity.TContestDetail;
import com.coin.entity.TContestExample;
import com.coin.mapper.TContestDetailMapper;
import com.coin.mapper.TContestMapper;
import com.coin.mapper.ext.ContestMapper;
import com.coin.req.ContestReq;
import com.coin.rsp.ContestRsp;
import com.coin.service.ContestDetailService;
import com.coin.service.ContestService;
import com.coin.service.util.BizUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContestServiceImpl implements ContestService {

    private static final Logger logger = LoggerFactory.getLogger(ContestServiceImpl.class);

    @Resource
    private TContestMapper tContestMapper;
    @Resource
    private ContestMapper contestMapper;
    @Resource
    private TContestDetailMapper tContestDetailMapper;
    @Resource
    private ContestDetailService contestDetailService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addContest(ContestReq req) throws Exception {
        TContest contest = BizUtil.getInsertInfo(new TContest(), req.getLoginName(), new Date());
        contest.setContestType(req.getContestType());
        contest.setContestName(req.getContestName());
        contest.setIsHot(req.getIsHot());
        contest.setIsRecommend(req.getIsRecommend());
        contest.setTeamFirst(req.getTeamFirst());
        contest.setTeamFirstPic(req.getTeamFirstPic());
        contest.setTeamSecond(req.getTeamSecond());
        contest.setTeamSecondPic(req.getTeamSecondPic());
        contest.setContestDate(req.getContestDate());
        contest.setIsPublish(req.getIsPublish());
        contest.setShowDateStart(req.getShowDateStart());
        contest.setShowDateEnd(req.getShowDateEnd());
        tContestMapper.insertSelective(contest);

        if(req.getIsRecommend().intValue() == 1){
            TContestDetail detail = BizUtil.getInsertInfo(new TContestDetail(), req.getLoginName(), new Date());
            detail.setpId(contest.getId());
            detail.setTeamFirstWinNum(req.getTeamFirstWinNum());
            detail.setTeamSecondWinNum(req.getTeamSecondWinNum());
            detail.setTeamFirstWinRate(req.getTeamFirstWinRate());
            detail.setTeamSecondWinRate(req.getTeamSecondWinRate());
            detail.setTeamFirstAvgNum(req.getTeamFirstAvgNum());
            detail.setTeamSecondAvgNum(req.getTeamSecondAvgNum());
            detail.setTeamFirstAvgLossNum(req.getTeamFirstAvgLossNum());
            detail.setTeamSecondAvgLossNum(req.getTeamSecondAvgLossNum());
            detail.setTeamFirstWinOdds(req.getTeamFirstWinOdds());
            detail.setDrawOdds(req.getDrawOdds());
            detail.setTeamSecondWinOdds(req.getTeamSecondWinOdds());
            detail.setTeamFirstConcedeOdds(req.getTeamFirstConcedeOdds());
            detail.setTeamSecondConcedeOdds(req.getTeamSecondConcedeOdds());
            detail.setTeamFirstBigSmallOdds(req.getTeamFirstBigSmallOdds());
            detail.setTeamSecondBigSmallOdds(req.getTeamSecondBigSmallOdds());
            detail.setRecommendOdds(req.getRecommendOdds());
            detail.setContestAnalysis(req.getContestAnalysis());
            tContestDetailMapper.insertSelective(detail);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(ContestReq req) throws Exception {
        TContest contest = BizUtil.getUpdateInfo(new TContest(), req.getId(), req.getLoginName(), new Date());
        contest.setContestType(req.getContestType());
        contest.setContestName(req.getContestName());
        contest.setIsHot(req.getIsHot());
        contest.setIsRecommend(req.getIsRecommend());
        contest.setTeamFirst(req.getTeamFirst());
        contest.setTeamFirstPic(req.getTeamFirstPic());
        contest.setTeamSecond(req.getTeamSecond());
        contest.setTeamSecondPic(req.getTeamSecondPic());
        contest.setContestDate(req.getContestDate());
        contest.setIsPublish(req.getIsPublish());
        contest.setShowDateStart(req.getShowDateStart());
        contest.setShowDateEnd(req.getShowDateEnd());
        tContestMapper.updateByPrimaryKeySelective(contest);
        boolean isRecommend = req.getIsRecommend() != null && req.getIsRecommend().intValue() == 1;
        TContestDetail oldDetail = contestDetailService.getByPid(req.getId());
        if(isRecommend){
            if(oldDetail == null){
                TContestDetail detail = BizUtil.getInsertInfo(new TContestDetail(), req.getLoginName(), new Date());
                detail.setpId(contest.getId());
                detail.setTeamFirstWinNum(req.getTeamFirstWinNum());
                detail.setTeamSecondWinNum(req.getTeamSecondWinNum());
                detail.setTeamFirstWinRate(req.getTeamFirstWinRate());
                detail.setTeamSecondWinRate(req.getTeamSecondWinRate());
                detail.setTeamFirstAvgNum(req.getTeamFirstAvgNum());
                detail.setTeamSecondAvgNum(req.getTeamSecondAvgNum());
                detail.setTeamFirstAvgLossNum(req.getTeamFirstAvgLossNum());
                detail.setTeamSecondAvgLossNum(req.getTeamSecondAvgLossNum());
                detail.setTeamFirstWinOdds(req.getTeamFirstWinOdds());
                detail.setDrawOdds(req.getDrawOdds());
                detail.setTeamSecondWinOdds(req.getTeamSecondWinOdds());
                detail.setTeamFirstConcedeOdds(req.getTeamFirstConcedeOdds());
                detail.setTeamSecondConcedeOdds(req.getTeamSecondConcedeOdds());
                detail.setTeamFirstBigSmallOdds(req.getTeamFirstBigSmallOdds());
                detail.setTeamSecondBigSmallOdds(req.getTeamSecondBigSmallOdds());
                detail.setRecommendOdds(req.getRecommendOdds());
                detail.setContestAnalysis(req.getContestAnalysis());
                tContestDetailMapper.insertSelective(detail);
            } else {
                TContestDetail detail = BizUtil.getUpdateInfo(new TContestDetail(), oldDetail.getId(), req.getLoginName(), new Date());
                detail.setTeamFirstWinNum(req.getTeamFirstWinNum());
                detail.setTeamSecondWinNum(req.getTeamSecondWinNum());
                detail.setTeamFirstWinRate(req.getTeamFirstWinRate());
                detail.setTeamSecondWinRate(req.getTeamSecondWinRate());
                detail.setTeamFirstAvgNum(req.getTeamFirstAvgNum());
                detail.setTeamSecondAvgNum(req.getTeamSecondAvgNum());
                detail.setTeamFirstAvgLossNum(req.getTeamFirstAvgLossNum());
                detail.setTeamSecondAvgLossNum(req.getTeamSecondAvgLossNum());
                detail.setTeamFirstWinOdds(req.getTeamFirstWinOdds());
                detail.setDrawOdds(req.getDrawOdds());
                detail.setTeamSecondWinOdds(req.getTeamSecondWinOdds());
                detail.setTeamFirstConcedeOdds(req.getTeamFirstConcedeOdds());
                detail.setTeamSecondConcedeOdds(req.getTeamSecondConcedeOdds());
                detail.setTeamFirstBigSmallOdds(req.getTeamFirstBigSmallOdds());
                detail.setTeamSecondBigSmallOdds(req.getTeamSecondBigSmallOdds());
                detail.setRecommendOdds(req.getRecommendOdds());
                detail.setContestAnalysis(req.getContestAnalysis());
                tContestDetailMapper.updateByPrimaryKeySelective(detail);
            }
        } else {
            if(oldDetail != null){
                tContestDetailMapper.deleteByPrimaryKey(oldDetail.getId());
            }
        }
    }

    @Override
    public void updateStatus(ContestReq req) throws Exception {
        TContest contest = BizUtil.getUpdateInfo(new TContest(), req.getId(), req.getLoginName(), new Date());
        contest.setStatus(req.getStatus());
        tContestMapper.updateByPrimaryKeySelective(contest);
    }

    @Override
    public void updateResult(ContestReq req) throws Exception {
        TContest contest = BizUtil.getUpdateInfo(new TContest(), req.getId(), req.getLoginName(), new Date());
        contest.setIsHot(req.getIsHot());
        contest.setTeamFirstScore(req.getTeamFirstScore());
        contest.setTeamSecondScore(req.getTeamSecondScore());
        tContestMapper.updateByPrimaryKeySelective(contest);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(ContestReq req) throws Exception {
        List<Integer> idList = new ArrayList<>();
        if(req.getId() != null){
            idList.add(req.getId());
        }
        if(StringUtils.isNotBlank(req.getIds())){
            List<Integer> list = BizUtil.strToListInt(req.getIds(), ",");
            idList.addAll(list);
        }
        for(Integer id:idList){
            TContestDetail detail = contestDetailService.getByPid(id);
            if(detail != null){
                tContestDetailMapper.deleteByPrimaryKey(detail.getId());
            }
            tContestMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<ContestRsp> getListByType(ContestReq req) throws Exception {
        Date now = new Date();
        TContestExample example = new TContestExample();
        TContestExample.Criteria criteria = example.createCriteria();
        criteria.andContestTypeEqualTo(req.getContestType());
        criteria.andStatusEqualTo(1);
        criteria.andIsPublishEqualTo(1);
        criteria.andPublishDateLessThanOrEqualTo(now);
        criteria.andShowDateStartLessThanOrEqualTo(now);
        criteria.andShowDateEndGreaterThanOrEqualTo(now);
        if(req.getIsHot() != null){
            criteria.andIsHotEqualTo(req.getIsHot());
        }
        example.setOrderByClause(" is_recommend desc, sort_num");
        List<TContest> list = tContestMapper.selectByExample(example);
        List<ContestRsp> result = list.stream().map(contest->this.convertRsp(contest, req.getNeedDetail())).collect(Collectors.toList());
        return result;
    }

    @Override
    public PageInfo<TContest> pageList(ContestReq req) throws Exception {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<TContest> contests = contestMapper.getList(req);
        PageInfo<TContest> page = new PageInfo<>(contests);
        return page;
    }

    private ContestRsp convertRsp(TContest contest, Integer needDetail) {
        ContestRsp rsp = new ContestRsp();
        BeanUtils.copyProperties(contest, rsp);
        if(needDetail != null && needDetail.intValue() == 1){
            try{
                TContestDetail detail = contestDetailService.getByPid(contest.getId());
                rsp.setContestDetail(detail);
            }catch(Exception e){
                logger.error("ContestRsp-convertRsp-error", e);
            }
        }
        return rsp;
    }

}
