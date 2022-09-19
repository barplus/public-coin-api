package com.coin.service;

import com.coin.entity.TDict;
import com.coin.req.ContestConfigReq;
import com.coin.req.DictReq;
import com.coin.rsp.ContestConfigRsp;

import java.util.List;

public interface DictService {

    List<TDict> getListByType(DictReq dictReq) throws Exception;

    TDict getById(Integer id) throws Exception;

    TDict getDefaultByType(String dictType) throws Exception;

    TDict getByTypeAndCode(String dictType, String dictCode) throws Exception;

    String getValByTypeAndCode(String dictType, String dictCode) throws Exception;

    ContestConfigRsp getContestConfig() throws Exception;

    void add(DictReq req) throws Exception;

    void update(DictReq req) throws Exception;

    void delete(Integer id) throws Exception;

    void saveContestConfig(ContestConfigReq req) throws Exception;

}
