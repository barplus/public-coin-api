package com.coin.service.constant;

import java.util.HashMap;
import java.util.Map;

public class BizCons {
    /**数据状态*/
    public static final Map<Integer, String> COMMON_DATA_STATUS = new HashMap<>();
    static{
        COMMON_DATA_STATUS.put(1, "有效");
        COMMON_DATA_STATUS.put(0, "失效");
    }
}
