package com.coin.service;

import com.coin.entity.Prize;
import com.coin.req.PrizeReq;
import com.coin.rsp.PrizeRsp;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PrizeService {

    PrizeRsp getInfoById(Integer id) throws Exception;
    void addPrize(PrizeReq req) throws Exception;
    void updateStatus(PrizeReq req) throws Exception;
    void updateInfo(PrizeReq req) throws Exception;
    PageInfo<Prize> pageList(PrizeReq req) throws Exception;
    List<PrizeRsp> pageDatas(PrizeReq req) throws Exception;

}
