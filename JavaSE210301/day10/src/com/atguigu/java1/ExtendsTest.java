package com.atguigu.java1;

/**
 * 3W : what? why? how?
 *
 * 面向对象的特征二：继承性
 *
 * 1. 继承性的好处：
 * > 继承的出现减少了代码冗余，提高了代码的复用性。
 * > 继承的出现，更有利于功能的扩展。
 * > 继承的出现让类与类之间产生了关系，提供了多态的前提。
 *
 * 2. class A extends B {}
 *    A ：子类、SubClass
 *    B ：父类、SuperClass、超类、基类
 *
 * 3.
 *   3.1
 *  当子类继承父类以后，就获取了父类中声明的结构：属性、方法。即使父类中的结构声明的权限较小（比如：private),
 *  我们也认为子类通过继承的方式，获取了父类中权限较小的结构。只不过由于权限的影响，不能直接调用而已。
 *  3.2
 *  子类在继承父类之后，还可以定义自己特有的结构：属性、方法。也就是说，子类相较于父类，功能更强大、丰富
 *
 * 4. 说明
 *  ① java中的类的继承性只能是单继承的。但是，一个父类可以声明有多个子类
 *  ② 子类可以间接的继承于父类的父类。（直接父类、间接父类）
 *  ③ 子父类是一对相对的概念
 *  ④ 当没有显式的声明一个类A的父类时，默认此类A继承于java.lang.Object类
 *     > 任何一个Java类都继承于java.lang.Object类？yes!
 *
 *
 * @author shkstart
 * @create 14:15
 */
public class ExtendsTest {
    public static void main(String[] args) {
        Person p1 = new Person();
//        p1.name = "Tom";
        p1.setName("Tom");
        p1.eat();
        p1.think("晚上吃什么？");

        Student s1 = new Student();
//        s1.name = "Jerry";
        s1.setName("Jerry");
        s1.eat();
        s1.think("期末考试什么时候？");

        s1.info();

        s1.breath();

        System.out.println("############");
        Creature c = new Creature();
        c.breath();
//        c.study();//父类不能调用子类的结构
        c.toString();//c调用了父类中的方法
        System.out.println(c.getClass().getSuperclass());
    }
}
