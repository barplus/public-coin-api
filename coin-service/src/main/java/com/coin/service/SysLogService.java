package com.coin.service;

import com.coin.entity.TSysLog;
import com.coin.req.SysLogReq;
import com.coin.rsp.SysLogAgentRsp;
import com.coin.rsp.SysLogRsp;
import com.coin.service.enums.LogTypeEnum;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SysLogService {

    int addSysLog(String loginName, LogTypeEnum logType, String beforeVal, String changeVal, String afterVal, String logRemark, Integer SysType, String sysUser) throws Exception;
    TSysLog getLastByLoginNameAndType(String loginName, LogTypeEnum logType) throws Exception;
    PageInfo<SysLogRsp> pageList(SysLogReq req) throws Exception;
    List<SysLogAgentRsp> getAgentLogList(SysLogReq req) throws Exception;

}
