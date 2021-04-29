package com.atguigu.java;

/**
 * @author shkstart
 * @create 16:21
 */
public class Person {
    String name;
    int age;
    int id = 1001;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public void eat(){
        System.out.println("人吃饭");
    }

    public void show(){
        System.out.println("name : " + name + ", age : " + age);
    }

    public void sleep(){
        System.out.println("人睡觉");
    }
}
