package com.coin.service.impl;

import com.coin.entity.SysLog;
import com.coin.mapper.SysLogMapper;
import com.coin.service.SysLogService;
import com.coin.service.enums.LogTypeEnum;
import com.coin.service.util.BizUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Resource
    private SysLogMapper logMapper;

    @Override
    public void addSysLog(String loginName, LogTypeEnum logType, String beforeVal, String afterVal, String logRemark, Integer SysType) throws Exception {
        SysLog log = BizUtil.getInsertInfo(new SysLog(), loginName, new Date());
        log.setBeforeVal(beforeVal);
        log.setAfterVal(afterVal);
        log.setLogRemark(logRemark);
        log.setLogType(logType.name());
        log.setSysType(SysType);
        logMapper.addSysLog(log);
    }

}
