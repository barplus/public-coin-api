package com.coin.service.impl;

import com.coin.entity.Customer;
import com.coin.entity.Prize;
import com.coin.mapper.CustomerMapper;
import com.coin.mapper.PrizeMapper;
import com.coin.req.PrizeReq;
import com.coin.service.CustPrizeService;
import com.coin.service.CustomerService;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.BizUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
    public void createCustomer(String loginName, String loginPass) throws Exception {
        Customer customer = BizUtil.getInsertInfo(new Customer(), "sys-api", new Date());
        customer.setLoginName(loginName);
        customer.setLoginPass(loginPass);
        customerMapper.createCustomer(customer);
    }

}
