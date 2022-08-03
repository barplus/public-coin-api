package com.coin.service.impl;

import com.coin.entity.SysUser;
import com.coin.mapper.SysUserMapper;
import com.coin.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper userMapper;

    @Override
    public SysUser getUserByLoginName(String loginName) throws Exception {
        return userMapper.getUserByLoginName(loginName);
    }

}
