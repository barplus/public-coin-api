package com.coin.service;

import com.coin.entity.TSysRole;
import com.coin.req.SysRoleReq;
import com.coin.req.SysRoleResourceReq;
import com.coin.rsp.SysRoleRsp;
import com.github.pagehelper.PageInfo;

public interface SysRoleService {

    void addSysRole(SysRoleReq req) throws Exception;
    void updateSysRole(SysRoleReq req) throws Exception;
    void saveRoleResources(SysRoleResourceReq req) throws Exception;
    TSysRole getRoleByCode(String roleCode) throws Exception;
    TSysRole getRoleByName(String roleName, Integer excludeId) throws Exception;
    PageInfo<SysRoleRsp> pageList(SysRoleReq req) throws Exception;

}
