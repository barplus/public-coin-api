package com.coin.service.impl;

import com.coin.entity.TContest;
import com.coin.entity.TContestExample;
import com.coin.mapper.TContestMapper;
import com.coin.req.ContestReq;
import com.coin.service.ContestService;
import com.coin.service.util.BizUtil;
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
    public List<TContest> getListByType(String contestType) throws Exception {
        TContestExample example = new TContestExample();
        example.createCriteria().andContestTypeEqualTo(contestType).andStatusEqualTo(1);
        List<TContest> list = tContestMapper.selectByExample(example);
        return list;
    }

}
