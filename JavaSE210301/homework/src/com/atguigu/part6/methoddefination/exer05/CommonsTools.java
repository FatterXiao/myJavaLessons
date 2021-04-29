package com.atguigu.part6.methoddefination.exer05;

import org.junit.Test;

/**
 * 常识工具类
 */
public class CommonsTools {

    /**
     * 根据星期值，返回对应的英语单词
     *
     * @param week
     * @return
     */
    public String getWeekName(int week) {
        switch (week) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
        }
        return "";
    }


    /**
     * 根据月份值，返回对应的英语单词
     *
     * @param month
     * @return
     */
    public String getMonthName(int month) {

        String[] all = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        if (month >= 1 && month <= 12) {
            return all[month - 1];
        }
        return "";
    }


    /**
     * 返回某年某月的总天数
     *
     * @param year
     * @param month
     * @return
     */
    public int getTotalDaysOfMonth(int year, int month) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(isLeap(year)){
            days[1]++; //闰年2月29天
        }
        if(month >= 1 && month <= 12){
            return days[month-1];
        }

        return 0;
    }

    /**
     * 判别是否是闰年
     * @param year
     * @return
     */
    public boolean isLeap(int year) {
        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * 获取某年的总天数
     *
     * @param year
     * @return
     */
    public int getTotalDaysOfYear(int year) {
        if(isLeap(year)){
            return 366;
        }
        return 365;
    }


    /**
     * 判断某年是否是闰年
     *
     * @param year
     * @return
     */
    public boolean isLeapYear(int year) {
        return false;
    }

    @Test
    public void test(){
        CommonsTools tools = new CommonsTools();
        System.out.println("3月：" + tools.getMonthName(3));
        System.out.println("周三：" + tools.getWeekName(3));
        System.out.println("2019-2的总天数：" + tools.getTotalDaysOfMonth(2019, 2));
        System.out.println("2019年是否是闰年？" + tools.isLeapYear(2019) );
        System.out.println("2019年的总天数：" + tools.getTotalDaysOfYear(2019));
    }
}
