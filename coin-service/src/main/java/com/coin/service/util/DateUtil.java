package com.coin.service.util;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

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

    /**获取当天年月日时分秒的字符串*/
    public static String getTodayStr(){
        //获取当前时间
        LocalDateTime now = LocalDateTime.now();
        //创建日期时间对象格式化器，日期格式类似： 2020-02-23 22:18:38
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        //将时间转化为对应格式的字符串
        String fomateDate=now.format(formatter).toString();
        return fomateDate;
    }

    public static void main(String[] args) {
        Date date = DateUtil.getNoTimeDate(new Date());
        date = DateUtil.addDays(date, -1);
        String dateStr = DateFormatUtils.format(date, "yyyy-MM-dd");
        System.out.println(dateStr);
    }

}
