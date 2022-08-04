package com.coin.service.constant;

import java.util.HashMap;
import java.util.Map;

public class BizCons {
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
