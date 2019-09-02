package com.gxa.p2p.common.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 计算有效期的到期时间
 */
public class CalendarUtil {
    private Date date;
    public static Date getDate(Date date,Byte days){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,days);//把日期往后增加多少天.整数往后推,负数往前移动
        return calendar.getTime();
    }
}
