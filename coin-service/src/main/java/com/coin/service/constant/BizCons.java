package com.coin.service.constant;

import java.util.HashMap;
import java.util.Map;

public class BizCons {
    public static final String SYS_OFFICE = "sys_office";
    public static final String SYS_API = "sys_api";
    /**频繁请求间隔毫秒-短*/
    public static final long SYS_REQ_INTERVAL_S = 150l;
    /**频繁请求间隔毫秒-中*/
    public static final long SYS_REQ_INTERVAL_M = 500l;
    /**频繁请求间隔毫秒-长*/
    public static final long SYS_REQ_INTERVAL_L = 6000l;
    /**session过期时间秒*/
    public static final long SESSION_OUT_TIME = 1800l;
    /**数据状态*/
    public static final Map<Integer, String> COMMON_DATA_STATUS = new HashMap<>();
    /**客户中奖记录查询的时间值*/
    public static final Map<Integer, String> CUST_PRIZE_QUERY_DAY = new HashMap<>();
    static{
        COMMON_DATA_STATUS.put(1, "有效");
        COMMON_DATA_STATUS.put(0, "失效");

        CUST_PRIZE_QUERY_DAY.put(0, "今日");
        CUST_PRIZE_QUERY_DAY.put(1, "昨日");
        CUST_PRIZE_QUERY_DAY.put(7, "近7日");
        CUST_PRIZE_QUERY_DAY.put(30, "近30日");
    }

}
