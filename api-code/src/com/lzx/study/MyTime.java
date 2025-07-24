package com.lzx.study;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class MyTime {
    public static void main(String[] args) {
        // method1();
        // method2();
        // method3();
        // method4();
        // method5();
        method6();
    }

    public static void method1() {
        Date d1 = new Date();
        System.out.println(d1); // Wed Jul 23 10:59:41 CST 2025

        d1.setTime(0L);
        System.out.println(d1); // Thu Jan 01 08:00:00 CST 1970

        long time = d1.getTime();
        System.out.println(time); // 0
    }

    public static void method2() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));

        String sd1 = "2025-11-11 00:11:12";
        String sd2 = "2025-11-11 00:10:00";

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = sdf.parse(sd1);
            d2 = sdf.parse(sd2);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        if (d1.before(d2)) {
            System.out.println("购买有效");
        } else {
            System.out.println("购买无效");
        }
        System.out.println(sdf.format(d1)); // Fri Nov 11 00:01:12 CST 2025
    }

    public static void method3() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();

        System.out.println(sdf.format(cal.getTime()));

        // 设置年份
        cal.set(Calendar.YEAR, 1900);

        // 月份+1
        cal.add(Calendar.MONTH, 1);

        // 日期减一
        cal.add(Calendar.DAY_OF_MONTH, -1);

        // 获取年月日
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(year + "年" + month + "月" + day + "日");
    }

    public static void method4() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        LocalDateTime ldt1 = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("America/New_York"));
        System.out.println(ldt1);
        // 生成指定时间
        LocalDateTime ldt2 = LocalDateTime.of(2025, 11, 11, 0, 0, 0);
        // 格式化
        System.out.println(ldt2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss E a")));

        // 获取
        int year = ldt2.getYear();
        int month = ldt2.getMonthValue(); // 1-12
        int day = ldt2.getDayOfMonth();
        int week = ldt2.getDayOfWeek().getValue(); // 1-7
        System.out.println(year + "年" + month + "月" + day + "日" + week);

        // 修改
        LocalDateTime ldt3 = ldt2.withYear(2023);
        System.out.println(ldt3);

        // 增加
        LocalDateTime ldt4 = ldt2.plusYears(1);
        System.out.println(ldt4);

        // 减少
        LocalDateTime ldt5 = ldt2.minusYears(1);
        System.out.println(ldt5);

        // 比较
        System.out.println(ldt2.isBefore(ldt5));
        System.out.println(ldt2.isAfter(ldt5));
    }

    public static void method5() {
        // 两个时间的比较
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime birthday = LocalDateTime.of(1999, 2, 5, 20, 0, 0);
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(birthday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        System.out.println("相差的年份数:" + ChronoUnit.YEARS.between(birthday, now));
        System.out.println("相差的月份数:" + ChronoUnit.MONTHS.between(birthday, now));
        System.out.println("相差的天数:" + ChronoUnit.DAYS.between(birthday, now));
        System.out.println("相差的小时数:" + ChronoUnit.HOURS.between(birthday, now));
        System.out.println("相差的分钟数:" + ChronoUnit.MINUTES.between(birthday, now));
        System.out.println("相差的秒数:" + ChronoUnit.SECONDS.between(birthday, now));

    }

    public static void method6() {
        Integer i = 10086;
        // 将数字转换为字符串数组
        char[] chars = i.toString().toCharArray();
        for (char c : chars) {
            // 将字符转换为数字
            int n = c - '0';
            System.out.println(n);
        }
    }
}
