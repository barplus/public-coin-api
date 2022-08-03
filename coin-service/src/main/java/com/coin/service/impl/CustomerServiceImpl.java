package com.coin.service.impl;

import com.coin.entity.Prize;
import com.coin.mapper.CustomerMapper;
import com.coin.mapper.SysUserMapper;
import com.coin.service.PrizeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerServiceImpl implements PrizeService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public Prize getInfoById(Integer id) throws Exception {
        return null;
    }
}
