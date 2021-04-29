package com.atguigu.java2;

/**
 * 类的成员之四：代码块(或初始化块）
 *
 * 1. 代码块的作用：用来初始化类或对象的信息
 *
 * 2. 代码块的分类：静态代码块 vs  非静态代码块
 *
 * 3.1 静态代码块：
 *    > 主要用来初始化类的信息
 *    > 内部可以有输出语句
 *    > 内部可以调用当前类中静态的属性、静态的方法，不能调用非静态的属性、非静态的方法
 *    > 随着类的加载而执行。因为类通常只加载一次，所以静态代码块也就只执行一次
 *    > 静态代码块的执行一定早于非静态代码块
 *    > 如果一个类中声明了多个静态代码块，则按照声明的先后顺序执行
 *
 * 3.2 非静态代码块：
 *    > 主要用来初始化对象的信息
 *    > 内部可以有输出语句
 *    > 内部可以调用当前类中静态的属性、静态的方法，也可以调用非静态的属性、非静态的方法
 *    > 随着对象的创建而执行。每创建一个类的对象，就会调用一次非静态代码块
 *    > 如果一个类中声明了多个非静态代码块，则按照声明的先后顺序执行
 *
 *
 *
 * @author shkstart
 * @create 16:28
 */
public class BlockTest {
    public static void main(String[] args) {

        System.out.println(Person.info);
        System.out.println();

        Person p1 = new Person();
        System.out.println();
        Person p2 = new Person();
    }
}

class Person{
    String name;
    static String info = "我是一个人";
    //静态代码块
    static{
        System.out.println("静态代码块2");
    }
    static{
        System.out.println("静态代码块1");
//        System.out.println(info);
//        System.out.println(name);//编译失败
    }


    //非静态代码块
    {
        System.out.println("非静态代码块2");
    }
    {
        System.out.println("非静态代码块1");

//        System.out.println(info);
//        System.out.println(name);

        name = "undefined";
    }

}
