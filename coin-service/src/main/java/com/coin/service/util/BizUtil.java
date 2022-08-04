package com.coin.service.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.coin.entity.Prize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class BizUtil {

    private static final Logger logger = LoggerFactory.getLogger(BizUtil.class);

    /**
     * 获取one相对于two的百分率，保留指定小数位
     * @param one
     * @param two
     * @param len
     * @return
     */
    public static BigDecimal getDecaimallRate(BigDecimal one, BigDecimal two, int len){
        if(one == null || two == null || two.compareTo(BigDecimal.ZERO) == 0){
            return BigDecimal.ZERO;
        }
        return one.divide(two, len+2, BigDecimal.ROUND_HALF_DOWN).multiply(BigDecimal.valueOf(100)).setScale(len, BigDecimal.ROUND_HALF_DOWN);
    }

    /**
     * 判断某个时间是否在时间区间内
     * @param start
     * @param end
     * @param date
     * @return
     */
    public static boolean isDateBetween(Date start, Date end, Date date){
        long min = start.getTime();
        long max = end.getTime();
        long val = date.getTime();
        if(val >= min && val <= max){
            return true;
        }
        return false;
    }

    /**
     * 获取指定长度随机数字
     * @param len
     * @return
     */
    public static int getRandomNum(int len){
        int min = 1;
        for(int i=1; i<len; i++){
            min = min * 10;
        }
        int max = min * 10 -1;
        Random random = new Random();
        return random.nextInt(max-min+1) + min;
    }

    /**
     * 一次性为对象注入多个属性
     * @param t
     * @param fieldAndVals
     * @param <T>
     * @return
     */
    public static <T> T getNewInfo(T t, Object ... fieldAndVals){
        try{
            Class clazz = t.getClass();
            for(int i=0; i<fieldAndVals.length; i++){
                String fieldName = fieldAndVals[i].toString();
                Object fieldVal = fieldAndVals[i+1];
                i++;
                if(fieldVal == null){
                    continue;
                }
                String methodName = "set" + fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
                Method method = clazz.getMethod(methodName, fieldVal.getClass());
                method.invoke(t, fieldVal);
            }
        }catch(Exception e){
            logger.error("BizUtil-getNewInfo-error", e);
            return null;
        }
        return t;
    }

    public static <T> T getInsertInfo(T t, String createUser, Date date){
        try{
            BizUtil.getUpdateInfo(t, null, createUser, date);
            BizUtil.getNewInfo(t, "createUser", createUser, "createDate", date);
        }catch(Exception e){
            logger.error("BizUtil-getInsertInfo-error", e);
            return null;
        }
        return t;
    }

    public static <T> T getUpdateInfo(T t, Integer id, String updateUser, Date date){
        try{
            BizUtil.getNewInfo(t, "id", id, "updateUser", updateUser, "updateDate", date);
        }catch(Exception e){
            logger.error("BizUtil-getUpdateInfo-error", e);
            return null;
        }
        return t;
    }

    /**
     * 对象转fastjson
     * @param obj
     * @return
     */
    public static JSONObject objToJson(Object obj){
        if(obj == null){
            return null;
        }
        String jsonStr = JSONObject.toJSONString(obj);
        JSONObject json = JSONObject.parseObject(jsonStr);
        return json;
    }

    public static JSONArray objToJsonArr(Object obj){
        if(obj == null){
            return null;
        }
        String jsonStr = JSONObject.toJSONString(obj);
        JSONArray array = JSONArray.parseArray(jsonStr);
        return array;
    }

    /**
     * 生成指定长度随机串，
     * @param length 长度
     * @param type 1-固定是字母 2-固定是数字 0-数字或字母
     * @return
     */
    public static String getStringRandom(int length, int type) {
        String val = "";
        Random random = new Random();
        // 参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if(type == 1){
                charOrNum = "char";
            }
            if(type == 2){
                charOrNum = "num";
            }
            // 输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /**
     * 对一个字符串进行遮罩，如果长度小于4返回原字符串
     * @param oldStr
     * @return
     */
    public static String maskString(String oldStr) {
        if(oldStr.length() < 4){
            return oldStr;
        }
        String aStr = oldStr.substring(0, 2);
        String bStr = oldStr.substring(oldStr.length()-2);
        return aStr + "****" + bStr;
    }

    public static void main(String[] args) {

    }

}
