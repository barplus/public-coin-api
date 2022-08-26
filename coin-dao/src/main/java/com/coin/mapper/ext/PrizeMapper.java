package com.coin.mapper.ext;

import com.coin.entity.TPrize;
import com.coin.req.PrizeReq;
import com.coin.rsp.PrizeRsp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrizeMapper {

    PrizeRsp totalRate();

    TPrize getInfoByAmount(@Param("id") Integer excludeId, @Param("amount") Integer amount);

    List<TPrize> getPrizeList(PrizeReq req);

    int addUsedNum(TPrize prize);

}
