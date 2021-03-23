package com.atguigu.exer;

/**
 * 定义一个Circle类，声明redius属性，提供getter和setter方法
 *
 * @author shkstart
 * @create 11:38
 */
public class Circle {
    private double radius;//半径

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }
}
