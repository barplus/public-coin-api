package com.coin.mapper;

import com.coin.entity.CustPrize;
import org.apache.ibatis.annotations.Param;

public interface CustPrizeMapper {

    CustPrize getInfoById(@Param("id") Integer loginName);

}
