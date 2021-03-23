package com.atguigu.day15.exer01;

public class Printer implements USB {
    @Override
    public void start() {
        System.out.println("打印机开始工作。。。");
    }

    @Override
    public void stop() {
        System.out.println("打印机停止工作。。。");
    }
}
