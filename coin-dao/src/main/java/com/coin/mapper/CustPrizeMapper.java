package com.coin.mapper;

import com.coin.entity.CustPrize;
import com.coin.req.CustPrizeReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustPrizeMapper {

    CustPrize getInfoById(@Param("id") Integer loginName);

    List<CustPrize> getCustPrizeList(CustPrizeReq req);

    List<CustPrize> getTwoCustPrize30s();

    List<CustPrize> getTwoCustPrize();

    int addCustPrize(CustPrize prize);

    int updateById(CustPrize prize);

}
