package com.coin.mapper.ext;

import com.coin.entity.TContest;
import com.coin.req.ContestReq;

import java.util.List;

public interface ContestMapper {

    List<TContest> getList(ContestReq req);

}