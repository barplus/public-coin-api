package com.coin.service;

import com.coin.req.SysResourceReq;
import com.coin.rsp.SysResourceRsp;

import java.util.List;

public interface SysResourceService {

    void addSysResource(SysResourceReq req) throws Exception;

    List<SysResourceRsp> getSysResources(SysResourceReq req) throws Exception;

}
