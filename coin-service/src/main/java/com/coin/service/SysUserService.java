package com.coin.service;

import com.coin.entity.TSysUser;
import com.coin.req.SysUserReq;
import com.coin.rsp.SysUserRsp;
import com.github.pagehelper.PageInfo;

public interface SysUserService {

    TSysUser getUserByLoginName(String loginName) throws Exception;
    SysUserRsp getUserByLogName(String loginName) throws Exception;
    void updatePass(SysUserReq req) throws Exception;
    void update(SysUserReq req) throws Exception;
    PageInfo<SysUserRsp> pageList(SysUserReq req) throws Exception;

}
