package com.coin.mapper;

import com.coin.entity.Prize;
import com.coin.req.PrizeReq;
import com.coin.rsp.PrizeRsp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrizeMapper {

    Prize getInfoById(@Param("id") Integer id);
    PrizeRsp totalRate();
    Prize getInfoByName(@Param("prizeName") String prizeName);
    Prize getInfoByAmount(@Param("id") Integer excludeId, @Param("amount") Integer amount);
    List<Prize> getPrizeList(PrizeReq req);
    void addPrize(Prize prize);
    void updateById(Prize prize);
    int addUsedNum(Prize prize);
}
