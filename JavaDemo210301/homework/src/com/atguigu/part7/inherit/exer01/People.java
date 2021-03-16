package com.atguigu.part7.inherit.exer01;

public class People {
    private String name;

    public People() {
        System.out.print("1");
    }

    public People(String name) {
        System.out.print("2");
        this.name = name;
    }
}
