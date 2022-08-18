package com.coin.service.impl;

import com.coin.entity.TCustomer;
import com.coin.entity.TCustomerExample;
import com.coin.mapper.TCustomerMapper;
import com.coin.mapper.ext.CustomerMapper;
import com.coin.req.CustomerReq;
import com.coin.rsp.CustomerRsp;
import com.coin.service.CustomerService;
import com.coin.service.SysLogService;
import com.coin.service.enums.LogTypeEnum;
import com.coin.service.exception.BizException;
import com.coin.service.util.BizUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
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
    private SysLogService sysLogService;
    @Resource
    private CustomerService customerService;

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
    public PageInfo<TCustomer> pageList(CustomerReq req) throws Exception {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<TCustomer> customers = customerMapper.getCustomerList(req);
        PageInfo<TCustomer> page = new PageInfo<>(customers);
        return page;
    }

    @Override
    public List<CustomerRsp> getList(CustomerReq req) throws Exception {
        TCustomerExample example = new TCustomerExample();
        TCustomerExample.Criteria criteria = example.createCriteria();
        List<TCustomer> list = tCustomerMapper.selectByExample(example);
        List<CustomerRsp> rspList = list.stream().map(customer->this.convertRsp(customer)).collect(Collectors.toList());
        return rspList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateTotalNum(CustomerReq req) throws Exception {
        if(req.getRouletteTotalTime().intValue() < 1){
            throw new BizException("9999", "增加的次数不能小于1");
        }
        TCustomer updateCustomer = BizUtil.getUpdateInfo(new TCustomer(), req.getId(), req.getLoginName(), new Date());
        updateCustomer.setRouletteTotalTime(req.getRouletteTotalTime());
        int count = customerMapper.updateTotalNum(updateCustomer);
        if(count != 1){
            throw new BizException("9999", "修改失败，用户信息已变化，请刷新后再修改");
        }
        TCustomer customer = tCustomerMapper.selectByPrimaryKey(req.getId());
        sysLogService.addSysLog(customer.getLoginName(), LogTypeEnum.ADD_LOTTERY_TIME, customer.getRouletteTotalTime()+"",
                customer.getRouletteTotalTime().intValue()+req.getRouletteTotalTime()+"", "", 1, req.getLoginName());
    }

    @Override
    public void updateWallet(CustomerReq req) throws Exception {
        TCustomer cust = customerService.getInfoByLoginName(req.getLoginName());
        TCustomer updateCustomer = BizUtil.getUpdateInfo(new TCustomer(), cust.getId(), req.getLoginName(), new Date());
        updateCustomer.setWallet(req.getWallet());
        customerMapper.updateWallet(updateCustomer);
    }

    @Override
    public void updateIsLogin(String loginName) throws Exception {
        customerMapper.updateIsLogin(loginName);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateLoginPass(TCustomer customer, int type, String sysUser) throws Exception {
        customerMapper.setLoginPass(customer);
        //0是清除密码 1是修改密码
        if(type == 0){
            TCustomer cust = tCustomerMapper.selectByPrimaryKey(customer.getId());
            sysLogService.addSysLog(cust.getLoginName(), LogTypeEnum.CLEAR_PASS, "",
                    "", "", 1, sysUser);
        }
    }

    @Override
    public void createCustomer(String loginName, String loginPass) throws Exception {
        TCustomer customer = BizUtil.getInsertInfo(new TCustomer(), "sys-api", new Date());
        customer.setLoginName(loginName);
        customer.setLoginPass(loginPass);
        customer.setIsLogin(1);
        customerMapper.createCustomer(customer);
    }

    private CustomerRsp convertRsp(TCustomer customer){
        CustomerRsp rsp = new CustomerRsp();
        BeanUtils.copyProperties(customer, rsp);
        return rsp;
    }

}
