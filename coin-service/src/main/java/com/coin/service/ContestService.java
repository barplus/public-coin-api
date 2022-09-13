package com.coin.service;

import com.coin.entity.TContest;
import com.coin.req.ContestReq;

import java.util.List;

public interface ContestService {

    void addContest(ContestReq req) throws Exception;

    List<TContest> getListByType(String contestType) throws Exception;

}
