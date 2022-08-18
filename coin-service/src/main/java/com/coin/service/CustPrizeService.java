package com.coin.service;

import com.coin.entity.TCustPrize;
import com.coin.entity.TPrize;
import com.coin.req.CustPrizeReq;
import com.coin.rsp.CustPrizeRsp;
import com.coin.rsp.PrizeRsp;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CustPrizeService {

    TPrize getInfoById(Integer id) throws Exception;

    PageInfo<TCustPrize> pageList(CustPrizeReq req) throws Exception;

    PageInfo<CustPrizeRsp> pageDatas(CustPrizeReq req) throws Exception;

    List<String> custPrizeRecord() throws Exception;

    PrizeRsp doLottery(String loginName) throws Exception;

    List<PrizeRsp> doLotteryTen(String loginName) throws Exception;

    int addCustPrize(String loginName, TPrize prize) throws Exception;

}
