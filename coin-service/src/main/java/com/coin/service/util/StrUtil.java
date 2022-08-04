package com.coin.service.util;

public class StrUtil {

    /**
     * 把对象转化为String，如果是空，返回空字符串
     * @param obj
     * @return
     */
    public static String getStr(Object obj){
        if(obj == null){
            return "";
        }
        return obj.toString();
    }

}
