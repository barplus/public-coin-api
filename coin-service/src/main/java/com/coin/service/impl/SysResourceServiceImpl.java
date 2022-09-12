package com.coin.service.impl;

import com.coin.entity.TSysResource;
import com.coin.entity.TSysResourceExample;
import com.coin.entity.TSysRole;
import com.coin.entity.TSysRoleResource;
import com.coin.mapper.TSysResourceMapper;
import com.coin.req.SysResourceReq;
import com.coin.rsp.SysResourceRsp;
import com.coin.service.SysResourceService;
import com.coin.service.SysRoleResourceService;
import com.coin.service.SysRoleService;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.BizUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SysResourceServiceImpl implements SysResourceService {

    private static final Logger logger = LoggerFactory.getLogger(SysResourceServiceImpl.class);

    @Resource
    private TSysResourceMapper tSysResourceMapper;
    @Resource
    private SysRoleResourceService roleResourceService;
    @Resource
    private SysRoleService roleService;

    @Override
    public void addSysResource(SysResourceReq req) throws Exception {
        TSysResource oldResource = this.getInfoByCode(req.getResourceCode(), null);
        if(oldResource != null){
            throw new BizException(CodeCons.ERROR, "资源编码已经被占用，请更改");
        }
        TSysResource sysResource = BizUtil.getInsertInfo(new TSysResource(), req.getLoginName(), new Date());
        sysResource.setResourceType(req.getResourceType());
        sysResource.setResourceCode(req.getResourceCode());
        sysResource.setResourceName(req.getResourceName());
        sysResource.setResourcePath(req.getResourcePath());
        sysResource.setStatus(req.getStatus());
        sysResource.setSortNum(req.getSortNum());
        sysResource.setParentCode(req.getParentCode());
        tSysResourceMapper.insertSelective(sysResource);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteByCode(String code) throws Exception {
        TSysResource resource = this.getInfoByCode(code, null);
        if(resource != null){
            List<TSysRoleResource> roleResources = roleResourceService.getListByResourceCode(resource.getResourceCode());
            if(!CollectionUtils.isEmpty(roleResources)){
                TSysRole role = roleService.getRoleByCode(roleResources.get(0).getRoleCode());
                throw new BizException(CodeCons.ERROR, "资源已被分配到角色["+role.getRoleName()+"]，不能直接删除");
            }
            SysResourceReq req = new SysResourceReq();
            req.setParentCode(code);
            List<SysResourceRsp> rspList = this.getSysResources(req);
            if(!CollectionUtils.isEmpty(rspList)){
                throw new BizException(CodeCons.ERROR, "资源存在下级，不能直接删除");
            }
            tSysResourceMapper.deleteByPrimaryKey(resource.getId());
        }
    }

    @Override
    public void update(SysResourceReq req) throws Exception {
        TSysResource updateResource = BizUtil.getUpdateInfo(new TSysResource(), req.getId(), req.getLoginName(), new Date());
        updateResource.setResourceName(req.getResourceName());
        updateResource.setResourcePath(req.getResourcePath());
        updateResource.setStatus(req.getStatus());
        updateResource.setSortNum(req.getSortNum());
        tSysResourceMapper.updateByPrimaryKeySelective(updateResource);
    }

    @Override
    public TSysResource getInfoByCode(String code, Integer excludeId) throws Exception {
        TSysResourceExample example = new TSysResourceExample();
        TSysResourceExample.Criteria criteria = example.createCriteria();
        criteria.andResourceCodeEqualTo(code);
        if(excludeId != null){
            criteria.andIdNotEqualTo(excludeId);
        }
        List<TSysResource> list = tSysResourceMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    @Override
    public TSysResource getByPath(String path) throws Exception {
        TSysResourceExample example = new TSysResourceExample();
        example.createCriteria().andResourcePathEqualTo(path);
        List<TSysResource> list = tSysResourceMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
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
        if(StringUtils.isNotBlank(req.getResourceName())){
            criteria.andResourceNameEqualTo(req.getResourceName());
        }
        example.setOrderByClause(" resource_type, sort_num desc");
        List<TSysResource> sysResources = tSysResourceMapper.selectByExample(example);
        List<SysResourceRsp> rspList = sysResources.stream().map(sysResource -> this.convertRsp(sysResource, req.getRoleCode())).collect(Collectors.toList());
        return rspList;
    }

    @Override
    public List<SysResourceRsp> getSysResourcesByType(String resourceType, String roleCode) throws Exception {
        TSysResourceExample example = new TSysResourceExample();
        example.createCriteria().andResourceTypeEqualTo(resourceType);
        example.setOrderByClause(" sort_num");
        List<TSysResource> sysResources = tSysResourceMapper.selectByExample(example);
        List<SysResourceRsp> rspList = sysResources.stream().map(sysResource -> this.convertRsp(sysResource, roleCode)).collect(Collectors.toList());
        return rspList;
    }

    @Override
    public List<SysResourceRsp> getAllSysResources(String roleCode, Integer onlyAuth) throws Exception {
        List<SysResourceRsp> dList = this.getSysResourcesByType("D", roleCode);
        List<SysResourceRsp> mList = this.getSysResourcesByType("M", roleCode);
        List<SysResourceRsp> bList = this.getSysResourcesByType("B", roleCode);
        Map<String, List<SysResourceRsp>> bGroup = bList.stream().collect(Collectors.groupingBy(SysResourceRsp::getParentCode));
        for(SysResourceRsp rsp:mList){
            rsp.setChildList(bGroup.get(rsp.getResourceCode()));
        }
        Map<String, List<SysResourceRsp>> mGroup = mList.stream().collect(Collectors.groupingBy(SysResourceRsp::getParentCode));
        for(SysResourceRsp rsp:dList){
            rsp.setChildList(mGroup.get(rsp.getResourceCode()));
        }
        if(onlyAuth != null && onlyAuth.intValue() == 1){
            List<SysResourceRsp> result = dList.stream().filter(obj->obj.getIsAuth().intValue() == 1).collect(Collectors.toList());
            return result;
        }
        return dList;
    }

    private SysResourceRsp convertRsp(TSysResource sysResource, String roleCode){
        SysResourceRsp rsp = new SysResourceRsp();
        BeanUtils.copyProperties(sysResource, rsp);
        rsp.setIsAuth(0);
        if(StringUtils.isNotBlank(roleCode)){
            try{
                TSysRoleResource roleResource = roleResourceService.getInfoByRoleCodeAndResCode(roleCode, sysResource.getResourceCode());
                if(roleResource != null){
                    rsp.setIsAuth(1);
                }
            }catch(Exception e){
                logger.error("SysResourceRsp-convertRsp-e", e);
                throw new BizException(CodeCons.ERROR, "获取权限失败");
            }
        }
        return rsp;
    }

}
