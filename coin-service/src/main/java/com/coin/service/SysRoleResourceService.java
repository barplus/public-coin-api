package com.coin.service;

import com.coin.entity.TSysRoleResource;
import com.coin.req.SysRoleResourceReq;

import java.util.List;

public interface SysRoleResourceService {

    void addSysRoleResources(SysRoleResourceReq req) throws Exception;
    void delSysRoleResources(SysRoleResourceReq req) throws Exception;
    TSysRoleResource getInfoByRoleCodeAndResCode(String roleCode, String resourceCode) throws Exception;
    List<TSysRoleResource> getListByRoleCode(String roleCode) throws Exception;
    List<TSysRoleResource> getListByResourceCode(String resourceCode) throws Exception;

}
