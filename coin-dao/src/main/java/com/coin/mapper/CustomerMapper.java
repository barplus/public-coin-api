package com.coin.mapper;

import com.coin.entity.Customer;
import com.coin.req.CustomerReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {

    Customer getInfoByLoginName(@Param("loginName") String loginName);

    Customer getInfoById(@Param("id") Integer loginName);

    List<Customer> getCustomerList(CustomerReq req);

    void createCustomer(Customer customer);

    void createBatch(List<Customer> list);

    int updateTotalNum(Customer customer);

    int updateIsLogin(String loginName);

    int setLoginPass(Customer customer);

    int addUsedNum(@Param("loginName") String loginName, @Param("rouletteUsedTime") Integer addTime);

}
