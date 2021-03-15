package com.atguigu.exer2;

/**
 * @author shkstart
 * @create 15:32
 */
public class Circle {
    private double radius ;//半径

    public Circle(){
        System.out.println("Circle()....");
        radius = 1;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    //计算圆的面积
    public double findArea(){
        return Math.PI * radius * radius;
    }
}
