package com.coin.service;

import com.coin.entity.SysUser;

public interface SysUserService {

    SysUser getUserByLoginName(String loginName) throws Exception;

}
