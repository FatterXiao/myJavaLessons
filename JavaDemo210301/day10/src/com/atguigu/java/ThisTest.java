package com.atguigu.java;

import com.sun.media.sound.SoftTuning;

/**
 * this 可以用来调用：属性、方法、构造器
 *
 * 1. this调用属性、方法
 *
 * 2. this调用构造器
 *  ① 格式: this(参数列表)
 *  ② this调用构造器的操作，只能声明在构造器中。表示调用当前类中的指定的重载的其他的构造器
 *  ③ this(参数列表) 只能声明在构造器的首行
 *  ④ 一个构造器中，最多只能声明一个"this(参数列表)"
 *  ⑤ 如果一个类中声明有n个构造器，则最多有 n - 1个构造器中使用了"this(参数列表)"
 *
 *
 * @author shkstart
 * @create 9:51
 */
public class ThisTest {
    public static void main(String[] args) {
        User u1 = new User("Tom");

        User u2 = new User("Jerry",12);
        u2.show();
    }
}

class User{
    private String name;
    private int age;

    public User() {
        //初始化User，需要做10件事情
//        this("tom");
        System.out.println("User()...");
    }

    public User(String name) {
        this();//调用User类中空参的构造器
        this.name = name;
    }

    public User(String name, int age) {
//        this();
        this(name);
        //this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
//        return this.name;
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show(){
        System.out.println("name = " + this.name + ", age = " + this.age);

        this.info();
    }
    public void info(){
        System.out.println("我是一个user");
    }
}
