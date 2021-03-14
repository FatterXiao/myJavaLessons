package com.atguigu.java2;

import java.util.Scanner;

/**
 * 类的成员之三：构造器（或构造方法、Constructor）
 *
 * 1. 构造器的作用：
 *     ① 配合+new关键字在一起，用于创建类的对象
 *     ② 在创建对象的同时，初始化对象的相关属性
 *
 *
 * 2. 构造器使用说明：
 *    ① 如果我们在定义类时，没有显式的声明类的构造器，则系统会默认给我们提供一个空参的构造器
 *      当我们显式的定义了类的构造器时，系统就不再给我们提供默认的空参的构造器了
 *    ② 构造器的声明格式：
 *       权限修饰符 类名(形参列表){
 *           构造器的体
 *       }
 *    ③ 一个类中可以声明多个构造器，彼此之间构成重载
 * @author shkstart
 * @create 15:11
 */
public class PersonTest {
    public static void main(String[] args) {
//        Scanner scann = new Scanner(System.in);

        Person p1 = new Person();

//        p1.age = 1;
//        p1.name = "Tom";
//        p1.sleep();
//        p1.think("我从哪里来的？");

        Person p2 = new Person(10);
        System.out.println(p2.age);

        Person p3 = new Person("Jerry",20);
        System.out.println("name :" + p3.name + ", age :" + p3.age);
    }
}

class Person{
    //属性
    String name;
    int age;
    //构造器
    public Person(){
        System.out.println("我是Person类的空参的构造器");
    }

    public Person(int a){
        age = a;
    }

    public Person(String n,int a){
        name = n;
        age = a;
    }
    //方法
    public void eat(){
        System.out.println("人吃饭");
    }
    public void sleep(){
        System.out.println("人睡觉");
    }
    public void think(String message){
        System.out.println("人思考：" + message);
    }

}
