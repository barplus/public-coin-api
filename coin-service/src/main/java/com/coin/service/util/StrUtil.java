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

    /**
     * 从地址栏中获取某个参数的值
     * @param url
     * @param paramName
     * @return
     */
    public static String getUrlParamVal(String url, String paramName){
        String indexStr = "?"+paramName+"=";
        int index = url.indexOf(indexStr);
        if(index == -1){
            index = url.indexOf("&"+paramName+"=");
        }
        if(index == -1){
            return "";
        }
        String result = "";
        int startIndex = index+indexStr.length();
        for(int i=startIndex; i<url.length(); i++){
            String charStr = url.substring(i, i+1);
            if("&".equals(charStr)){
                break;
            }
            result+=charStr;
        }
        return result;
    }

}
