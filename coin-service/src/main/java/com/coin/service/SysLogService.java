package com.coin.service;

import com.coin.service.enums.LogTypeEnum;

public interface SysLogService {

    void addSysLog(String loginName, LogTypeEnum logType, String beforeVal, String afterVal, String logRemark, Integer SysType, String sysUser) throws Exception;

}
