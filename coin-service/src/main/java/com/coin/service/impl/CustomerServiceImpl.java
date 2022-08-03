package com.coin.service.impl;

import com.coin.entity.Customer;
import com.coin.entity.Prize;
import com.coin.mapper.CustomerMapper;
import com.coin.mapper.SysUserMapper;
import com.coin.service.CustomerService;
import com.coin.service.PrizeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public Customer getInfoByLoginName(String loginName) throws Exception {
        return customerMapper.getInfoByLoginName(loginName);
    }
}
