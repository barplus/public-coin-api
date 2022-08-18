package com.coin.service.impl;

import com.coin.entity.TSysUser;
import com.coin.entity.TSysUserExample;
import com.coin.mapper.TSysUserMapper;
import com.coin.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

//    @Resource
//    private SysUserMapper userMapper;
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
//        return userMapper.getUserByLoginName(loginName);
    }

}
