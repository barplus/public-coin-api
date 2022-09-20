package com.coin.service.impl;

import com.coin.entity.TContestEvent;
import com.coin.entity.TContestEventExample;
import com.coin.entity.TContestInformation;
import com.coin.mapper.TContestEventMapper;
import com.coin.req.ContestEventReq;
import com.coin.service.ContestEventService;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
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
public class ContestEventServiceImpl implements ContestEventService {

    private static final Logger logger = LoggerFactory.getLogger(ContestEventServiceImpl.class);

    @Resource
    private TContestEventMapper tContestEventMapper;

    @Override
    public PageInfo<TContestEvent> pageList(ContestEventReq req) throws Exception {
        TContestEventExample example = new TContestEventExample();
        TContestEventExample.Criteria criteria = example.createCriteria();
        if(req.getShowDateStart() != null && req.getShowDateEnd() != null){
            if(req.getShowDateStart().after(req.getShowDateEnd())){
                throw new BizException(CodeCons.ERROR, "展示结束时间不能小于开始时间");
            }
        }
        if(StringUtils.isNotBlank(req.getEventTitle())){
            criteria.andEventTitleEqualTo(req.getEventTitle());
        }
        if(StringUtils.isNotBlank(req.getEventTag())){
            criteria.andEventTagEqualTo(req.getEventTag());
        }
        if(req.getStatus() != null){
            criteria.andStatusEqualTo(req.getStatus());
        }
        if(req.getShowDateStart() != null){
            criteria.andShowDateEndGreaterThanOrEqualTo(req.getShowDateStart());
        }
        if(req.getShowDateEnd() != null){
            criteria.andShowDateStartLessThanOrEqualTo(req.getShowDateEnd());
        }
        if(req.getShowDate() != null){
            criteria.andShowDateStartLessThanOrEqualTo(req.getShowDate());
            criteria.andShowDateEndLessThanOrEqualTo(req.getShowDate());
        }
        if(req.getIsPublish() != null){
            criteria.andIsPublishEqualTo(req.getIsPublish());
        }
        if(req.getPublishDate() != null){
            criteria.andPublishDateLessThanOrEqualTo(req.getPublishDate());
        }
        example.setOrderByClause(" sort_num");
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<TContestEvent> list = tContestEventMapper.selectByExample(example);
        PageInfo<TContestEvent> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public void add(ContestEventReq req) throws Exception {
        Date now = new Date();
        TContestEvent event = BizUtil.getInsertInfo(new TContestEvent(), req.getLoginName(), now);
        event.setEventTitle(req.getEventTitle());
        event.setEventTag(req.getEventTag());
        event.setShowDateStart(req.getShowDateStart());
        event.setShowDateEnd(req.getShowDateEnd());
        if(req.getShowDateStart() != null && req.getShowDateEnd() != null){
            if(req.getShowDateEnd().before(req.getShowDateStart())){
                throw new BizException(CodeCons.ERROR, "显示结束时间不能早于开始时间");
            }
        }
        event.setIsJump(req.getIsJump());
        event.setJumpUrl(req.getJumpUrl());
        event.setEventPic(req.getEventPic());
        event.setIsPublish(req.getIsPublish());
        if(req.getIsPublish().intValue() == 1){
            event.setPublishDate(now);
        }
        tContestEventMapper.insertSelective(event);
    }

    @Override
    public void update(ContestEventReq req) throws Exception {
        Date now = new Date();
        TContestEvent oldEvent = tContestEventMapper.selectByPrimaryKey(req.getId());
        TContestEvent event = BizUtil.getUpdateInfo(new TContestEvent(), req.getId(), req.getLoginName(), now);
        event.setEventTitle(req.getEventTitle());
        event.setEventTag(req.getEventTag());
        event.setShowDateStart(req.getShowDateStart());
        event.setShowDateEnd(req.getShowDateEnd());
        Date showDateStart = req.getShowDateStart() == null?oldEvent.getShowDateStart():req.getShowDateStart();
        Date showDateEnd = req.getShowDateEnd() == null?oldEvent.getShowDateStart():req.getShowDateStart();
        if(showDateStart != null && showDateEnd != null){
            if(showDateEnd.before(showDateStart)){
                throw new BizException(CodeCons.ERROR, "显示结束时间不能早于开始时间");
            }
        }
        event.setIsJump(req.getIsJump());
        event.setJumpUrl(req.getJumpUrl());
        event.setEventPic(req.getEventPic());
        event.setIsPublish(req.getIsPublish());
        if(req.getIsPublish().intValue() == 1){
            event.setPublishDate(now);
        }
        tContestEventMapper.updateByPrimaryKeySelective(event);
    }

    @Override
    public void delete(Integer id, String updateUser) throws Exception {
        TContestEvent event = BizUtil.getUpdateInfo(new TContestEvent(), id, updateUser, new Date());
        event.setIsDelete(1);
        tContestEventMapper.updateByPrimaryKeySelective(event);
    }

}
