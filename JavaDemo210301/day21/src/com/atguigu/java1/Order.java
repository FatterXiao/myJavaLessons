package com.atguigu.java1;

import java.util.ArrayList;

/**
 * 自定义的泛型类
 *
 * @author shkstart
 * @create 15:45
 */
public class Order<T> {

    String orderName;
    int orderId;
    T orderT; //在属性中可以使用类的泛型参数

    //在方法中使用类的泛型参数
    public void setT(T t){
        this.orderT = t;
    }

    public T getT(){
        return orderT;
    }

    public void show(T t){
        System.out.println(t);
    }

    //构造中使用类的泛型参数
    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public Order(T t){
        this.orderT = t;
    }
    public Order(){}


    //定义一个泛型方法
    //将数组中的数据复制到ArrayList中，并返回
    public static<E>  ArrayList<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<E>();
        for(int i = 0;i < arr.length;i++){
            list.add(arr[i]);
        }

        return list;

    }
}
