package com.coin.mapper;

import com.coin.entity.Customer;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {

    Customer getInfoByLoginName(@Param("loginName") String loginName);

    void createCustomer(Customer customer);

}
