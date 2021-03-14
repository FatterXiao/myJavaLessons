package com.atguigu.day09.exer_ppt.exer01;

/*
1）定义一个Circle类，包含一个double型的radius属性代表圆的半径，一个findArea()方法返回圆的面积。
（2）定义一个类PassObject，在类中定义一个方法printAreas()，该方法的定义如下：public void printAreas(Circle c, int time)
在printAreas方法中打印输出1到time之间的每个整数半径值，以及对应的面积。例如，times为5，则输出半径1，2，3，4，5，以及对应的圆面积。

 */
public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        PassObject passObject = new PassObject();
        passObject.printAreas(circle,5);
    }
}
