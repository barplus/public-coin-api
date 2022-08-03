package com.coin.service;

import com.coin.entity.Prize;
import com.coin.req.office.PrizeReq;
import com.github.pagehelper.PageInfo;

public interface PrizeService {

    Prize getInfoById(Integer id) throws Exception;

    void addPrize(PrizeReq req) throws Exception;

    PageInfo<Prize> pageList(PrizeReq req) throws Exception;

}
