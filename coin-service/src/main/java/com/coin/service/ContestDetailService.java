package com.coin.service;

import com.coin.entity.TContestDetail;

public interface ContestDetailService {

    TContestDetail getByPid(Integer pid) throws Exception;

}
