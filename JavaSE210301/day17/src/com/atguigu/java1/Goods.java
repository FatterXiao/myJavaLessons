package com.atguigu.java1;

import java.util.Comparator;

/**
 * @author shkstart
 * @create 14:45
 */
public class Goods implements Comparable {//商品

    private String name;//名称
    private double price;//价格

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Goods() {
    }

    /*
    如果两个对象相等，返回0
    如果当前对象大，则返回正数
    如果当前对象小，则返回负数


    需求：按照产品的价格从小到大排序  ---> 按照产品的价格从大到小排序
     */
    @Override
    public int compareTo(Object o) {
        System.out.println("111");
        if(this == o){
            return 0;
        }

        if(o instanceof Goods){
            Goods g1 = (Goods)o;

            return -Double.compare(this.price,g1.price);

        }
        throw new RuntimeException("输入的类型不匹配");
    }
}
