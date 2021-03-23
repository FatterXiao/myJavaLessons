package com.atguigu.java1;

import java.sql.SQLOutput;

/**
 * 类的成员之五：内部类（innerclass）
 *
 * 1. 分类： 成员内部类: 静态的成员内部类、非静态的成员内部类
 *          局部内部类：方法内、构造器内、代码块内
 *
 * 2. 理解成员内部类：
 *          一方面，内部类作为类：
 *              > 内部可以定义属性、方法、构造器、代码块、内部类....
 *              > 可以被final修饰
 *              > 可以被abstract修饰
 *
 *          另一方面，内部类作为外部类的成员:
 *              > 可以被4种权限修饰结构来修饰
 *              > 可以被static修饰
 *              > 可以调用外部类的结构：属性、方法、。。。
 *
 * 3. 内部类的内容需要大家掌握的有如下三个点：
 *     ① 如何创建成员内部类的实例
 *     ② 如何在成员内部类中调用外部类的相关结构
 *     ③ 关于局部内部类的常见使用的掌握 ： 见 InnerClassTest1.java
 *
 * @author shkstart
 * @create 10:18
 */
public class InnerClassTest {

    public static void main(String[] args) {
        //1.创建静态的成员内部类的对象
        Person.Dog dog = new Person.Dog();
        dog.shout();
        //2. 创建非静态的成员内部类的对象
//        Person.Bird bird = new Person.Bird();
        Person p = new Person();
        Person.Bird bird = p.new Bird();
        bird.shout();

        System.out.println();
        bird.show("黄鹂");


    }
}

class Person{
    String name = "Tom";


    //静态的成员内部类
    public static class Dog{
        public void shout(){
            System.out.println("汪~汪~汪~");
        }

    }
    //非静态的成员内部类
    public class Bird{

        String name = "布谷鸟";

        public void shout(){
            System.out.println("喳~喳~喳~");
        }

        public void show(String name){
            System.out.println(name);//show()的形参
            System.out.println(this.name);//Bird类中的成员变量
            System.out.println(Person.this.name);//外部类的成员变量

            this.eat();
            Person.this.eat();
        }

        public void eat(){
            System.out.println("鸟找食物吃");
        }
    }

    public void method(){
        //局部内部类
        class A{

        }
    }
    public Person(){
        //局部内部类
        class B{

        }
    }

    {
        //局部内部类
        class C{

        }
    }

    public void eat(){
        int num = 1;
        System.out.println("人吃饭");

    }
}
