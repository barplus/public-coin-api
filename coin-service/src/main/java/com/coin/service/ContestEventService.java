package com.coin.service;

import com.coin.entity.TContestEvent;
import com.coin.req.ContestEventReq;
import com.github.pagehelper.PageInfo;

public interface ContestEventService {

    PageInfo<TContestEvent> pageList(ContestEventReq req);

    void add(ContestEventReq req) throws Exception;

    void update(ContestEventReq req) throws Exception;

    void delete(Integer id, String updateUser) throws Exception;

}
