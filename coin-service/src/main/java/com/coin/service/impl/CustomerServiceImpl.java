package com.coin.service.impl;

import com.coin.entity.Customer;
import com.coin.entity.Prize;
import com.coin.mapper.CustomerMapper;
import com.coin.req.CustomerReq;
import com.coin.service.CustomerService;
import com.coin.service.util.BizUtil;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public Customer getInfoByLoginName(String loginName) throws Exception {
        return customerMapper.getInfoByLoginName(loginName);
    }

    @Override
    public PageInfo<Prize> pageList(CustomerReq req) throws Exception {
        return null;
    }

    @Override
    public void createCustomer(String loginName, String loginPass) throws Exception {
        Customer customer = BizUtil.getInsertInfo(new Customer(), "sys-api", new Date());
        customer.setLoginName(loginName);
        customer.setLoginPass(loginPass);
        customerMapper.createCustomer(customer);
    }

}
