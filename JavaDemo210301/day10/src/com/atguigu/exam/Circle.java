package com.atguigu.exam;

/**
 * 创建Circle类，提供私有的radius属性，提供相应的get和set方法，提供求圆面积的方法。
 * @author shkstart
 * @create 9:12
 */
public class Circle {
    private double radius;

    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return this.radius;
    }

    public double findArea(){
        return Math.PI * radius * radius;
//        return 3.14 * getRadius() * getRadius();
    }
}
