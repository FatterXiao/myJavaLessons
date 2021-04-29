package com.atguigu.part6.methodexpands.exer02;

import org.junit.Test;

/*
    - 知识点：方法的声明与调用、方法的重载
 */
public class GraphicTools {
    /**
     * 该方法打印5行5列*矩形
     */
    void printRectangle() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*" + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 该方法打印line行colomn列由sign组成的矩形
     *
     * @param line   行数
     * @param column 列数
     * @param sign
     */
    void printRectangle(int line, int column, String sign) {
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(sign + "\t");
            }
            System.out.println();
        }

    }

    /**
     * 根据底边和底边对应的高求三角形面积
     *
     * @param base   底边
     * @param height 高
     * @return
     */
    double getTriangleArea(double base, double height) {
        return base * height / 2;
    }

    /**
     * 根据三角形的三条边求三角形面积，如果a,b,c不能组成三角形，打印不能组成三角形，并返回0.0
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    double getTriangleArea(double a, double b, double c) {
        if (a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a) {
            double p = (a + b + c) / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }

        System.out.println(a + "," + b + "," + c + "不能构成三角形");
        return 0;
    }

    // ========== test  ==========
    @Test
    public void test() {
        GraphicTools tools = new GraphicTools();

        tools.printRectangle();
        System.out.println("--------------------------");

        tools.printRectangle(5, 10, "#");
        System.out.println("--------------------------");

        System.out.println("底边为3，高为4的三角形面积：" + tools.getTriangleArea(3, 4));
        System.out.println("边为3，4，5的三角形面积：" + tools.getTriangleArea(3, 4, 5));
    }
}
