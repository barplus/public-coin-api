package com.coin.service;

import com.coin.entity.Customer;

public interface CustomerService {

    Customer getInfoByLoginName(String loginName) throws Exception;

}
