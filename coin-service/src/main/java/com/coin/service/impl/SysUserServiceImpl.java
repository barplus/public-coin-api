package com.coin.service.impl;

import com.coin.entity.TSysUser;
import com.coin.entity.TSysUserExample;
import com.coin.mapper.TSysUserMapper;
import com.coin.req.SysUserReq;
import com.coin.service.SysUserService;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.BizUtil;
import com.coin.service.util.MD5Util;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
    public void updatePass(SysUserReq req) throws Exception {
        TSysUser user = this.getUserByLoginName(req.getLoginName());
        if(!MD5Util.MD5(req.getLoginPass()).equals(user.getLoginPass())){
            throw new BizException(CodeCons.ERROR, "原密码输入错误");
        }
        TSysUser updateUser = BizUtil.getUpdateInfo(new TSysUser(), user.getId(), req.getLoginName(), new Date());
        updateUser.setLoginPass(MD5Util.MD5(req.getNewPass()));
        tSysUserMapper.updateByPrimaryKeySelective(updateUser);
    }

}
