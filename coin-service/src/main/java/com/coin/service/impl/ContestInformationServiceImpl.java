package com.coin.service.impl;

import com.coin.entity.TContestInformation;
import com.coin.entity.TContestInformationExample;
import com.coin.mapper.TContestInformationMapper;
import com.coin.req.ContestInformationReq;
import com.coin.service.ContestInformationService;
import com.coin.service.util.BizUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContestInformationServiceImpl implements ContestInformationService {

    private static final Logger logger = LoggerFactory.getLogger(ContestInformationServiceImpl.class);

    @Resource
    private TContestInformationMapper tContestInformationMapper;

    @Override
    public PageInfo<TContestInformation> pageList(ContestInformationReq req) {
        TContestInformationExample example = new TContestInformationExample();
        TContestInformationExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(req.getInformationTitle())){
            criteria.andInformationTitleEqualTo(req.getInformationTitle());
        }
        if(req.getStatus() != null){
            criteria.andStatusEqualTo(req.getStatus());
        }
        if(StringUtils.isNotBlank(req.getUpdateUser())){
            criteria.andUpdateUserEqualTo(req.getUpdateUser());
        }
        if(req.getCreateDateMin() != null){
            criteria.andCreateDateGreaterThanOrEqualTo(req.getCreateDateMin());
        }
        if(req.getCreateDateMax() != null){
            criteria.andCreateDateLessThanOrEqualTo(req.getCreateDateMax());
        }
        example.setOrderByClause(" id");
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<TContestInformation> list = tContestInformationMapper.selectByExample(example);
        PageInfo<TContestInformation> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public void add(ContestInformationReq req) throws Exception {
        Date now = new Date();
        TContestInformation information = BizUtil.getInsertInfo(new TContestInformation(), req.getLoginName(), now);
        information.setInformationTitle(req.getInformationTitle());
        information.setInformationContent(req.getInformationContent());
        information.setIsPublish(req.getIsPublish());
        if(req.getIsPublish().intValue() == 1){
            information.setPublishDate(now);
        }
        information.setInformationPic(req.getInformationPic());
        information.setShowDateStart(req.getShowDateStart());
        information.setShowDateEnd(req.getShowDateEnd());
        tContestInformationMapper.insertSelective(information);
    }

    @Override
    public void update(ContestInformationReq req) throws Exception {
        Date now = new Date();
        TContestInformation information = BizUtil.getUpdateInfo(new TContestInformation(), req.getId(), req.getLoginName(), now);
        information.setInformationTitle(req.getInformationTitle());
        information.setInformationContent(req.getInformationContent());
        information.setIsPublish(req.getIsPublish());
        if(req.getIsPublish().intValue() == 1){
            information.setPublishDate(now);
        }
        information.setInformationPic(req.getInformationPic());
        information.setShowDateStart(req.getShowDateStart());
        information.setShowDateEnd(req.getShowDateEnd());
        tContestInformationMapper.updateByPrimaryKeySelective(information);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(ContestInformationReq req) throws Exception {
        List<Integer> idList = new ArrayList<>();
        if(req.getId() != null){
            idList.add(req.getId());
        }
        if(StringUtils.isNotBlank(req.getIds())){
            List<Integer> list = BizUtil.strToListInt(req.getIds(), ",");
            idList.addAll(list);
        }
        TContestInformation information = BizUtil.getUpdateInfo(new TContestInformation(), -1, req.getLoginName(), new Date());;
        for(Integer id:idList){
            information.setId(id);
            information.setIsDelete(1);
            tContestInformationMapper.updateByPrimaryKeySelective(information);
        }
    }

}
