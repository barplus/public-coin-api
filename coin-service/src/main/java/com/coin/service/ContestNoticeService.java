package com.coin.service;

import com.coin.entity.TContestNotice;
import com.coin.req.ContestNoticeReq;
import com.github.pagehelper.PageInfo;

public interface ContestNoticeService {

    PageInfo<TContestNotice> pageList(ContestNoticeReq req) throws Exception;

    void add(ContestNoticeReq req) throws Exception;

    void update(ContestNoticeReq req) throws Exception;

    void delete(ContestNoticeReq req) throws Exception;

}
