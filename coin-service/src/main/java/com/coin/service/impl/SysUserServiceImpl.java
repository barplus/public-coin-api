package com.coin.service.impl;

import com.coin.entity.TSysUser;
import com.coin.entity.TSysUserExample;
import com.coin.mapper.TSysUserMapper;
import com.coin.req.SysUserReq;
import com.coin.rsp.SysUserRsp;
import com.coin.service.SysUserService;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.BizUtil;
import com.coin.service.util.MD5Util;
import com.coin.service.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private TSysUserMapper tSysUserMapper;

    @Override
    public TSysUser getUserByLoginName(String loginName) throws Exception {
        TSysUserExample example = new TSysUserExample();
        example.createCriteria().andLoginNameEqualTo(loginName);
        List<TSysUser> list = tSysUserMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    @Override
    public SysUserRsp getUserByLogName(String loginName) throws Exception {
        TSysUser sysUser = this.getUserByLoginName(loginName);
        if(sysUser == null){
            return null;
        }
        SysUserRsp rsp = this.convertRsp(sysUser);
        return rsp;
    }

    @Override
    public void updatePass(SysUserReq req) throws Exception {
        TSysUser user = this.getUserByLoginName(req.getLoginName());
        if(!MD5Util.MD5(req.getLoginPass()).equals(user.getLoginPass())){
            throw new BizException(CodeCons.ERROR, "原密码输入错误");
        }
        TSysUser updateUser = BizUtil.getUpdateInfo(new TSysUser(), user.getId(), req.getLoginName(), new Date());
        updateUser.setLoginPass(MD5Util.MD5(req.getNewPass()));
        tSysUserMapper.updateByPrimaryKeySelective(updateUser);
    }

    @Override
    public void update(SysUserReq req) throws Exception {
        TSysUser updateUser = BizUtil.getUpdateInfo(new TSysUser(), req.getId(), req.getLoginName(), new Date());
        updateUser.setRoleCode(req.getRoleCode());
        updateUser.setStatus(req.getStatus());
        tSysUserMapper.updateByPrimaryKeySelective(updateUser);
    }

    @Override
    public PageInfo<SysUserRsp> pageList(SysUserReq req) throws Exception {
        TSysUserExample example = new TSysUserExample();
        TSysUserExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(req.getQueryLoginName())){
            criteria.andLoginNameEqualTo(req.getQueryLoginName());
        }
        example.setOrderByClause(" id desc");
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<TSysUser> sysUsers = tSysUserMapper.selectByExample(example);
        PageInfo<TSysUser> page = new PageInfo<>(sysUsers);
        List<SysUserRsp> rspList = sysUsers.stream().map(sysUser->this.convertRsp(sysUser)).collect(Collectors.toList());
        return PageUtil.pageInfo2PageRsp(page, rspList);
    }

    private SysUserRsp convertRsp(TSysUser sysUser){
        SysUserRsp rsp = new SysUserRsp();
        BeanUtils.copyProperties(sysUser, rsp);
        return rsp;
    }

}
