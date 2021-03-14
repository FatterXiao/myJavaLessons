package com.atguigu.java1;

/**
 * @author shkstart
 * @create 14:50
 */
public class OrderTest {
    public static void main(String[] args) {

        Order order = new Order();

        order.orderDefault = 1;
        order.orderPublic = 2;

        order.methodDefault();
        order.methodPublic();

        //在Order类外部，不能调用Order类中私有的结构
//        order.methodPrivate();
//        order.orderPrivate = 3;


    }
}

