package com.coin.mapper.ext;

import com.coin.entity.TCustomer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {

    void createBatch(List<TCustomer> list);

    int updateTotalNum(TCustomer customer);

    int updateIsLogin(String loginName);

    int setLoginPass(TCustomer customer);

    int addUsedNum(@Param("loginName") String loginName, @Param("rouletteUsedTime") Integer addTime);

    int clearLotteryNum();

}
