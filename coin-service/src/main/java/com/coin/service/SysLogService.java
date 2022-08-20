package com.coin.service;

import com.coin.req.SysLogReq;
import com.coin.rsp.SysLogRsp;
import com.coin.service.enums.LogTypeEnum;
import com.github.pagehelper.PageInfo;

public interface SysLogService {

    void addSysLog(String loginName, LogTypeEnum logType, String beforeVal, String afterVal, String logRemark, Integer SysType, String sysUser) throws Exception;

    PageInfo<SysLogRsp> pageList(SysLogReq req) throws Exception;

}
