package com.coin.service;

import com.coin.entity.TSysUser;
import com.coin.req.SysUserReq;

public interface SysUserService {

    TSysUser getUserByLoginName(String loginName) throws Exception;

    void updatePass(SysUserReq req) throws Exception;

}
