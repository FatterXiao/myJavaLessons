package com.atguigu.part8.interface_exers.exer04;

import org.junit.Test;

public class CompareColor implements CompareAble {
    @Override
    public void compare(Apple apple1, Apple apple2) {
        System.out.println("挑选红的：");
        if("红色".equals(apple1.getColor())){
            System.out.println(apple1);
        }
        if("红色".equals(apple2.getColor())){
            System.out.println(apple2);
        }
    }
}
