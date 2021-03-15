package com.atguigu.part6.methoddefination.exer02;

/*
    声明一个三角形类Triangle，包含属性：a,b,c，表示三条边，包含几个方法：

    1、boolean  isRightTriangle()：判断是否是一个直角三角形

    2、boolean isIsoscelesTriangle()：判断是否是一个等腰三角形

    3、boolean isEquilateralTriangle()：判断是否是一个等边三角形

    4、double getArea()：根据三条边，用海伦公式求面积（S=√p(p-a)(p-b)(p-c)）公式里的p为半周长（周长的一半）

    5、double getLength()：求周长
 */
public class Triangle {

    private double a;
    private double b;
    private double c;

    /**
     *
     * @param a 三角形的第一条边的边长
     * @param b 三角形的第二条边的边长
     * @param c 三角形的第三条边的边长
     */
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
