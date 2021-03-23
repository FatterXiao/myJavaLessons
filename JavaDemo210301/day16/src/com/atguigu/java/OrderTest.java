package com.atguigu.java;

/**
 * @author shkstart
 * @create 9:08
 */
public class OrderTest {
    public static void main(String[] args) {
        Order o1 = new Order();
        System.out.println(o1.getClass());

        Order o2 = new Order(){};
        System.out.println(o2.getClass());


    }
}
class Order{
    public void method1(){
        System.out.println("method()....");
    }
}