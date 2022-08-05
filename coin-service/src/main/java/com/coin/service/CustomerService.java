package com.coin.service;

import com.coin.entity.Customer;
import com.coin.entity.Prize;
import com.coin.req.CustomerReq;
import com.github.pagehelper.PageInfo;

public interface CustomerService {

    Customer getInfoByLoginName(String loginName) throws Exception;

    PageInfo<Prize> pageList(CustomerReq req) throws Exception;

    void createCustomer(String loginName, String loginPass) throws Exception;

}
