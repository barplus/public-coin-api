package com.coin.service;

import com.coin.entity.Customer;
import com.coin.req.CustomerReq;
import com.github.pagehelper.PageInfo;

public interface CustomerService {

    Customer getInfoByLoginName(String loginName) throws Exception;

    PageInfo<Customer> pageList(CustomerReq req) throws Exception;

    void update(CustomerReq req) throws Exception;
    void updateIsLogin(String loginName) throws Exception;

    void updateLoginPass(Customer customer) throws Exception;

    void createCustomer(String loginName, String loginPass) throws Exception;

}
