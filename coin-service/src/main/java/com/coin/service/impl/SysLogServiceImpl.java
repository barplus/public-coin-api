package com.coin.service.impl;

import com.coin.entity.TSysLog;
import com.coin.mapper.TSysLogMapper;
import com.coin.service.SysLogService;
import com.coin.service.enums.LogTypeEnum;
import com.coin.service.util.BizUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Resource
    private TSysLogMapper tSysLogMapper;

    @Override
    public void addSysLog(String loginName, LogTypeEnum logType, String beforeVal, String afterVal, String logRemark, Integer SysType, String sysUser) throws Exception {
        TSysLog log = BizUtil.getInsertInfo(new TSysLog(), sysUser, new Date());
        log.setLoginName(loginName);
        log.setSysType(SysType);
        log.setLogType(logType.code);
        log.setBeforeVal(beforeVal);
        log.setAfterVal(afterVal);
        log.setLogRemark(logRemark);
        tSysLogMapper.insertSelective(log);
    }

}
