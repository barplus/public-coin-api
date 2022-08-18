package com.coin.service;

import com.coin.entity.TDict;
import com.coin.req.DictReq;

import java.util.List;

public interface DictService {

    List<TDict> getListByType(DictReq dictReq) throws Exception;

    TDict getById(Integer id) throws Exception;

    void add(DictReq req) throws Exception;

    void update(DictReq req) throws Exception;

}
