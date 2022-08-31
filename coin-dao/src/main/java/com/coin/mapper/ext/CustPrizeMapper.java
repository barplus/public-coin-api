package com.coin.mapper.ext;

import com.coin.entity.TCustPrize;
import com.coin.req.CustPrizeReq;
import com.coin.rsp.CustPrizeRsp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustPrizeMapper {

    List<TCustPrize> getTwoCustPrizeByInterval(@Param("interval") Integer interval);

    List<TCustPrize> getTwoCustPrize();

}
