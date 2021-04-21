package com.atguigu.part11.enumExers.exer01;

/*
    案例：
​	1、声明颜色枚举类：
​		7个常量对象：赤、橙、黄、绿、青、蓝、紫。
​	2、在测试类中，使用枚举类，获取绿色对象，并打印对象。
 */
public class EnumTest {

    public static void main(String[] args) {
        Colors color = Colors.BLUE;
        System.out.println(color);
    }
}
