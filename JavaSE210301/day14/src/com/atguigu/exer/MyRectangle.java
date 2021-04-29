package com.atguigu.exer;

/**
 * @author shkstart
 * @create 11:58
 */
public class MyRectangle extends GeometricObject {

    private double width;//宽
    private double height;//高

    public MyRectangle(double width, double height,String color, double weight) {
        super(color, weight);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double findArea(){
        return width * height;
    }

}
