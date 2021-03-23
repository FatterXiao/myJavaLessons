package com.atguigu.java1;

import java.util.Vector;

/**
 * 1. 设计模式是在大量的实践中总结和理论化之后优选的代码结构、编程风格、以及解决问题的思考方式。
 *    设计模式免去我们自己再思考和摸索。就像是经典的棋谱，不同的棋局，我们用不同的棋谱。
 *
 *  经典的设计模式一共23种：
 * 创建型模式，共5种：工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式。
 * 结构型模式，共7种：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。
 * 行为型模式，共11种：策略模式、模板方法模式、观察者模式、迭代器模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。
 *
 * 2. 单例设计模式 : 保证在整个的软件系统中，对某个类只能存在一个对象实例
 *
 * 3. 如何实现单例？ 饿汉式 、懒汉式
 *
 * 4. 对比饿汉式 、懒汉式
 *    从内存使用的上，懒汉式优于饿汉式。因为延迟了对象的创建，节省内存空间
 *    从线程安全性的角度上，饿汉式优于懒汉式。饿汉式线程安全，而懒汉式线程不安全。
 *
 *
 * @author shkstart
 * @create 15:51
 */
public class SingletonTest {
    public static void main(String[] args) {
//        Bank b1 = new Bank();
//        Bank b2 = new Bank();

//        System.out.println(Bank.bank);

        System.out.println(Bank.getInstance());
    }
}

//饿汉式
class Bank{

    //1. 私有化类的构造器
    private Bank(){

    }

    //2. 内部创建一个当前类的对象
    private static Bank bank = new Bank();
    Vector vector = new Vector() ;


    //3. 提供get方法返回当前类的唯一实例
    public static Bank getInstance(){

        return bank;
    }
}
