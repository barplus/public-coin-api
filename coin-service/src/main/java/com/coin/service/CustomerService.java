package com.coin.service;

import com.coin.entity.TCustomer;
import com.coin.req.CustomerReq;
import com.coin.rsp.CustomerRsp;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CustomerService {

    TCustomer getInfoByLoginName(String loginName) throws Exception;
    CustomerRsp getByLoginName(String loginName, boolean fill) throws Exception;

    PageInfo<CustomerRsp> pageList(CustomerReq req) throws Exception;
    List<TCustomer> getList(CustomerReq req) throws Exception;

    void updateTotalNum(CustomerReq req) throws Exception;
    void updateWallet(CustomerReq req) throws Exception;
    void updateIsLogin(String loginName) throws Exception;
    void importCustomerList(List<CustomerRsp> rsps, String updateUser) throws Exception;
    void everydaySign(CustomerReq req) throws Exception;
    void updateLoginPass(TCustomer customer, int type, String sysUser) throws Exception;

    void createCustomer(String loginName, String loginPass) throws Exception;

}
