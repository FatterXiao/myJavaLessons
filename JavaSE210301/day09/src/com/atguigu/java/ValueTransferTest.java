package com.atguigu.java;

/**
 * 1. 复习：
 * 针对基本数据类型的变量：存储就是变量的值
 * 针对于引用数据类型的变量：存储的数据：① null ② 对象或数组实体在堆空间中存储位置的首地址值。
 *
 * 2.总结：值传递机制
 * 基本数据类型变量的赋值操作：就是将基本数据类型变量存储的变量值赋值过去。
 * 引用数据类型变量的赋值操作：就是将引用数据类型变量存储的null值或者对象的首地址值赋值过去。
 *
 *
 *
 * @author shkstart
 * @create 10:02
 */
public class ValueTransferTest {
    public static void main(String[] args) {
        //针对基本数据类型的变量：存储就是变量的值
        int m = 10;
        int n = m;

        System.out.println("n = " + n);//10

        m = 20;
        System.out.println("n = " + n);//10

        System.out.println("################");
        //针对于引用数据类型的变量：存储的数据：① null ② 对象或数组实体在堆空间中存储位置的首地址值。
        Order o1 = new Order();
        o1.orderId = 1001;
//        o1 = null;
        Order o2 = o1;
        System.out.println(o2.orderId);//1001

        o1.orderId = 1002;
        System.out.println(o2.orderId);//1002


    }
}

class Order{
    int orderId;
}
