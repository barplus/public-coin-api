package com.coin.service;

import com.coin.entity.TContestSponsorshipLogo;
import com.coin.req.ContestSponsorshipLogoReq;

import java.util.List;

public interface ContestSponsorshipLogoService {

    List<TContestSponsorshipLogo> getAllList() throws Exception;

    void add(ContestSponsorshipLogoReq req) throws Exception;

    void delete(Integer id, String updateUser) throws Exception;

}
