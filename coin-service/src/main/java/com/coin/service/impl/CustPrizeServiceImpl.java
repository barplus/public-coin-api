package com.coin.service.impl;

import com.coin.entity.TCustPrize;
import com.coin.entity.TCustomer;
import com.coin.entity.TPrize;
import com.coin.mapper.ext.CustPrizeMapper;
import com.coin.mapper.ext.CustomerMapper;
import com.coin.mapper.ext.PrizeMapper;
import com.coin.req.CustPrizeReq;
import com.coin.req.PrizeReq;
import com.coin.rsp.CustPrizeRsp;
import com.coin.rsp.PrizeRsp;
import com.coin.service.CustPrizeService;
import com.coin.service.CustomerService;
import com.coin.service.constant.BizCons;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.BizUtil;
import com.coin.service.util.DateUtil;
import com.coin.service.util.RedisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@Service
public class CustPrizeServiceImpl implements CustPrizeService {

    private static final Logger logger = LoggerFactory.getLogger(CustPrizeServiceImpl.class);

    @Resource
    private CustPrizeMapper custPrizeMapper;
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private CustomerService customerService;
    @Resource
    private PrizeMapper prizeMapper;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public TPrize getInfoById(Integer id) throws Exception {
        return null;
    }

    @Override
    public PageInfo<TCustPrize> pageList(CustPrizeReq req) throws Exception {
        Date today = DateUtil.getNoTimeDate(new Date());
        req.setMaxDate(DateUtil.addDays(today, 1));
        if(req.getDateType() !=null){
            int queryDay = req.getDateType().intValue();
            if(!BizCons.CUST_PRIZE_QUERY_DAY.containsKey(queryDay)){
                throw new BizException("9999", "查询日期不支持");
            }
            if(queryDay == 0){
                req.setMinDate(today);
            }
            if(queryDay == 1){
                req.setMaxDate(today);
                req.setMinDate(DateUtil.addDays(today, -1));
            }
            if(queryDay == 7){
                req.setMinDate(DateUtil.addDays(today, -7));
            }
            if(queryDay == 30){
                req.setMinDate(DateUtil.addDays(today, -30));
            }
        }
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<TCustPrize> custPrizes = custPrizeMapper.getCustPrizeList(req);
        PageInfo<TCustPrize> page = new PageInfo<>(custPrizes);
        return page;
    }

