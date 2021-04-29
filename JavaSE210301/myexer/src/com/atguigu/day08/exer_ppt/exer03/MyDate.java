package com.atguigu.day08.exer_ppt.exer03;

public class MyDate {
    int year;
    int month;
    int day;


    public  MyDate(){}

    /**
     *
     * @param year
     * @param month
     * @param day
     */
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public  void showInfo(){
        System.out.println(" year = " + year + ";\n month = " + month + ";\n day = " + day);
    }
}
