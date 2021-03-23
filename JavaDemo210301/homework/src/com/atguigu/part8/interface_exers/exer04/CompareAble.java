package com.atguigu.part8.interface_exers.exer04;

public interface CompareAble {
    default void compare(Apple apple1,Apple apple2){
        System.out.println("默认挑选大的：");
        if(Double.compare(apple1.getSize(),apple2.getSize()) > 0){
            System.out.println(apple1);
        }else {
            System.out.println(apple2);
        }
    }
}