    @Override
    public PageInfo<CustPrizeRsp> pageDatas(CustPrizeReq req) throws Exception {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<CustPrizeRsp> custPrizes = custPrizeMapper.getDatas(req);
        PageInfo<CustPrizeRsp> page = new PageInfo<>(custPrizes);
        return page;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public PrizeRsp doLottery(String loginName) throws Exception {
        TCustomer customer = customerService.getInfoByLoginName(loginName);
        if(customer.getRouletteTotalTime() - customer.getRouletteUsedTime() <= 0){
            throw new BizException(CodeCons.NO_ROULETTE_TIME, "您已无抽奖次数 请您继续游戏获取更多抽奖次数");
        }
        //先扣除用户的抽奖次数
        int count = customerMapper.addUsedNum(loginName, customer.getRouletteUsedTime());
        if(count != 1){
            logger.error("doLottery-addUsedNum-error");
            throw new BizException(CodeCons.ERROR, "抽奖失败，请稍后再试");
        }
        TPrize prize = this.getPrize(loginName, customer.getVip(), false);
        this.addCustPrize(loginName, prize, "addCustPrize");
        PrizeRsp rsp = new PrizeRsp();
        if(prize == null){
            return null;
        }
        BeanUtils.copyProperties(prize, rsp);
        return rsp;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<PrizeRsp> doLotteryTen(String loginName) throws Exception {
        List<PrizeRsp> list = new ArrayList<>();
        TCustomer customer = customerService.getInfoByLoginName(loginName);
        if(customer.getRouletteTotalTime() - customer.getRouletteUsedTime() < 10){
            throw new BizException(CodeCons.NO_ROULETTE_TEN_TIME, "抽奖次数不足 请您继续游戏获取更多抽奖次数");
        }
        for(int i=0; i<10; i++){
            PrizeRsp rsp = this.doLottery(loginName);
            list.add(rsp);
        }
        return list;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<String> custPrizeRecord() throws Exception {
        String record = redisUtil.get("CUST_PRIZE_RECORD_STR");
        if(StringUtils.isNotBlank(record)){
            String[] records = record.split(";");
            return Arrays.asList(records);
        }
        boolean isFake = false;
        List<String> list = new ArrayList<>();
        List<TCustPrize> custPrizes = custPrizeMapper.getTwoCustPrize30s();
        if(CollectionUtils.isEmpty(custPrizes)){
            custPrizes = custPrizeMapper.getTwoCustPrize();
            if(CollectionUtils.isEmpty(custPrizes)){
                //造数据
                TCustPrize cp1 = getFakeCustPrize();
                if(cp1 != null){
                    custPrizes.add(cp1);
                }
                TCustPrize cp2 = getFakeCustPrize();
                if(cp2 != null){
                    custPrizes.add(cp2);
                }
                isFake = true;
            }
        }
        Date now = new Date();
        for(TCustPrize custPrize:custPrizes){
            String maskLoginName = BizUtil.maskString(custPrize.getLoginName());
            String prizeName = custPrize.getPrizeName();
            list.add("恭喜“"+ maskLoginName +"”抽中奖品“"+prizeName+"”");
            if(!isFake && custPrize.getRequestDate() == null){
                TCustPrize updateInfo = BizUtil.getUpdateInfo(new TCustPrize(), custPrize.getId(), "sys-api", now);
                updateInfo.setRequestDate(now);
                custPrizeMapper.updateById(updateInfo);
            }
        }
        if(isFake && !CollectionUtils.isEmpty(custPrizes)){
            String fakeStr = list.get(0)+";"+list.get(1);
            redisUtil.set("CUST_PRIZE_RECORD_STR", fakeStr, 29);
        }
        return list;
    }

    @Override
    public int addCustPrize(String loginName, TPrize prize) throws Exception {
        TCustPrize custPrize = BizUtil.getInsertInfo(new TCustPrize(), loginName, new Date());
        if(prize != null){
            custPrize.setPrizeId(prize.getId());
            custPrize.setPrizeName(prize.getPrizeName());
        }
        custPrize.setLoginName(loginName);
        custPrize.setBillNo(DateUtil.getTodayStr()+BizUtil.getStringRandom(4, 0));
        return custPrizeMapper.addCustPrize(custPrize);
    }

    private TCustPrize getFakeCustPrize(){
        PrizeReq req = new PrizeReq();
        req.setStatus(1);
        req.setRateNoZero(1);
        req.setNumNoZero(1);
        List<TPrize> prizeList = prizeMapper.getPrizeList(req);
        if(CollectionUtils.isEmpty(prizeList)){
            return null;
        }
        TCustPrize custPrize = new TCustPrize();
        String fakeLoginName = BizUtil.getStringRandom(4, 1).toLowerCase() + "0000" + BizUtil.getStringRandom(4, 0).toLowerCase();
        custPrize.setLoginName(fakeLoginName);
        TPrize prize = this.getPrize(fakeLoginName, null, true);
        if(prize == null){
            throw new BizException(CodeCons.NO_PRIZE, "没有可用的奖品");
        }
        custPrize.setPrizeName(prize.getPrizeName());
        return custPrize;
    }

    private TPrize getPrize(String loginName, Integer vip, boolean must){
        PrizeReq req = new PrizeReq();
        req.setStatus(1);
        req.setRateNoZero(1);
        req.setNumNoZero(1);
        List<TPrize> prizeList = prizeMapper.getPrizeList(req);
        if(CollectionUtils.isEmpty(prizeList)){
            logger.info("custPrize-getPrize-1, loginName={}", loginName);
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int maxNum = 0;
        for(TPrize prize:prizeList){
            BigDecimal rate = vip == null?prize.getRate():this.getVipRate(prize, vip);
            int num = rate.multiply(new BigDecimal("10000")).intValue();
            list.add(num);
            maxNum += num;
        }
        int randomBaseNum = maxNum>10000 || must?maxNum:10000;
        int randomNum = new Random().nextInt(randomBaseNum)+1;
        logger.info("{} - doLottery, maxNum={}, listNum={}, randomNum={}, prizeList={}", loginName, maxNum, list, randomNum, BizUtil.objToJsonArr(prizeList));
        if(randomNum > maxNum){
            logger.info("custPrize-getPrize-2, loginName={}", loginName);
            return null;
        }
        int currentNum = 0;
        for(int i=0; i<list.size(); i++){
            currentNum += list.get(i);
            if(currentNum >= randomNum){
                TPrize prize = prizeList.get(i);
                logger.info("custPrize-getPrize-3, loginName={}", loginName);
                return prize;
            }
        }
        logger.info("custPrize-getPrize-4, loginName={}", loginName);
        return null;
    }

    private void addCustPrize(String loginName, TPrize prize, String method) throws Exception{
        int cout = this.addCustPrize(loginName, prize);
        if(cout != 1){
            logger.error("doLottery-"+method+"-error");
            throw new BizException(CodeCons.ERROR, "抽奖失败，请稍后再试");
        }
        if(prize != null){
            TPrize updatePrize = BizUtil.getUpdateInfo(new TPrize(), prize.getId(), loginName, new Date());
            updatePrize.setUsedNum(prize.getUsedNum());
            updatePrize.setMaxNum(prize.getMaxNum());
            int count = prizeMapper.addUsedNum(updatePrize);
            if(count != 1){
                logger.error("addCustPrize-"+method+"-error");
                throw new BizException(CodeCons.ERROR, "抽奖失败，请稍后再试");
            }
        }
    }

    private BigDecimal getVipRate(TPrize prize, int vip){
        if(StringUtils.isBlank(prize.getVipRate())){
            return prize.getRate();
        }
        String[] vipRateArray = prize.getVipRate().split(";");
        for(String vipRateStr:vipRateArray){
            String[] vipRate = vipRateStr.split("_");
            if(vipRate[0].equals("VIP"+vip)){
                if(!"null".equals(vipRate[2])){
                    return new BigDecimal(vipRate[2]);
                }
            }
        }
        return prize.getRate();
    }

}
