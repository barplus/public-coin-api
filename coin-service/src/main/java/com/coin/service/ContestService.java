package com.coin.service;

import com.coin.entity.TContest;
import com.coin.req.ContestReq;
import com.coin.rsp.ContestRsp;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ContestService {

    void addContest(ContestReq req) throws Exception;

    void update(ContestReq req) throws Exception;

    void updateStatus(ContestReq req) throws Exception;

    void updateResult(ContestReq req) throws Exception;

    void delete(ContestReq req) throws Exception;

    List<ContestRsp> getListByType(ContestReq req) throws Exception;

    PageInfo<TContest> pageList(ContestReq req) throws Exception;

}
