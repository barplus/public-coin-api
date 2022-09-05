package com.coin.service.impl;

import com.coin.entity.TSysRole;
import com.coin.entity.TSysRoleExample;
import com.coin.mapper.TSysRoleMapper;
import com.coin.req.SysRoleReq;
import com.coin.req.SysRoleResourceReq;
import com.coin.rsp.SysRoleRsp;
import com.coin.service.SysRoleResourceService;
import com.coin.service.SysRoleService;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.BizUtil;
import com.coin.service.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private TSysRoleMapper sysRoleMapper;
    @Resource
    private SysRoleResourceService roleResourceService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addSysRole(SysRoleReq req) throws Exception {
        TSysRole role = this.getRoleByCode(req.getRoleCode());
        if(role != null){
            throw new BindException(CodeCons.ERROR, "角色编码已被占用，请更改");
        }
        role = this.getRoleByName(req.getRoleName(), null);
        if(role != null){
            throw new BindException(CodeCons.ERROR, "角色名称已被占用，请更改");
        }
        TSysRole newSysRole = BizUtil.getInsertInfo(new TSysRole(), req.getLoginName(), new Date());
        newSysRole.setRoleCode(req.getRoleCode());
        newSysRole.setRoleName(req.getRoleName());
        newSysRole.setStatus(req.getStatus());
        newSysRole.setSortNum(req.getSortNum());
        sysRoleMapper.insertSelective(newSysRole);
        this.saveRoleResources(req);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateSysRole(SysRoleReq req) throws Exception {
        TSysRole oldRole = sysRoleMapper.selectByPrimaryKey(req.getId());
        if(StringUtils.isNotBlank(req.getRoleName()) && !oldRole.getRoleName().equals(req.getRoleName())){
            TSysRole sameNameRole = this.getRoleByName(req.getRoleName(), req.getId());
            if(sameNameRole != null){
                throw new BizException(CodeCons.ERROR, "角色名称已被占用，请更改");
            }
        }
        TSysRole updateRole = BizUtil.getUpdateInfo(new TSysRole(), oldRole.getId(), req.getLoginName(), new Date());
        updateRole.setRoleName(req.getRoleName());
        updateRole.setStatus(req.getStatus());
        updateRole.setSortNum(req.getSortNum());
        sysRoleMapper.updateByPrimaryKeySelective(updateRole);
        this.saveRoleResources(req);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveRoleResources(SysRoleReq req) throws Exception {
        SysRoleResourceReq roleResourceReq = new SysRoleResourceReq();
        roleResourceReq.setRoleCode(req.getRoleCode());
        roleResourceReq.setAddResourceCodes(req.getAddResourceCodes());
        roleResourceReq.setDelResourceCodes(req.getDelResourceCodes());
        if(StringUtils.isNotBlank(req.getAddResourceCodes())){
//            roleResourceService.delAllByRoleCode(req.getRoleCode());
            roleResourceService.addSysRoleResources(roleResourceReq);
        }
        if(StringUtils.isNotBlank(req.getDelResourceCodes())){
            roleResourceService.delSysRoleResources(roleResourceReq);
        }
    }

    @Override
    public TSysRole getRoleByCode(String roleCode) throws Exception {
        TSysRoleExample example = new TSysRoleExample();
        TSysRoleExample.Criteria criteria = example.createCriteria();
        criteria.andRoleCodeEqualTo(roleCode);
        List<TSysRole> list = sysRoleMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    @Override
    public TSysRole getRoleByName(String roleName, Integer excludeId) throws Exception {
        TSysRoleExample example = new TSysRoleExample();
        TSysRoleExample.Criteria criteria = example.createCriteria();
        criteria.andRoleNameEqualTo(roleName);
        if(excludeId != null){
            criteria.andIdNotEqualTo(excludeId);
        }
        List<TSysRole> list = sysRoleMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    @Override
    public PageInfo<SysRoleRsp> pageList(SysRoleReq req) throws Exception {
        TSysRoleExample example = new TSysRoleExample();
        TSysRoleExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(req.getRoleName())){
            criteria.andRoleNameEqualTo(req.getRoleName());
        }
        example.setOrderByClause(" sort_num");
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<TSysRole> sysRoles = sysRoleMapper.selectByExample(example);
        PageInfo<TSysRole> page = new PageInfo<>(sysRoles);
        List<SysRoleRsp> rspList = sysRoles.stream().map(sysUser->this.convertRsp(sysUser)).collect(Collectors.toList());
        return PageUtil.pageInfo2PageRsp(page, rspList);
    }

    private SysRoleRsp convertRsp(TSysRole sysRole){
        SysRoleRsp rsp = new SysRoleRsp();
        BeanUtils.copyProperties(sysRole, rsp);
        return rsp;
    }

}
