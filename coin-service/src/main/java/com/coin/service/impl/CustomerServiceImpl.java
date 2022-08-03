package com.coin.service.impl;

import com.coin.entity.Customer;
import com.coin.entity.Prize;
import com.coin.mapper.CustomerMapper;
import com.coin.mapper.SysUserMapper;
import com.coin.service.CustomerService;
import com.coin.service.PrizeService;
import com.coin.utils.BizUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public Customer getInfoByLoginName(String loginName) throws Exception {
        return customerMapper.getInfoByLoginName(loginName);
    }

    @Override
    public void createCustomer(String loginName, String loginPass) throws Exception {
        Customer customer = BizUtil.getInsertInfo(new Customer(), "sys-api", new Date());
        customer.setLoginName(loginName);
        customer.setLoginPass(loginPass);
        customerMapper.createCustomer(customer);
    }

}
