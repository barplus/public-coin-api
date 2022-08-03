package com.coin.service.impl;

import com.coin.entity.Prize;
import com.coin.mapper.PrizeMapper;
import com.coin.req.office.PrizeReq;
import com.coin.service.PrizeService;
import com.coin.service.exception.BizException;
import com.coin.utils.BizUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class PrizeServiceImpl implements PrizeService {

    @Resource
    private PrizeMapper prizeMapper;

    @Override
    public Prize getInfoById(Integer id) throws Exception {
        return null;
    }

    @Override
    public void addPrize(PrizeReq req) throws Exception {
        Prize oldPrize = prizeMapper.getInfoByName(req.getPrizeName());
        if(oldPrize != null){
            throw new BizException("9999", "重复的奖品名");
        }
        Prize prize = BizUtil.getInsertInfo(new Prize(), req.getLoginName(), new Date());
        prize.setPrizeName(req.getPrizeName());
        prize.setAmount(req.getAmount());
        prize.setMaxNum(req.getMaxNum());
        prize.setSurplusNum(req.getSurplusNum());
        prize.setRate(req.getRate());
        prizeMapper.addPrize(prize);
    }

    @Override
    public PageInfo<Prize> pageList(PrizeReq req) throws Exception {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<Prize> prizes = prizeMapper.getPrizeList(req);
        PageInfo<Prize> page = new PageInfo<>(prizes);
        return page;
    }

}
