package com.web.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    /**
     * 获取系统的当前时间
     * @param pattern
     * @return
     */
    public static String getNowTime(String pattern){
        //"yyyy-MM-dd HH:mm:ss"
        //设置事件格式
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(new Date());
    }

    /**
     * 日期格式的转换
     * @param time
     * @param pattern
     * @return
     */
    public static String convertTime(Date time,String pattern){
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(time);
    }

    /**
     * 计算时间差
     * @param endDate
     * @param nowDate
     * @return
     */
    public static long getDatePoor(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day;
    }
}
