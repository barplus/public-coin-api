package com.coin.service;

import com.coin.entity.Dict;
import com.coin.req.DictReq;

import java.util.List;

public interface DictService {

    List<Dict> getListByType(DictReq dictReq) throws Exception;

    void add(DictReq req) throws Exception;

}
