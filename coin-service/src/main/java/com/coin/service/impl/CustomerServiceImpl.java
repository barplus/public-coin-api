package com.coin.service.impl;

import com.coin.entity.Customer;
import com.coin.entity.Prize;
import com.coin.mapper.CustomerMapper;
import com.coin.mapper.PrizeMapper;
import com.coin.req.PrizeReq;
import com.coin.service.CustPrizeService;
import com.coin.service.CustomerService;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.BizUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private PrizeMapper prizeMapper;
    @Resource
    private CustPrizeService custPrizeService;

    @Override
    public Customer getInfoByLoginName(String loginName) throws Exception {
        return customerMapper.getInfoByLoginName(loginName);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Prize doLottery(String loginName) throws Exception {
        Customer customer = customerMapper.getInfoByLoginName(loginName);
        if(customer.getRouletteTotalTime() - customer.getRouletteUsedTime() <= 0){
            throw new BizException(CodeCons.NO_ROULETTE_TIME, "您已无抽奖次数 请您继续游戏获取更多抽奖次数");
        }
        //先扣除用户的抽奖次数
        int count = customerMapper.addUsedNum(loginName, customer.getRouletteUsedTime());
        if(count != 1){
            logger.error("doLottery-addUsedNum-error");
            throw new BizException(CodeCons.ERROR, "抽奖失败，请稍后再试");
        }
        PrizeReq req = new PrizeReq();
        req.setStatus(1);
        req.setRateNoZero(1);
        req.setNumNoZero(1);
        List<Prize> prizeList = prizeMapper.getPrizeList(req);
        if(CollectionUtils.isEmpty(prizeList)){
            this.addCustPrize(loginName, null, "addCustPrize-1");
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int maxNum = 0;
        for(Prize prize:prizeList){
            int num = prize.getRate().multiply(new BigDecimal("10000")).intValue();
            list.add(num);
            maxNum += num;
        }
        int randomBaseNum = maxNum>10000?maxNum:10000;
        int randomNum = new Random().nextInt(randomBaseNum)+1;
        logger.info("{} - doLottery, maxNum={}, randomNum={}, prizeList={}", loginName, maxNum, randomNum, BizUtil.objToJsonArr(prizeList));
        if(randomNum > maxNum){
            this.addCustPrize(loginName, null, "addCustPrize-2");
            return null;
        }
        int currentNum = 0;
        for(int i=0; i<list.size(); i++){
            currentNum += list.get(i);
            if(currentNum >= randomNum){
                Prize prize = prizeList.get(i);
                this.addCustPrize(loginName, prize, "addCustPrize-3");
                return prize;
            }
        }
        this.addCustPrize(loginName, null, "addCustPrize-3");
        return null;
    }

    @Override
    public void createCustomer(String loginName, String loginPass) throws Exception {
        Customer customer = BizUtil.getInsertInfo(new Customer(), "sys-api", new Date());
        customer.setLoginName(loginName);
        customer.setLoginPass(loginPass);
        customerMapper.createCustomer(customer);
    }

    private void addCustPrize(String loginName, Prize prize, String method) throws Exception{
        int cout = custPrizeService.addCustPrize(loginName, prize);
        if(cout != 1){
            logger.error("doLottery-"+method+"-error");
            throw new BizException(CodeCons.ERROR, "抽奖失败，请稍后再试");
        }
        if(prize != null){
            Prize updatePrize = BizUtil.getUpdateInfo(new Prize(), prize.getId(), loginName, new Date());
            updatePrize.setUsedNum(prize.getUsedNum());
            updatePrize.setMaxNum(prize.getMaxNum());
            int count = prizeMapper.addUsedNum(updatePrize);
            if(count != 1){
                logger.error("addCustPrize-"+method+"-error");
                throw new BizException(CodeCons.ERROR, "抽奖失败，请稍后再试");
            }
        }
    }

}
