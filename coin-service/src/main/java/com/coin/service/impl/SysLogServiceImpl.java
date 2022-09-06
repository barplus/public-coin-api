package com.coin.service.impl;

import com.coin.entity.TSysLog;
import com.coin.entity.TSysLogExample;
import com.coin.mapper.TSysLogMapper;
import com.coin.req.SysLogReq;
import com.coin.rsp.SysLogAgentRsp;
import com.coin.rsp.SysLogRsp;
import com.coin.service.SysLogService;
import com.coin.service.enums.LogTypeEnum;
import com.coin.service.util.BizUtil;
import com.coin.service.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Resource
    private TSysLogMapper tSysLogMapper;

    @Override
    public int addSysLog(String loginName, LogTypeEnum logType, String beforeVal, String changeVal, String afterVal, String logRemark, Integer SysType, String sysUser) throws Exception {
        TSysLog log = BizUtil.getInsertInfo(new TSysLog(), sysUser, new Date());
        log.setLoginName(loginName);
        log.setSysType(SysType);
        log.setLogType(logType.code);
        log.setBeforeVal(beforeVal);
        log.setChangeVal(changeVal);
        log.setAfterVal(afterVal);
        log.setLogRemark(logRemark);
        int count = tSysLogMapper.insertSelective(log);
        return count;
    }

    @Override
    public TSysLog getLastByLoginNameAndType(String loginName, LogTypeEnum logType) throws Exception {
        TSysLogExample example = new TSysLogExample();
        example.createCriteria().andLoginNameEqualTo(loginName).andLogTypeEqualTo(logType.code);
        example.setOrderByClause(" id desc");
        List<TSysLog> list = tSysLogMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    @Override
    public PageInfo<SysLogRsp> pageList(SysLogReq req) throws Exception {
        TSysLogExample example = new TSysLogExample();
        TSysLogExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(req.getQueryLoginName())){
            criteria.andLoginNameEqualTo(req.getQueryLoginName());
        }
        if(StringUtils.isNotBlank(req.getCreateUser())){
            criteria.andCreateUserEqualTo(req.getCreateUser());
        }
        if(req.getLogType() != null){
            criteria.andLogTypeEqualTo(req.getLogType());
        }
        if(StringUtils.isNotBlank(req.getLogTypes())){
            List<Integer> list = BizUtil.strToListInt(req.getLogTypes(), ",");
            criteria.andLogTypeIn(list);
        }
        if(req.getMinDate() != null){
            criteria.andCreateDateGreaterThanOrEqualTo(req.getMinDate());
        }
        if(req.getMaxDate() != null){
            criteria.andCreateDateLessThanOrEqualTo(req.getMaxDate());
        }
        if(StringUtils.isNotBlank(req.getOrderBy())){
            example.setOrderByClause(req.getOrderBy());
        } else {
            example.setOrderByClause(" id desc");
        }
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<TSysLog> list = tSysLogMapper.selectByExample(example);
        PageInfo<TSysLog> page = new PageInfo<>(list);
        List<SysLogRsp> rspList = list.stream().map(sysLog->this.convertRsp(sysLog)).collect(Collectors.toList());
        return PageUtil.pageInfo2PageRsp(page, rspList);
    }

    @Override
    public List<SysLogAgentRsp> getAgentLogList(SysLogReq req) throws Exception {
        List<SysLogRsp> list = this.pageList(req).getList();
        List<SysLogAgentRsp> result = list.stream().map(sysLog->this.convertAgnetRsp(sysLog)).collect(Collectors.toList());
        return result;
    }

    private SysLogRsp convertRsp(TSysLog sysLog){
        SysLogRsp rsp = new SysLogRsp();
        BeanUtils.copyProperties(sysLog, rsp);
        return rsp;
    }

    private SysLogAgentRsp convertAgnetRsp(SysLogRsp sysLog){
        SysLogAgentRsp rsp = new SysLogAgentRsp();
        BeanUtils.copyProperties(sysLog, rsp);
        return rsp;
    }

}
