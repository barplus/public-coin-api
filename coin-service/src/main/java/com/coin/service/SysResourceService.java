package com.coin.service;

import com.coin.entity.TSysResource;
import com.coin.req.SysResourceReq;
import com.coin.rsp.SysResourceRsp;

import java.util.List;

public interface SysResourceService {

    void addSysResource(SysResourceReq req) throws Exception;
    void deleteByCode(String code) throws Exception;
    void update(SysResourceReq req) throws Exception;
    TSysResource getInfoByCode(String code, Integer excludeId) throws Exception;
    TSysResource getByPath(String path) throws Exception;
    List<SysResourceRsp> getSysResources(SysResourceReq req) throws Exception;
    List<SysResourceRsp> getSysResourcesByType(String resourceType, String roleCode) throws Exception;
    List<SysResourceRsp> getAllSysResources(String roleCode) throws Exception;

}
