package com.atguigu.exer;

/**
 * 几何图形类
 *
 * @author shkstart
 * @create 11:49
 */
public abstract class GeometricObject {

    protected String color;//颜色
    protected double weight;//权重

//    protected GeometricObject(){}

    protected GeometricObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public abstract double findArea();
}