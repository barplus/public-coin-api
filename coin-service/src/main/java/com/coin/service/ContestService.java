package com.coin.service;

import com.coin.entity.TContest;
import com.coin.req.ContestReq;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ContestService {

    void addContest(ContestReq req) throws Exception;

    void update(ContestReq req) throws Exception;

    List<TContest> getListByType(String contestType) throws Exception;

    PageInfo<TContest> pageList(ContestReq req) throws Exception;

}
