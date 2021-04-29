package com.atguigu.java2;

import java.util.Scanner;

/**
 * 设计类，其实就是设计类的内部结构。
 *
 * 1. 名词解释：
 *  属性 = 成员变量 = field = 域、字段
 *
 *  方法 = 成员方法 = method = 函数（function)
 *
 *  对象 = 实例
 *
 *  创建对象 = 类的实例化
 *
 *  2. 如何由类创建对象以及实现功能的调用？
 *  第1步：创建类，并设计类的内部成员。（属性、方法）
 *  第2步：创建类的对象 （或类的实例化）
 *  第3步：通过“对象.属性” 或 “对象.方法()” 的方式，完成功能的实现
 *
 * 3. 对象的内存解析
 *   3.1 对象名的变量保存在栈空间中
 *       对象实体保存在堆空间中，对象的属性也保存在堆空间中。
 *   3.2 如果创建类的多个对象，则每个对象拥有一套类的属性。如果修改其中一个对象的属性a的值，不会影响
 *     其它对象的属性a的值。
 *
 *
 *
 * @author shkstart
 * @create 15:54
 */
public class PersonTest {  //测试类

    public static void main(String[] args) { //程序的入口
        //创建Person类的对象
        //数据类型 变量名 = 变量值
        int num = 10;

        int[] arr = new int[10];
        Scanner scann = new Scanner(System.in);

        Person per = new Person();//创建了Person类的对象

        //通过对象调用属性：“对象.属性”
        //per.name = "江学振";
        System.out.println(per.name);

        per.age = 23;
        System.out.println(per.age);

        //通过对象调用方法：“对象.方法()”
        per.eat();
        per.sleep();
        per.think();

        Person per1 = new Person();
        per.age = 30;
        System.out.println(per1.age);//30

        Person per2 = per;//per 和 per2指向了堆空间中的同一个对象实体
        per2.age = 40;
        System.out.println(per2.age);//40
        System.out.println(per.age);//40
    }

}

class Person{ //类：人
    //设计类，就是设计类的内部成员
    //首当其中，就是设计类的属性、方法
    //成员一：属性
    String name;
    int age;

    //成员二：方法
    public void eat(){
        System.out.println("人吃饭");
    }
    public void sleep(){
        System.out.println("人睡觉");
    }

    public void think(){
        System.out.println("人思考");
    }
}
