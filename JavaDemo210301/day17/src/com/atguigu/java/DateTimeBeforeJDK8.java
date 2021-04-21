package com.atguigu.java;

import org.junit.Test;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Java8之前的日期时间的api：
 *
 * 1. System 的方法：currentTimeMillis():获取当前时间的毫秒数 （时间戳）
 *     > 通常用来计算时间差。
 *
 * 2. java.util.Date
 *         |---java.sql.Date
 *
 * 3. Calendar:日历类
 *
 * 4. SimpleDateFormat
 *
 * @author shkstart
 * @create 10:21
 */
public class DateTimeBeforeJDK8 {
    @Test
    public void test1(){
        //java.util.Date:
        //1. 两个构造器
        Date date1 = new Date(); //获取系统的当前时间
        Date date2 = new Date(23452345324L);
        //2. 两个方法
        //toString():
        System.out.println(date1.toString());//Wed Mar 24 10:26:08 CST 2021
        //getTime():获取date对象对应的毫秒数
        System.out.println(date1.getTime());//1616552822058
        System.out.println(System.currentTimeMillis());

        //测试date2
        System.out.println(date2);
        System.out.println(date2.getTime());//23452345324


    }
    //测试java.sql.Date
    @Test
    public void test2(){
        java.sql.Date date1 = new java.sql.Date(3142134234L);

        System.out.println(date1.toString());//1970-02-06
        System.out.println(date1.getTime());//3142134234

        //练习：如何将一个util包下的Date实例转换为sql包下的Date实例？
        //错误：
//        Date date2 = new Date();
//        java.sql.Date date3 = (java.sql.Date)date2;
        //正确的：
        Date date2 = new Date();
        java.sql.Date date3 = new java.sql.Date(date2.getTime());

        //类比：
//        Object obj = new Object();
//        String s = (String)obj;


//        long l = 132213213L;
//        int i = (int)l;
//
//        int j = 12312;
//        long l1 = j;
//        int k = (int)l1;
    }

    //Calendar:日历类
    @Test
    public void test3(){
        //1.实例化
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        //2. 常用方法
        //get():获取指定的属性信息
        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);

        //set():设置指定的属性信息
        calendar.set(Calendar.DAY_OF_MONTH,12);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
        //add():
        calendar.add(Calendar.DAY_OF_MONTH,-5);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);

        //getTime(): calender得到Date的实例
        Date date = calendar.getTime();
        System.out.println(date);
        //setTime():使用指定的Date，重置calendar
        calendar.setTime(new Date());
        day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
    }

    //SimpleDateFormat:实现日期与字符串之间的相互转换
    @Test
    public void test4() throws ParseException {
        //1.实例化
        SimpleDateFormat sdf = new SimpleDateFormat();
        //String format(Date):格式化  日期 --->字符串
        String dateStr = sdf.format(new Date());
        System.out.println(dateStr);//21-3-24 上午11:13

        //Date parse(String):解析  字符串--->日期
        //注意，错误的字符串的写法会导致此方法报异常
        Date date1 = sdf.parse("21-3-24 上午11:13");
        System.out.println(date1);


        //练习："1979-11-15"  ---> java.util.Date ---> java.sql.Date
        //实例化
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr1 = sdf1.format(new Date());
        System.out.println(dateStr1);//2021-03-24

        Date date2 = sdf1.parse("1979-11-15");
        java.sql.Date date3 = new java.sql.Date(date2.getTime());
        System.out.println(date3);
    }
}
