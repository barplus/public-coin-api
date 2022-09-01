package com.coin.service.impl;

import com.coin.entity.TSysResource;
import com.coin.entity.TSysResourceExample;
import com.coin.mapper.TSysResourceMapper;
import com.coin.req.SysResourceReq;
import com.coin.rsp.SysResourceRsp;
import com.coin.service.SysResourceService;
import com.coin.service.util.BizUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysResourceServiceImpl implements SysResourceService {

    @Resource
    private TSysResourceMapper tSysResourceMapper;

    @Override
    public void addSysResource(SysResourceReq req) throws Exception {
        TSysResource sysResource = BizUtil.getInsertInfo(new TSysResource(), req.getLoginName(), new Date());
        sysResource.setResourceType(req.getResourceType());
        sysResource.setResourceCode(req.getResourceCode());
        sysResource.setResourceName(req.getResourceName());
        sysResource.setResourcePath(req.getResourcePath());
        sysResource.setResourceCode(req.getResourceCode());
        sysResource.setStatus(req.getStatus());
        sysResource.setSortNum(req.getSortNum());
        tSysResourceMapper.insertSelective(sysResource);
    }

    @Override
    public List<SysResourceRsp> getSysResources(SysResourceReq req) throws Exception {
        TSysResourceExample example = new TSysResourceExample();
        TSysResourceExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(req.getParentCode())){
            criteria.andParentCodeEqualTo(req.getParentCode());
        }
        if(StringUtils.isNotBlank(req.getResourceType())){
            criteria.andResourceTypeEqualTo(req.getResourceType());
        }
        example.setOrderByClause(" resource_type, sort_num desc");
        List<TSysResource> sysResources = tSysResourceMapper.selectByExample(example);
        List<SysResourceRsp> rspList = sysResources.stream().map(sysResource -> this.convertRsp(sysResource)).collect(Collectors.toList());
        return rspList;
    }

    private SysResourceRsp convertRsp(TSysResource sysResource){
        SysResourceRsp rsp = new SysResourceRsp();
        BeanUtils.copyProperties(sysResource, rsp);
        return rsp;
    }

}
