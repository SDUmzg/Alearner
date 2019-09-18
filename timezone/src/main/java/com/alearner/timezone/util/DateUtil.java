package com.alearner.timezone.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author: mazongguang
 * @version: v1.0
 * @description: com.alearner.timezone.util
 * @date:2019/9/17
 */
public class DateUtil {
    /**
     * 获取某天的 00:00:00
     *
     * @param date 时间
     */
    public static Date getStartTimeInDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取某天的23:59:59
     *
     * calendar.set(Calendar.HOUR, 23);
     * calendar.set(Calendar.HOUR_OF_DAY, 23);
     * 注意甄别以上两种代码
     * @param date 时间
     */
    public static Date getEndTimeInDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

}
