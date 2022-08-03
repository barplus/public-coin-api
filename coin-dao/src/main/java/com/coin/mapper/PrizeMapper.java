package com.coin.mapper;

import com.coin.entity.Prize;
import com.coin.req.office.PrizeReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrizeMapper {

    Prize getInfoById(@Param("id") Integer id);

    Prize getInfoByName(@Param("prizeName") String prizeName);

    void addPrize(Prize prize);

    List<Prize> getPrizeList(PrizeReq req);

}
