package com.coin.service.impl;

import com.coin.entity.TSysRole;
import com.coin.mapper.TSysRoleMapper;
import com.coin.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private TSysRoleMapper sysRoleMapper;

    @Override
    public void addSysRole(TSysRole sysRole) throws Exception {
        sysRoleMapper.insertSelective(sysRole);
    }

}
