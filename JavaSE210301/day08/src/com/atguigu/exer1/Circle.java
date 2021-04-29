package com.atguigu.exer1;

/**
 *
 * 2.利用面向对象的编程方法，设计类Circle计算圆的面积。
 *
 * @author shkstart
 * @create 14:03
 */
public class Circle {
    //属性
    double radius;//半径
//    double area;//面积

    //方法
    //错误的：
//    public void findArea(double r){
//        System.out.println(3.14 * r * r);
//    }

    //正确的方式一：
//    public void findArea(){
//        System.out.println(3.14 * radius * radius);
//    }
    //正确的方式二：
    public double findArea(){
        return 3.14 * radius * radius;
    }
}
