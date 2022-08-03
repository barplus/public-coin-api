package com.coin.mapper;

import com.coin.entity.Prize;
import org.apache.ibatis.annotations.Param;

public interface PrizeMapper {

    Prize getInfoById(@Param("id") Integer id);

}
