package com.atguigu.java;

/**
 * @author shkstart
 * @create 8:55
 */
public class PersonTest {
    public static void main(String[] args) {
        //创建Person类的匿名子类的对象
        Person p1 = new Person(){

            @Override
            public void eat() {
                System.out.println("工人吃饭");
            }


        };

        p1.eat();
        System.out.println(p1.getClass());

        Order order = new Order(){
            public void method(){
                System.out.println("method1");
            }
        };

        order.method();
    }
}

abstract class Person {
    String name;
    int age;

    public abstract void eat();

    public void walk(){
        System.out.println("人：走路");
    }
}

abstract class Order{
    public void method(){
        System.out.println("method");
    }
}
