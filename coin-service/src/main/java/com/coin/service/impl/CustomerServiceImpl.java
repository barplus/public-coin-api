package com.coin.service.impl;

import com.coin.entity.*;
import com.coin.mapper.TCustPrizeMapper;
import com.coin.mapper.TCustomerMapper;
import com.coin.mapper.ext.CustomerMapper;
import com.coin.req.CustomerReq;
import com.coin.rsp.CustomerRsp;
import com.coin.service.CustPrizeService;
import com.coin.service.CustomerService;
import com.coin.service.DictService;
import com.coin.service.SysLogService;
import com.coin.service.constant.CodeCons;
import com.coin.service.enums.LogTypeEnum;
import com.coin.service.exception.BizException;
import com.coin.service.util.BizUtil;
import com.coin.service.util.DateUtil;
import com.coin.service.util.PageUtil;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private TCustomerMapper tCustomerMapper;
    @Resource
    private TCustPrizeMapper tCustPrizeMapper;
    @Resource
    private SysLogService sysLogService;
    @Resource
    private CustomerService customerService;
    @Resource
    private DictService dictService;
    @Resource
    private CustPrizeService custPrizeService;

    @Override
    public TCustomer getInfoByLoginName(String loginName) throws Exception {
        TCustomerExample example = new TCustomerExample();
        example.createCriteria().andLoginNameEqualTo(loginName);
        List<TCustomer> list = tCustomerMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    @Override
    public CustomerRsp getByLoginName(String loginName, boolean fill) throws Exception {
        TCustomer customer = this.getInfoByLoginName(loginName);
        CustomerRsp rsp = this.convertRsp(customer);
        if(fill){
            rsp.setRouletteSurplusTime(rsp.getRouletteTotalTime() - rsp.getRouletteUsedTime());
            rsp.setRouletteSignTime(0);
            TSysLog sysLog = sysLogService.getLastByLoginNameAndType(loginName, LogTypeEnum.EVERYDAY_SIGN);
            Date today = DateUtil.getNoTimeDate(new Date());
            if(sysLog != null && sysLog.getCreateDate().compareTo(today) > -1){
                rsp.setRouletteSignTime(1);
            }
        }
        return rsp;
    }

    @Override
    public PageInfo<CustomerRsp> pageList(CustomerReq req) throws Exception {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<TCustomer> customers = this.getList(req);
        PageInfo<TCustomer> page = new PageInfo<>(customers);
        List<CustomerRsp> rspList = customers.stream().map(customer->this.convertRsp(customer)).collect(Collectors.toList());
        return PageUtil.pageInfo2PageRsp(page, rspList);
    }

    @Override
    public List<TCustomer> getList(CustomerReq req) throws Exception {
        TCustomerExample example = new TCustomerExample();
        TCustomerExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(req.getQueryLoginName())){
            criteria.andLoginNameEqualTo(req.getQueryLoginName());
        }
        if(req.getVip() != null){
            criteria.andVipEqualTo(req.getVip());
        }
        if(StringUtils.isNotBlank(req.getVips())){
            criteria.andVipIn(BizUtil.strToListInt(req.getVips(), ","));
        }
        if(req.getIsLogin() != null){
            criteria.andIsLoginEqualTo(req.getIsLogin());
        }
        List<TCustomer> list = tCustomerMapper.selectByExample(example);
        return list;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateTotalNum(CustomerReq req) throws Exception {
        if(req.getRouletteTotalTime().intValue() == 0){
            throw new BizException("9999", "加减的次数不能是0");
        }
        TCustomer customer = tCustomerMapper.selectByPrimaryKey(req.getId());
        if(req.getRouletteTotalTime().intValue() + customer.getRouletteTotalTime() < customer.getRouletteUsedTime()){
            throw new BizException("9999", "用户剩余次数不足以扣减，请确认");
        }
        TCustomer updateCustomer = BizUtil.getUpdateInfo(new TCustomer(), req.getId(), req.getLoginName(), new Date());
        updateCustomer.setRouletteTotalTime(req.getRouletteTotalTime());
        int count = customerMapper.updateTotalNum(updateCustomer);
        if(count != 1){
            throw new BizException("9999", "修改失败，用户信息已变化，请刷新后再修改");
        }
        sysLogService.addSysLog(customer.getLoginName(), LogTypeEnum.ADD_LOTTERY_TIME, customer.getRouletteTotalTime()+"", req.getRouletteTotalTime()+"",
                customer.getRouletteTotalTime().intValue()+req.getRouletteTotalTime()+"", "手动修改抽奖次数", 1, req.getLoginName());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateWallet(CustomerReq req) throws Exception {
        TCustomer cust = customerService.getInfoByLoginName(req.getLoginName());
        TCustomer updateCustomer = BizUtil.getUpdateInfo(new TCustomer(), cust.getId(), req.getLoginName(), new Date());
        updateCustomer.setWallet(req.getWallet());
        tCustomerMapper.updateByPrimaryKeySelective(updateCustomer);
        if(req.getLotteryType() != null){
            if(req.getLotteryType() > 10){
                throw new BizException(CodeCons.ERROR, "抽奖方式错误");
            }
            List<TCustPrize> list = custPrizeService.getLastSomeRecord(req.getLotteryType(), req.getLoginName());
            TCustPrize updateInfo = BizUtil.getUpdateInfo(new TCustPrize(), 0, req.getLoginName(), new Date());
            for(TCustPrize cp:list){
                if(cp.getPrizeId() != null){
                    updateInfo.setId(cp.getId());
                    updateInfo.setWallet(req.getWallet());
                    tCustPrizeMapper.updateByPrimaryKeySelective(updateInfo);
                }
            }
        }
    }

    @Override
    public void updateIsLogin(String loginName) throws Exception {
        customerMapper.updateIsLogin(loginName);
    }

    @Override
    public void importCustomerList(List<CustomerRsp> rsps, String updateUser) throws Exception {
        logger.info("CustomerServiceImpl-importCustomerList-size={}", rsps.size());
        List<TCustomer> insertList = new ArrayList<>();
        Date now = new Date();
        for(int i=0; i<rsps.size(); i++){
            CustomerRsp rsp = rsps.get(i);
            if(StringUtils.isBlank(rsp.getLoginName()) || rsp.getVip() == null || rsp.getRouletteTotalTime() == null){
                throw new BizException(CodeCons.ERROR, "第"+(i+2)+"行数据不完整或格式错误，请检查");
            }
            if(rsp.getLoginName().length() < 4 || rsp.getLoginName().length() > 12){
                throw new BizException(CodeCons.ERROR, "第"+(i+2)+"行数据会员账号格式错误，请检查");
            }
            TCustomer customer = this.getInfoByLoginName(rsp.getLoginName());
            if(customer == null){
                customer = BizUtil.getInsertInfo(new TCustomer(), updateUser, now);
                customer.setLoginName(rsp.getLoginName());
                customer.setVip(rsp.getVip());
                customer.setRouletteTotalTime(rsp.getRouletteTotalTime());
                insertList.add(customer);
            }else{
                TCustomer updateCust = BizUtil.getUpdateInfo(new TCustomer(), customer.getId(), updateUser, now);
                boolean isChange = false;
                if(rsp.getVip() > customer.getVip()){
                    isChange = true;
                    updateCust.setVip(rsp.getVip());
                }
                if(rsp.getRouletteTotalTime() > customer.getRouletteTotalTime()){
                    isChange = true;
                    updateCust.setRouletteTotalTime(rsp.getRouletteTotalTime());
                }
                if(isChange){
                    this.updateImportInfo(updateCust, customer.getRouletteTotalTime(), customer.getLoginName());
                }
            }
        }
        if(insertList.size() > 0){
            List<List<TCustomer>> lists = BizUtil.splitList(insertList, 500);
            for(List<TCustomer> list:lists){
                customerMapper.createBatch(list);
            }
        }
        logger.info("CustomerServiceImpl-importCustomerList-time={}", System.currentTimeMillis() - now.getTime());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void everydaySign(CustomerReq req) throws Exception {
        TSysLog sysLog = sysLogService.getLastByLoginNameAndType(req.getLoginName(), LogTypeEnum.EVERYDAY_SIGN);
        Date today = DateUtil.getNoTimeDate(new Date());
        if(sysLog != null && sysLog.getCreateDate().compareTo(today) > -1){
            throw new BizException(CodeCons.ERROR, "请不要重复签到");
        }
        TCustomer customer = this.getInfoByLoginName(req.getLoginName());
        TCustomer updateCustomer = BizUtil.getUpdateInfo(new TCustomer(), req.getId(), req.getLoginName(), new Date());
        updateCustomer.setRouletteTotalTime(1);
        int count = customerMapper.updateTotalNum(updateCustomer);
        if(count != 1){
            throw new BizException("9999", "签到失败，请稍后再试");
        }
        sysLogService.addSysLog(req.getLoginName(), LogTypeEnum.EVERYDAY_SIGN, customer.getRouletteTotalTime()+"", "1",
                customer.getRouletteTotalTime()+1+"",  "会员签到增加抽奖次数", 2, req.getLoginName());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateLoginPass(TCustomer customer, int type, String sysUser) throws Exception {
        customerMapper.setLoginPass(customer);
        //0是清除密码 1是修改密码
        if(type == 0){
            TCustomer cust = tCustomerMapper.selectByPrimaryKey(customer.getId());
            sysLogService.addSysLog(cust.getLoginName(), LogTypeEnum.CLEAR_PASS, "", "",
                    "", "", 1, sysUser);
        }
    }

    @Override
    public void createCustomer(String loginName, String loginPass) throws Exception {
        TCustomer customer = BizUtil.getInsertInfo(new TCustomer(), "sys-api", new Date());
        customer.setLoginName(loginName);
        customer.setLoginPass(loginPass);
        customer.setIsLogin(1);
        tCustomerMapper.insertSelective(customer);
    }

    private void updateImportInfo(TCustomer updateCust, int rouletteTotalTime, String loginName) throws Exception{
        if(updateCust.getRouletteTotalTime() != null && updateCust.getRouletteTotalTime() != rouletteTotalTime){
            sysLogService.addSysLog(loginName, LogTypeEnum.ADD_LOTTERY_TIME, rouletteTotalTime+"", updateCust.getRouletteTotalTime()-rouletteTotalTime + "",
                    updateCust.getRouletteTotalTime()+"",  "批量导入修改次数", 1, updateCust.getUpdateUser());
        }
        tCustomerMapper.updateByPrimaryKeySelective(updateCust);
    }

    private CustomerRsp convertRsp(TCustomer customer){
        CustomerRsp rsp = new CustomerRsp();
        BeanUtils.copyProperties(customer, rsp);
        rsp.setRouletteSurplusTime(rsp.getRouletteTotalTime() - rsp.getRouletteUsedTime());
        if(StringUtils.isBlank(customer.getWallet())){
            try{
                TDict dict = dictService.getDefaultByType("WALLET");
                if(dict != null){
                    rsp.setWallet(dict.getDictCode());
                }
            }catch(Exception e){
                logger.error("customer-convertRsp-error", e);
                throw new BizException(CodeCons.ERROR, "获取钱包信息失败");
            }
        }
        return rsp;
    }

}
