package com.coin.service.impl;

import com.coin.entity.TSysResource;
import com.coin.mapper.TSysResourceMapper;
import com.coin.req.SysResourceReq;
import com.coin.rsp.SysResourceRsp;
import com.coin.service.SysResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysResourceServiceImpl implements SysResourceService {

    @Resource
    private TSysResourceMapper sysResourceMapper;

    @Override
    public void addSysResource(TSysResource sysResource) throws Exception {
        sysResourceMapper.insertSelective(sysResource);
    }

    @Override
    public List<SysResourceRsp> getSysResource(SysResourceReq req) throws Exception {
        return null;
    }

}
