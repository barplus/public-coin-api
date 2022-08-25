package com.coin.service.impl;

import com.coin.entity.TPrize;
import com.coin.entity.TPrizeExample;
import com.coin.mapper.TPrizeMapper;
import com.coin.mapper.ext.PrizeMapper;
import com.coin.req.PrizeReq;
import com.coin.rsp.PrizeRsp;
import com.coin.service.PrizeService;
import com.coin.service.constant.BizCons;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.BizUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrizeServiceImpl implements PrizeService {

    @Resource
    private PrizeMapper prizeMapper;
    @Resource
    private TPrizeMapper tPrizeMapper;

    @Override
    public PrizeRsp getInfoById(Integer id) throws Exception {
        TPrize prize = tPrizeMapper.selectByPrimaryKey(id);
        PrizeRsp rsp = new PrizeRsp();
        BeanUtils.copyProperties(prize, rsp);
        return rsp;
    }

    @Override
    public TPrize getInfoByName(String prizeName) throws Exception {
        TPrizeExample example = new TPrizeExample();
        example.createCriteria().andPrizeNameEqualTo(prizeName);
        List<TPrize> list = tPrizeMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    @Override
    public PrizeRsp totalRate() throws Exception {
        PrizeRsp rsp = prizeMapper.totalRate();
        return rsp;
    }

    @Override
    public void addPrize(PrizeReq req) throws Exception {
        TPrize oldPrize = this.getInfoByName(req.getPrizeName());
        if(oldPrize != null){
            throw new BizException(CodeCons.ERROR, "重复的奖品名");
        }
        TPrize prizeByAmount = prizeMapper.getInfoByAmount(null, req.getAmount());
        if(prizeByAmount != null){
            throw new BizException(CodeCons.ERROR, "重复的奖品价值");
        }
        if(req.getRate().compareTo(new BigDecimal("1")) == 1){
            throw new BizException(CodeCons.ERROR, "单个奖品中奖率不能大于100%");
        }
        String[] vipRates = req.getVipRate().split(";");
        for(String vipRate:vipRates){
            String[] rate = vipRate.split("_");
            if(!"null".equals(rate[2]) && new BigDecimal(rate[2]).compareTo(new BigDecimal(1)) > 0){
                throw new BizException(CodeCons.ERROR, "单个奖品VIP中奖率不能大于100%");
            }
        }
        TPrize prize = BizUtil.getInsertInfo(new TPrize(), req.getLoginName(), new Date());
        prize.setPrizeName(req.getPrizeName());
        prize.setPrizePic(req.getPrizePic());
        prize.setAmount(req.getAmount());
        prize.setMaxNum(req.getMaxNum());
        prize.setRate(req.getRate());
        prize.setVipRate(req.getVipRate());
        tPrizeMapper.insertSelective(prize);
    }

    @Override
    public void updateStatus(PrizeReq req) throws Exception {
        if(!BizCons.COMMON_DATA_STATUS.containsKey(req.getStatus())){
            throw new BizException(CodeCons.ERROR, "状态值错误");
        }
        TPrize updatePrize = BizUtil.getUpdateInfo(new TPrize(), req.getId(), req.getLoginName(), new Date());
        updatePrize.setStatus(req.getStatus());
        tPrizeMapper.updateByPrimaryKeySelective(updatePrize);
    }

    @Override
    public void updateInfo(PrizeReq req) throws Exception {
        TPrize oldPrize = tPrizeMapper.selectByPrimaryKey(req.getId());
        if(oldPrize == null){
            throw new BizException(CodeCons.ERROR, "奖品信息不存在");
        }
        TPrize updatePrize = BizUtil.getUpdateInfo(new TPrize(), req.getId(), req.getLoginName(), new Date());
        if(req.getRate() !=null){
            if(req.getRate().compareTo(new BigDecimal("1")) == 1){
                throw new BizException(CodeCons.ERROR, "中奖率不能大于100%");
            }
            updatePrize.setRate(req.getRate());
        }
        if(req.getVipRate() !=null){
            String[] vipRates = req.getVipRate().split(";");
            for(String vipRate:vipRates){
                String[] rate = vipRate.split("_");
                if(!"null".equals(rate[2]) && new BigDecimal(rate[2]).compareTo(new BigDecimal(1)) > 0){
                    throw new BizException(CodeCons.ERROR, "单个奖品VIP中奖率不能大于100%");
                }
            }
            updatePrize.setVipRate(req.getVipRate());
        }
        if(req.getPrizeName() != null){
            TPrize prize = this.getInfoByName(req.getPrizeName());
            if(prize != null && prize.getId() != req.getId()){
                throw new BizException(CodeCons.ERROR, "奖品名称不能和其他奖品一致");
            }
            updatePrize.setPrizeName(req.getPrizeName());
        }
        if(StringUtils.isNotBlank(req.getPrizePic())){
            updatePrize.setPrizePic(req.getPrizePic());
        }
        if(req.getAmount() != null){
            TPrize prizeByAmount = prizeMapper.getInfoByAmount(oldPrize.getId(), req.getAmount());
            if(prizeByAmount != null){
                throw new BizException(CodeCons.ERROR, "奖品价值和【"+prizeByAmount.getPrizeName()+"】重复");
            }
            updatePrize.setAmount(req.getAmount());
        }
        if(req.getMaxNum() != null){
            if(req.getMaxNum() < oldPrize.getUsedNum()){
                throw new BizException(CodeCons.ERROR, "最大投放量不能小于已被抽取的数量");
            }
            updatePrize.setMaxNum(req.getMaxNum());
        }
        tPrizeMapper.updateByPrimaryKeySelective(updatePrize);
    }

    @Override
    public PageInfo<TPrize> pageList(PrizeReq req) throws Exception {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<TPrize> prizes = prizeMapper.getPrizeList(req);
        PageInfo<TPrize> page = new PageInfo<>(prizes);
        return page;
    }

    @Override
    public List<PrizeRsp> pageDatas(PrizeReq req) throws Exception {
        req.setStatus(1);
        req.setRateNoZero(1);
        List<TPrize> prizes = prizeMapper.getPrizeList(req);
        List<PrizeRsp> list = prizes.stream().map(prize->this.convertRsp(prize)).collect(Collectors.toList());
        return list;
    }

    private PrizeRsp convertRsp(TPrize prize){
        PrizeRsp rsp = new PrizeRsp();
        BeanUtils.copyProperties(prize, rsp);
        return rsp;
    }

}
