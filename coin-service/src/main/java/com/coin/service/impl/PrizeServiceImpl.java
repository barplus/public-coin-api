package com.coin.service.impl;

import com.coin.entity.Prize;
import com.coin.mapper.PrizeMapper;
import com.coin.req.PrizeReq;
import com.coin.rsp.PrizeRsp;
import com.coin.service.PrizeService;
import com.coin.service.constant.BizCons;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.BizUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrizeServiceImpl implements PrizeService {

    @Resource
    private PrizeMapper prizeMapper;

    @Override
    public PrizeRsp getInfoById(Integer id) throws Exception {
        Prize prize = prizeMapper.getInfoById(id);
        PrizeRsp rsp = new PrizeRsp();
        BeanUtils.copyProperties(prize, rsp);
        return rsp;
    }

    @Override
    public void addPrize(PrizeReq req) throws Exception {
        Prize oldPrize = prizeMapper.getInfoByName(req.getPrizeName());
        if(oldPrize != null){
            throw new BizException(CodeCons.ERROR, "重复的奖品名");
        }
        if(req.getRate().compareTo(new BigDecimal("1")) == 1){
            throw new BizException(CodeCons.ERROR, "中奖率不能大于100%");
        }
        Prize prize = BizUtil.getInsertInfo(new Prize(), req.getLoginName(), new Date());
        prize.setPrizeName(req.getPrizeName());
        prize.setAmount(req.getAmount());
        prize.setMaxNum(req.getMaxNum());
        prize.setRate(req.getRate());
        prizeMapper.addPrize(prize);
    }

    @Override
    public void updateStatus(PrizeReq req) throws Exception {
        if(!BizCons.COMMON_DATA_STATUS.containsKey(req.getStatus())){
            throw new BizException(CodeCons.ERROR, "状态值错误");
        }
        Prize updatePrize = BizUtil.getUpdateInfo(new Prize(), req.getId(), req.getLoginName(), new Date());
        updatePrize.setStatus(req.getStatus());
        prizeMapper.updateById(updatePrize);
    }

    @Override
    public void updateInfo(PrizeReq req) throws Exception {
        Prize oldPrize = prizeMapper.getInfoById(req.getId());
        if(oldPrize == null){
            throw new BizException(CodeCons.ERROR, "奖品信息不存在");
        }
        Prize updatePrize = BizUtil.getUpdateInfo(new Prize(), req.getId(), req.getLoginName(), new Date());
        if(req.getRate() !=null){
            if(req.getRate().compareTo(new BigDecimal("1")) == 1){
                throw new BizException(CodeCons.ERROR, "中奖率不能大于100%");
            }
            updatePrize.setRate(req.getRate());
        }
//        if(req.getPrizeName() != null){
//            Prize prize = prizeMapper.getInfoByName(req.getPrizeName());
//            if(prize != null && prize.getId() != req.getId()){
//                throw new BizException(CodeCons.ERROR, "奖品名称不能和其他奖品一致");
//            }
//            updatePrize.setPrizeName(req.getPrizeName());
//        }
        if(req.getAmount() != null){
            updatePrize.setAmount(req.getAmount());
        }
        if(req.getMaxNum() != null){
            if(req.getMaxNum() < oldPrize.getUsedNum()){
                throw new BizException(CodeCons.ERROR, "最大投放量不能小于已被抽取的数量");
            }
            updatePrize.setMaxNum(req.getMaxNum());
        }
        prizeMapper.updateById(updatePrize);
    }

    @Override
    public PageInfo<Prize> pageList(PrizeReq req) throws Exception {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<Prize> prizes = prizeMapper.getPrizeList(req);
        PageInfo<Prize> page = new PageInfo<>(prizes);
        return page;
    }

    @Override
    public List<PrizeRsp> pageDatas(PrizeReq req) throws Exception {
        req.setStatus(1);
        req.setRateNoZero(1);
        List<Prize> prizes = prizeMapper.getPrizeList(req);
        List<PrizeRsp> list = prizes.stream().map(prize->this.convertRsp(prize)).collect(Collectors.toList());
        return list;
    }

    private PrizeRsp convertRsp(Prize prize){
        PrizeRsp rsp = new PrizeRsp();
        BeanUtils.copyProperties(prize, rsp);
        return rsp;
    }

}
