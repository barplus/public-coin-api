package com.coin.service.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    public static String base_dt_format = "yyyy-MM-dd HH:mm:ss";
    public static String terse_dt_format = "yyyyMMddHHmmss";
    public static String ms_dt_format = "yyyyMMddHHmmssSSS";

    public static String base_d_format = "yyyy-MM-dd";

    /**获取指定日期0点*/
    public static Date getNoTimeDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**加减指定天数后的日期:负值为减*/
    public static Date addDays(Date date, int days){
        return DateUtils.addDays(date, days);
    }

    /**
     * 获取两个日期的时间差
     * @param minDate 较小日期
     * @param maxDate 较大日期
     * @param type 1-天数 2-小时数 3-分钟 4-秒
     * @return
     */
    public static Long getInterval(Date minDate, Date maxDate, int type){
        long time1 = minDate.getTime();
        long time2 = maxDate.getTime();
        long time = time2 - time1;
        if(type == 1){
            return time/1000/60/60/24;
        }
        if(type == 2){
            return time/1000/60/60;
        }
        if(type == 3){
            return time/1000/60;
        }
        if(type == 3){
            return time/1000;
        }
        return null;
    }

    /**获取当天年月日时分秒的字符串*/
    public static String getTodayStr(){
        return DateUtil.getTodayStr(null);
    }

    /**获取当天年月日时分秒的字符串*/
    public static String getTodayStr(String fmtStr){
        if(StringUtils.isBlank(fmtStr)){
            fmtStr=DateUtil.terse_dt_format;
        }
        //获取当前时间
        LocalDateTime now = LocalDateTime.now();
        //创建日期时间对象格式化器，日期格式类似： 2020-02-23 22:18:38
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern(fmtStr);
        //将时间转化为对应格式的字符串
        String fomateDate=now.format(formatter).toString();
        return fomateDate;
    }

    /**
     * 将字符串转化为时间，默认是 yyyy-MM-dd HH:mm:ss
     * @param dataStr
     * @return
     */
    public static Date getDateByStr(String dataStr) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.base_dt_format);
        return sdf.parse(dataStr);
    }

    public static void main(String[] args) {
        Date date = DateUtil.getNoTimeDate(new Date());
        date = DateUtil.addDays(date, -1);
        String dateStr = DateFormatUtils.format(date, base_d_format);
        System.out.println(dateStr);
    }

}
