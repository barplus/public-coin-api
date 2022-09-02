package com.coin.service;

import com.coin.entity.TSysDomain;
import com.coin.req.SysDomainReq;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SysDomainService {

    void createBatch(SysDomainReq req) throws Exception;
    void update(SysDomainReq req) throws Exception;
    PageInfo<TSysDomain> pageList(SysDomainReq req) throws Exception;
    List<TSysDomain> getListBySysName(String SysName, String orderBy) throws Exception;

}
