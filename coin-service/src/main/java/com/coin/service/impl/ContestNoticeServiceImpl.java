package com.coin.service.impl;

import com.coin.entity.TContestNotice;
import com.coin.entity.TContestNoticeExample;
import com.coin.mapper.TContestNoticeMapper;
import com.coin.req.ContestNoticeReq;
import com.coin.service.ContestNoticeService;
import com.coin.service.util.BizUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContestNoticeServiceImpl implements ContestNoticeService {

    private static final Logger logger = LoggerFactory.getLogger(ContestNoticeServiceImpl.class);

    @Resource
    private TContestNoticeMapper tContestNoticeMapper;

    @Override
    public PageInfo<TContestNotice> pageList(ContestNoticeReq req) throws Exception {
        TContestNoticeExample example = new TContestNoticeExample();
        TContestNoticeExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeleteEqualTo(0);
        if(StringUtils.isNotBlank(req.getNoticeTitle())){
            criteria.andNoticeTitleEqualTo(req.getNoticeTitle());
        }
        if(req.getCreateDateMin() != null){
            criteria.andCreateDateGreaterThanOrEqualTo(req.getCreateDateMin());
        }
        if(req.getCreateDateMax() != null){
            criteria.andCreateDateLessThanOrEqualTo(req.getCreateDateMax());
        }
        if(req.getStatus() != null){
            criteria.andStatusEqualTo(req.getStatus());
        }
        if(StringUtils.isNotBlank(req.getUpdateUser())){
            criteria.andUpdateUserEqualTo(req.getUpdateUser());
        }
        example.setOrderByClause(" id");
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<TContestNotice> list = tContestNoticeMapper.selectByExample(example);
        PageInfo<TContestNotice> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public void add(ContestNoticeReq req) throws Exception {
        Date now = new Date();
        TContestNotice notice = BizUtil.getInsertInfo(new TContestNotice(), req.getLoginName(), now);
        notice.setNoticeTitle(req.getNoticeTitle());
        notice.setNoticeContent(req.getNoticeContent());
        notice.setIsPublish(req.getIsPublish());
        if(req.getIsPublish().intValue() == 1){
            notice.setPublishDate(now);
        }
        notice.setShowDateStart(req.getShowDateStart());
        notice.setShowDateEnd(req.getShowDateEnd());
        notice.setIsTop(req.getIsTop());
        notice.setTopDateStart(req.getTopDateStart());
        notice.setTopDateEnd(req.getTopDateEnd());
        tContestNoticeMapper.insertSelective(notice);
    }

    @Override
    public void update(ContestNoticeReq req) throws Exception {
        Date now = new Date();
        TContestNotice notice = BizUtil.getUpdateInfo(new TContestNotice(), req.getId(), req.getLoginName(), now);
        notice.setNoticeTitle(req.getNoticeTitle());
        notice.setNoticeContent(req.getNoticeContent());
        notice.setIsPublish(req.getIsPublish());
        if(req.getIsPublish() != null && req.getIsPublish().intValue() == 1){
            notice.setPublishDate(now);
        }
        notice.setShowDateStart(req.getShowDateStart());
        notice.setShowDateEnd(req.getShowDateEnd());
        notice.setIsTop(req.getIsTop());
        notice.setTopDateStart(req.getTopDateStart());
        notice.setTopDateEnd(req.getTopDateEnd());
        tContestNoticeMapper.updateByPrimaryKeySelective(notice);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(ContestNoticeReq req) throws Exception {
        List<Integer> idList = new ArrayList<>();
        if(req.getId() != null){
            idList.add(req.getId());
        }
        if(StringUtils.isNotBlank(req.getIds())){
            List<Integer> list = BizUtil.strToListInt(req.getIds(), ",");
            idList.addAll(list);
        }
        TContestNotice notice = BizUtil.getUpdateInfo(new TContestNotice(), -1, req.getLoginName(), new Date());;
        for(Integer id:idList){
            notice.setId(id);
            notice.setIsDelete(1);
            tContestNoticeMapper.updateByPrimaryKeySelective(notice);
        }
    }

}
