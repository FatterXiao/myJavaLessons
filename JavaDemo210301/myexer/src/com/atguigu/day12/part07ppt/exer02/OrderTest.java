package com.atguigu.day12.part07ppt.exer02;

import com.sun.org.apache.xpath.internal.operations.Or;

public class OrderTest {
    public static void main(String[] args) {
        Order order1 = new Order();
        order1.setOrderId(1001);
        order1.setOrderName("name1001");

        Order order2 = new Order();
        order2.setOrderId(1002);
        order2.setOrderName("name1002");

        Order order3 = new Order();
        order3.setOrderId(1001);
        order3.setOrderName("name1001");

        System.out.println("order1 和 order2相比：" + order1.equals(order2));
        System.out.println("order1 和 order3相比：" + order1.equals(order3));
    }
}
