package com.coin.mapper.ext;

import com.coin.entity.TCustomer;
import com.coin.req.CustomerReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {

    List<TCustomer> getCustomerList(CustomerReq req);

    void createCustomer(TCustomer customer);

    void createBatch(List<TCustomer> list);

    int updateTotalNum(TCustomer customer);

    int updateWallet(TCustomer customer);

    int updateIsLogin(String loginName);

    int setLoginPass(TCustomer customer);

    int addUsedNum(@Param("loginName") String loginName, @Param("rouletteUsedTime") Integer addTime);

}
