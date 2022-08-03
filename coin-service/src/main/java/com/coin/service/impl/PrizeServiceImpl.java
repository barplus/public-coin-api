package com.coin.service.impl;

import com.coin.entity.Prize;
import com.coin.entity.SysUser;
import com.coin.mapper.PrizeMapper;
import com.coin.mapper.SysUserMapper;
import com.coin.service.PrizeService;
import com.coin.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PrizeServiceImpl implements PrizeService {

    @Resource
    private PrizeMapper prizeMapper;

    @Override
    public Prize getInfoById(Integer id) throws Exception {
        return null;
    }
}
