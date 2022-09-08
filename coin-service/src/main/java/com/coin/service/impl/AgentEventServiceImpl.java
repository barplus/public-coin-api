package com.coin.service.impl;

import com.coin.entity.TAgentEventConfig;
import com.coin.entity.TAgentEventConfigExample;
import com.coin.mapper.TAgentEventConfigMapper;
import com.coin.req.AgentEventReq;
import com.coin.service.AgentEventService;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.BizUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AgentEventServiceImpl implements AgentEventService {

    private static final Logger logger = LoggerFactory.getLogger(AgentEventServiceImpl.class);

    @Resource
    private TAgentEventConfigMapper tAgentEventConfigMapper;

    @Override
    public void addEvent(AgentEventReq req) throws Exception {
        TAgentEventConfig oldInfo = this.getByIndex(req.getEventIndex());
        if(oldInfo != null){
            throw new BizException(CodeCons.ERROR, "活动"+req.getEventIndex()+"已存在，请确认");
        }
        TAgentEventConfig agentEventConfig = BizUtil.getInsertInfo(new TAgentEventConfig(), req.getLoginName(), new Date());
        agentEventConfig.setEventIndex(req.getEventIndex());
        agentEventConfig.setStatus(req.getStatus());
        agentEventConfig.setEventName(req.getEventName());
        agentEventConfig.setHtmlPicList(req.getHtmlPicList());
        agentEventConfig.setHtmlPicDetail(req.getHtmlPicDetail());
        agentEventConfig.setPcPicList(req.getPcPicList());
        agentEventConfig.setPcPicDetail(req.getPcPicDetail());
        agentEventConfig.setEventDate(req.getEventDate());
        agentEventConfig.setEventContent(req.getEventContent());
        agentEventConfig.setEventRule(req.getEventRule());
        tAgentEventConfigMapper.insertSelective(agentEventConfig);
    }

    @Override
    public void update(AgentEventReq req) throws Exception {
        TAgentEventConfig agentEventConfig = BizUtil.getUpdateInfo(new TAgentEventConfig(), req.getId(), req.getLoginName(), new Date());
        agentEventConfig.setEventName(req.getEventName());
        agentEventConfig.setStatus(req.getStatus());
        agentEventConfig.setHtmlPicList(req.getHtmlPicList());
        agentEventConfig.setHtmlPicDetail(req.getHtmlPicDetail());
        agentEventConfig.setPcPicList(req.getPcPicList());
        agentEventConfig.setPcPicDetail(req.getPcPicDetail());
        agentEventConfig.setEventDate(req.getEventDate());
        agentEventConfig.setEventContent(req.getEventContent());
        agentEventConfig.setEventRule(req.getEventRule());
        tAgentEventConfigMapper.updateByPrimaryKeySelective(agentEventConfig);
    }

    @Override
    public TAgentEventConfig getByIndex(Integer index) throws Exception {
        TAgentEventConfigExample example = new TAgentEventConfigExample();
        example.createCriteria().andEventIndexEqualTo(index);
        List<TAgentEventConfig> list = tAgentEventConfigMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }
}
