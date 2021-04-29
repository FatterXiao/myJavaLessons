package com.atguigu.part7.super_keyword.exer03;

/*
    - 考核知识点：类初始化与实例初始化
 */

class HelloA{
    public HelloA(){
        System.out.println("HelloA");
    }
    {
        System.out.println("I'm A Class");
    }
    static{
        System.out.println("static A");
    }
}


public class HelloB extends HelloA{
    public HelloB(){
        System.out.println("HelloB");
    }
    {
        System.out.println("I'm B Class");
    }
    static{
        System.out.println("static B");
    }

    public static void main(String[] args) {
        new HelloB();
    }
}
