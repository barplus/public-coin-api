package com.coin.mapper.ext;

import com.coin.rsp.AgentConfigRsp;

import java.util.List;

public interface AgentPageConfigMapper {

    void createBatch(List<AgentConfigRsp> list);

}
