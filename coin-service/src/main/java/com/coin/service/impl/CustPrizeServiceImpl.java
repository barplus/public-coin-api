package com.coin.service.impl;

import com.coin.entity.Prize;
import com.coin.mapper.CustPrizeMapper;
import com.coin.mapper.SysUserMapper;
import com.coin.service.PrizeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustPrizeServiceImpl implements PrizeService {

    @Resource
    private CustPrizeMapper custPrizeMapper;

    @Override
    public Prize getInfoById(Integer id) throws Exception {
        return null;
    }
}
