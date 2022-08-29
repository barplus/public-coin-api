package com.coin.service.impl;

import com.coin.entity.TSysRoleResource;
import com.coin.mapper.TSysRoleMapper;
import com.coin.mapper.TSysRoleResourceMapper;
import com.coin.service.SysRoleResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysRoleResourceServiceImpl implements SysRoleResourceService {

    @Resource
    private TSysRoleResourceMapper sysRoleResourceMapper;

    @Override
    public void addSysRoleResource(TSysRoleResource sysRoleResource) throws Exception {
        sysRoleResourceMapper.insertSelective(sysRoleResource);
    }

}
