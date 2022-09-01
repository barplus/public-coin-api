package com.coin.service;

import com.coin.entity.TSysResource;
import com.coin.req.SysResourceReq;
import com.coin.rsp.SysResourceRsp;

import java.util.List;

public interface SysResourceService {

    void addSysResource(TSysResource sysResource) throws Exception;

    List<SysResourceRsp> getSysResource(SysResourceReq req) throws Exception;

}
