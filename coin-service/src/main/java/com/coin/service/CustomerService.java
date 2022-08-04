package com.coin.service;

import com.coin.entity.Customer;
import com.coin.entity.Prize;

public interface CustomerService {

    Customer getInfoByLoginName(String loginName) throws Exception;

    Prize doLottery(String loginName) throws Exception;

    void createCustomer(String loginName, String loginPass) throws Exception;

}
