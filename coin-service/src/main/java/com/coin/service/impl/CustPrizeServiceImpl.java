package com.coin.service.impl;

import com.coin.entity.CustPrize;
import com.coin.entity.Prize;
import com.coin.mapper.CustPrizeMapper;
import com.coin.service.CustPrizeService;
import com.coin.utils.BizUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class CustPrizeServiceImpl implements CustPrizeService {

    @Resource
    private CustPrizeMapper custPrizeMapper;

    @Override
    public Prize getInfoById(Integer id) throws Exception {
        return null;
    }

    @Override
    public int addCustPrize(String loginName, Prize prize) throws Exception {
        CustPrize custPrize = BizUtil.getInsertInfo(new CustPrize(), loginName, new Date());
        if(prize != null){
            custPrize.setPrizeId(prize.getId());
            custPrize.setPrizeName(prize.getPrizeName());
        }
        custPrize.setLoginName(loginName);
        return custPrizeMapper.addCustPrize(custPrize);
    }

}
