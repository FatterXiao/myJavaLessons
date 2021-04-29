package com.atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 自定义泛型类、泛型接口、泛型方法的使用
 *
 * 1. 在使用泛型类或泛型接口时，没有指明类或接口的泛型参数，则默认将此类型理解为Object类型。
 * 2. 在实例化泛型类时，指名了泛型的参数类型（比如：Integer)。则泛型类内部的属性、方法、构造器中凡是使用类的泛型的位置
 *   都替换为具体的泛型的参数类型（比如：Integer)。
 *
 * 3. 类的泛型参数在类实例化时，或子类继承泛型类时，指明类的泛型参数类型。
 *
 * 4. 泛型方法中的泛型参数是在方法调用时指名的。
 *
 * 5. 泛型类中，使用类的泛型的方法不能声明为static的。
 *    泛型方法，可以根据需要，声明为static的。
 *
 *
 * @author shkstart
 * @create 15:49
 */
public class GenericTest1 {

    @Test
    public void test1(){
        Order order = new Order();

        order.show("TTT");

        Order<Integer> order1 = new Order<>();
        order1.show(123);
//        order1.setT("Abc");
    }

    @Test
    public void test2(){
        SubOrder<String> sub = new SubOrder<>();
        sub.show("AA");


        SubOrder1 sub1 = new SubOrder1();
        sub.show("AA");
    }

    //泛型方法使用的举例
    @Test
    public void test3(){
        Order<Integer> order1 = new Order<>();
        String[] arr = new String[]{"AA","BB","CC","DD"};
        ArrayList<String> list = order1.copyFromArrayToList(arr);
        System.out.println(list);
    }
}
