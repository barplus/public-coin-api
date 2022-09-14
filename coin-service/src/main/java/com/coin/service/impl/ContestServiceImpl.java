package com.coin.service.impl;

import com.coin.entity.TContest;
import com.coin.entity.TContestExample;
import com.coin.mapper.TContestMapper;
import com.coin.req.ContestReq;
import com.coin.service.ContestService;
import com.coin.service.util.BizUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ContestServiceImpl implements ContestService {

    private static final Logger logger = LoggerFactory.getLogger(ContestServiceImpl.class);

    @Resource
    private TContestMapper tContestMapper;

    @Override
    public void addContest(ContestReq req) throws Exception {
        TContest contest = BizUtil.getInsertInfo(new TContest(), req.getLoginName(), new Date());
        contest.setContestType(req.getContestType());
        contest.setContestName(req.getContestName());
        contest.setContestDate(req.getContestDate());
        contest.setTeamFirst(req.getTeamFirst());
        contest.setTeamSecond(req.getTeamSecond());
        contest.setStatus(req.getStatus());
        contest.setSortNum(req.getSortNum());
        tContestMapper.insertSelective(contest);
    }

    @Override
    public void update(ContestReq req) throws Exception {
        TContest contest = BizUtil.getUpdateInfo(new TContest(), req.getId(), req.getLoginName(), new Date());
        contest.setContestType(req.getContestType());
        contest.setContestName(req.getContestName());
        contest.setContestDate(req.getContestDate());
        contest.setTeamFirst(req.getTeamFirst());
        contest.setTeamSecond(req.getTeamSecond());
        contest.setStatus(req.getStatus());
        contest.setSortNum(req.getSortNum());
        tContestMapper.updateByPrimaryKeySelective(contest);
    }

    @Override
    public List<TContest> getListByType(String contestType) throws Exception {
        TContestExample example = new TContestExample();
        example.createCriteria().andContestTypeEqualTo(contestType).andStatusEqualTo(1);
        List<TContest> list = tContestMapper.selectByExample(example);
        return list;
    }

    @Override
    public PageInfo<TContest> pageList(ContestReq req) throws Exception {
        TContestExample example = new TContestExample();
        TContestExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(req.getContestType())){
            criteria.andContestTypeEqualTo(req.getContestType());
        }
        if(StringUtils.isNotBlank(req.getContestName())){
            criteria.andContestNameEqualTo(req.getContestName());
        }
        if(req.getContestDateMin() != null){
            criteria.andContestDateGreaterThanOrEqualTo(req.getContestDateMin());
        }
        if(req.getContestDateMax() != null){
            criteria.andContestDateLessThanOrEqualTo(req.getContestDateMax());
        }
        if(StringUtils.isNotBlank(req.getTeamFirst())){
            criteria.andTeamFirstEqualTo(req.getTeamFirst());
        }
        if(StringUtils.isNotBlank(req.getTeamSecond())){
            criteria.andTeamSecondEqualTo(req.getTeamSecond());
        }
        if(req.getStatus() != null){
            criteria.andStatusEqualTo(req.getStatus());
        }
        example.setOrderByClause(" sort_num");
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<TContest> contests = tContestMapper.selectByExample(example);
        PageInfo<TContest> page = new PageInfo<>(contests);
        return page;
    }

}
