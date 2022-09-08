package com.coin.service;

import com.coin.entity.TAgentEventConfig;
import com.coin.req.AgentEventReq;

public interface AgentEventService {

    void addEvent(AgentEventReq req) throws Exception;

    void update(AgentEventReq req) throws Exception;

    TAgentEventConfig getByIndex(Integer index) throws Exception;

}
