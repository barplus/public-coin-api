package com.coin.service.impl;

import com.coin.entity.TContestSponsorshipLogo;
import com.coin.entity.TContestSponsorshipLogoExample;
import com.coin.mapper.TContestSponsorshipLogoMapper;
import com.coin.req.ContestSponsorshipLogoReq;
import com.coin.service.ContestSponsorshipLogoService;
import com.coin.service.util.BizUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ContestSponsorshipLogoServiceImpl implements ContestSponsorshipLogoService {

    private static final Logger logger = LoggerFactory.getLogger(ContestSponsorshipLogoServiceImpl.class);

    @Resource
    private TContestSponsorshipLogoMapper tContestSponsorshipLogoMapper;

    @Override
    public List<TContestSponsorshipLogo> getAllList() throws Exception {
        TContestSponsorshipLogoExample example = new TContestSponsorshipLogoExample();
        example.createCriteria().andIsDeleteEqualTo(0);
        example.setOrderByClause(" sort_num, create_date");
        List<TContestSponsorshipLogo> list = tContestSponsorshipLogoMapper.selectByExample(example);
        return list;
    }

    @Override
    public void add(ContestSponsorshipLogoReq req) throws Exception {
        TContestSponsorshipLogo logo = BizUtil.getInsertInfo(new TContestSponsorshipLogo(), req.getLoginName(), new Date());
        logo.setSortNum(req.getShortNum());
        logo.setSponsorshipLogo(req.getUrl());
        tContestSponsorshipLogoMapper.insertSelective(logo);
    }

    @Override
    public void delete(Integer id, String updateUser) throws Exception {
        TContestSponsorshipLogo updateInfo = BizUtil.getUpdateInfo(new TContestSponsorshipLogo(), id, updateUser, new Date());
        updateInfo.setIsDelete(1);
        tContestSponsorshipLogoMapper.updateByPrimaryKeySelective(updateInfo);
    }

}
