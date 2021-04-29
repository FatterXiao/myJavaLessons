package com.atguigu.day12.part07ppt.exer03;

public class MyDateTest {
    public static void main(String[] args) {
        MyDate myDate = new MyDate(2001,4,1);
        MyDate myDate1 = new MyDate(2001,4,1);
        MyDate myDate2 = new MyDate(2001,4,2);

        System.out.println(myDate.equals(myDate1));
        System.out.println(myDate.equals(myDate2));
    }
}
