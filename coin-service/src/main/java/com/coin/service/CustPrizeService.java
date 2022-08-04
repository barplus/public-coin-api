package com.coin.service;

import com.coin.entity.CustPrize;
import com.coin.entity.Prize;
import com.coin.req.CustPrizeReq;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CustPrizeService {

    Prize getInfoById(Integer id) throws Exception;

    PageInfo<CustPrize> pageList(@RequestBody CustPrizeReq req) throws Exception;

    List<String> custPrizeRecord() throws Exception;

    Prize doLottery(String loginName) throws Exception;

    int addCustPrize(String loginName, Prize prize) throws Exception;

}
