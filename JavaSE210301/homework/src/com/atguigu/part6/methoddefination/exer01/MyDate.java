package com.atguigu.part6.methoddefination.exer01;

public class MyDate {
    int year;
    int month;
    int day;

    public  MyDate(){};

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }


    /**
     * 判断当前日期的是闰年吗
     * @return
     */
    boolean isLeap(){
        return ( year % 4 == 0 && year % 100 != 0 )|| (year%400==0) ;
    }

    /**
     *
     * @param year
     * @param month
     * @param day
     */
    public  void modifyInfo(int year,int month,int day){
        if(month > 12 || day > 31){
            return;
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * 打印信息
     */
    public void printDetail(){
        String msg = "year = " + year + "; month = " + month +";day = " + day + ";";
        System.out.println(msg);
    }

    /**
     *
     * @param years
     * @param months
     * @param days
     */
    public void puls(int years, int months, int days){

    }
}
