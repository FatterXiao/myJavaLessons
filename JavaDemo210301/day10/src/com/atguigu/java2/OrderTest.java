package com.atguigu.java2;

/**
 * @author shkstart
 * @create 15:47
 */
public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order();
        order.orderDefault = 1;
        order.orderProtected = 2;
        order.orderPublic = 3;

        order.methodDefault();
        order.methodProtected();
        order.methodPublic();

        //在同一个包内的其他类中，不能调用私有的结构
//        order.orderPrivate = 4;
//        order.methodPrivate();
    }
}
