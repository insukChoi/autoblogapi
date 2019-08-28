package com.bengaluru.autoblogapi.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtil {
    /**
     * 파라미터 포맷 별로 오늘날짜 구하는 함수
     * @param format
     * @return today
     */
    public static String getToday(String format){
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(today);
    }

    /**
     * 몇일 전 날짜 구하는 함수
     * @param format
     * @return
     */
    public static String getBeforeDay(int beforeDay, String format){
        Calendar c1 = new GregorianCalendar();
        c1.add(Calendar.DATE, beforeDay); // 오늘날짜로부터 -1
        SimpleDateFormat sdf = new SimpleDateFormat(format); // 날짜 포맷
        return sdf.format(c1.getTime());
    }
}
