package com.coin.service;

import com.coin.entity.Prize;

public interface CustPrizeService {

    Prize getInfoById(Integer id) throws Exception;

    int addCustPrize(String loginName, Prize prize) throws Exception;

}
