package com.atguigu.java2;

import com.atguigu.java1.Order;

/**
 * @author shkstart
 * @create 14:54
 */
public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order();

        order.orderPublic = 2;

        order.methodPublic();

        //在Order类所在的包的外部，不能使用Order类中缺省、private权限修饰的结构
//        order.methodPrivate();
//        order.orderPrivate = 3;
//        order.methodDefault();
//        order.orderDefault = 1;
    }
}
