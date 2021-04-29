package com.atguigu.exer1;

/**
 * @author shkstart
 * @create 14:03
 */
public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();

        c1.radius = 3.4;

//        c1.findArea(4.5);

        double area = c1.findArea();
        System.out.println(area);

    }
}
