package com.coin.service.impl;

import com.coin.entity.Prize;
import com.coin.mapper.CustPrizeMapper;
import com.coin.mapper.SysUserMapper;
import com.coin.req.office.PrizeReq;
import com.coin.service.CustPrizeService;
import com.coin.service.PrizeService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustPrizeServiceImpl implements CustPrizeService {

    @Resource
    private CustPrizeMapper custPrizeMapper;

    @Override
    public Prize getInfoById(Integer id) throws Exception {
        return null;
    }

}
