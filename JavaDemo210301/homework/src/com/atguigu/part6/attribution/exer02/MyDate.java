package com.atguigu.part6.attribution.exer02;

public class MyDate {
    int year;
    int month;
    int day;

    public MyDate(){}

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getInfo(){
        return "year = " + year + "; month = " + month + "; day = " + day;
    }
}
