package com.coin.service.impl;

import com.coin.entity.Customer;
import com.coin.mapper.CustomerMapper;
import com.coin.req.CustomerReq;
import com.coin.service.CustomerService;
import com.coin.service.exception.BizException;
import com.coin.service.util.BizUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
    public PageInfo<Customer> pageList(CustomerReq req) throws Exception {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<Customer> customers = customerMapper.getCustomerList(req);
        PageInfo<Customer> page = new PageInfo<>(customers);
        return page;
    }

    @Override
    public void update(CustomerReq req) throws Exception {
        if(req.getRouletteTotalTime().intValue() < 1){
            throw new BizException("9999", "增加的次数不能小于1");
        }
        Customer updateCustomer = BizUtil.getUpdateInfo(new Customer(), req.getId(), req.getLoginName(), new Date());
        updateCustomer.setRouletteTotalTime(req.getRouletteTotalTime());
        int count = customerMapper.updateTotalNum(updateCustomer);
        if(count != 1){
            throw new BizException("9999", "修改失败，用户信息已变化，请刷新后再修改");
        }
    }

    @Override
    public void createCustomer(String loginName, String loginPass) throws Exception {
        Customer customer = BizUtil.getInsertInfo(new Customer(), "sys-api", new Date());
        customer.setLoginName(loginName);
        customer.setLoginPass(loginPass);
        customerMapper.createCustomer(customer);
    }

}
