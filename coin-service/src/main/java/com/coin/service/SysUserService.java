package com.coin.service;

import com.coin.entity.TSysUser;

public interface SysUserService {

    TSysUser getUserByLoginName(String loginName) throws Exception;

}
