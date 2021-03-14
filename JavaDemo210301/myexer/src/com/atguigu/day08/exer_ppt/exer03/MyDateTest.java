package com.atguigu.day08.exer_ppt.exer03;

public class MyDateTest {
    public static void main(String[] args) {
        MyDate myDate = new MyDate(1993,3,28);
        myDate.showInfo();

        System.out.println();
        MyDate myDate1 = new MyDate(1992,3,2);
        myDate1.showInfo();
    }
}
