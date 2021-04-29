package com.atguigu.java3;

import com.atguigu.java2.Order;

/**
 * @author shkstart
 * @create 15:51
 */
public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order();

        order.orderPublic = 1;
        order.methodPublic();

//        order.orderPrivate = 1;
//        order.orderDefault = 2;
//        order.orderProtected = 3;
//        order.methodProtected();
//        order.methodPrivate();
//        order.methodDefault();

    }
}
