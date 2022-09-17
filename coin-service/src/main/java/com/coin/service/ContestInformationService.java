package com.coin.service;

import com.coin.entity.TContestInformation;
import com.coin.entity.TContestNotice;
import com.coin.req.ContestInformationReq;
import com.coin.req.ContestNoticeReq;
import com.github.pagehelper.PageInfo;

public interface ContestInformationService {

    PageInfo<TContestInformation> pageList(ContestInformationReq req);

    void add(ContestInformationReq req) throws Exception;

    void update(ContestInformationReq req) throws Exception;

    void delete(ContestInformationReq req) throws Exception;

}
