package com.atguigu.day09.exer_ppt.exer03;

/*
    编写两个类，TriAngle和TriAngleTest，其中TriAngle类中声明私有的底边长base和高height，
    同时声明公共方法访问私有变量。此外，提供类必要的构造器。另一个类中使用这些公共方法，计算三角形的面积。

 */
public class TriAngle {
    /**
     * 三角形的底边长
     */
    private double base;
    /**
     * 三角形的高
     */
    private  double height;

    public TriAngle(){

    }

    public TriAngle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
