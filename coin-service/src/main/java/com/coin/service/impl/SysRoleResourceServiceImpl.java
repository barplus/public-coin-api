package com.coin.service.impl;

import com.coin.entity.TSysRoleResource;
import com.coin.entity.TSysRoleResourceExample;
import com.coin.mapper.TSysRoleResourceMapper;
import com.coin.mapper.ext.SysRoleResourceMapper;
import com.coin.req.SysRoleResourceReq;
import com.coin.service.SysRoleResourceService;
import com.coin.service.util.BizUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class SysRoleResourceServiceImpl implements SysRoleResourceService {

    @Resource
    private TSysRoleResourceMapper tSysRoleResourceMapper;
    @Resource
    private SysRoleResourceMapper sysRoleResourceMapper;

    @Override
    public void addSysRoleResources(SysRoleResourceReq req) throws Exception {
        String[] addResourceCodes = req.getAddResourceCodes().split(",");
        List<String> resourceCodeList = Arrays.asList(addResourceCodes);
        List<TSysRoleResource> datas = new ArrayList<>(resourceCodeList.size());
        for(String resourceCode:resourceCodeList){
            TSysRoleResource oldRoleResource = this.getInfoByRoleCodeAndResCode(req.getRoleCode(), resourceCode);
            if(oldRoleResource == null){
                TSysRoleResource newRoleResource = BizUtil.getInsertInfo(new TSysRoleResource(), req.getLoginName(), new Date());
                newRoleResource.setRoleCode(req.getRoleCode());
                newRoleResource.setResourceCode(resourceCode);
                datas.add(newRoleResource);
            }
        }
        sysRoleResourceMapper.addBatch(datas);
    }

    @Override
    public void delSysRoleResources(SysRoleResourceReq req) throws Exception {
        String[] delResourceCodes = req.getDelResourceCodes().split(",");
        List<String> resourceCodeList = Arrays.asList(delResourceCodes);
        sysRoleResourceMapper.delBatch(req.getRoleCode(), resourceCodeList);
    }

    @Override
    public void delAllByRoleCode(String roleCode) throws Exception {
        sysRoleResourceMapper.delAllByRoleCode(roleCode);
    }

    @Override
    public TSysRoleResource getInfoByRoleCodeAndResCode(String roleCode, String resourceCode) throws Exception {
        TSysRoleResourceExample example = new TSysRoleResourceExample();
        example.createCriteria().andRoleCodeEqualTo(roleCode).andResourceCodeEqualTo(resourceCode);
        List<TSysRoleResource> list = tSysRoleResourceMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<TSysRoleResource> getListByRoleCode(String roleCode) throws Exception {
        TSysRoleResourceExample example = new TSysRoleResourceExample();
        example.createCriteria().andRoleCodeEqualTo(roleCode);
        List<TSysRoleResource> list = tSysRoleResourceMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<TSysRoleResource> getListByResourceCode(String resourceCode) throws Exception {
        TSysRoleResourceExample example = new TSysRoleResourceExample();
        example.createCriteria().andResourceCodeEqualTo(resourceCode);
        List<TSysRoleResource> list = tSysRoleResourceMapper.selectByExample(example);
        return list;
    }

}
