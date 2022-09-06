package com.coin.service;

import com.coin.req.AgentConfigReq;
import com.coin.rsp.AgentConfigRsp;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AgentConfigService {

    PageInfo<AgentConfigRsp> pageList(AgentConfigReq req) throws Exception;
    AgentConfigRsp getByAgentCode(AgentConfigReq req) throws Exception;
    String add(AgentConfigReq req) throws Exception;
    void update(AgentConfigReq req) throws Exception;
    void delete(Integer id, String updateUser) throws Exception;
    void importAgentConfigList(List<AgentConfigRsp> list, String createUser, String fileName) throws Exception;

}
