package com.coin.mapper.ext;

import com.coin.entity.TCustPrize;
import com.coin.req.CustPrizeReq;
import com.coin.rsp.CustPrizeRsp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustPrizeMapper {

    List<TCustPrize> getCustPrizeList(CustPrizeReq req);

    List<CustPrizeRsp> getDatas(CustPrizeReq req);

    List<TCustPrize> getTwoCustPrize30s();

    List<TCustPrize> getTwoCustPrize();

    int addCustPrize(TCustPrize prize);

    int updateById(TCustPrize prize);

}
