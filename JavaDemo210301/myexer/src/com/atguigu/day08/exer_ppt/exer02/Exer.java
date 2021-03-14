package com.atguigu.day08.exer_ppt.exer02;

public class Exer {
    public static int[][] rectangle;


    /**
     * 打印一个 10 * 8 大小的矩阵
     */
    public static void printSpecialRetangle(){
        printRetangle(10,8);
    }
    /**
     * 打印一个“m * n”的“*”矩阵
     * @param m 长
     * @param n 宽
     */
    public static void printRetangle(int m, int n) {
        if (m <= 0 || n <= 0) {
            System.out.println("ERRO---m或n输入错误。");
            return;
        }

        rectangle = new int[m][n];

        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < rectangle[i].length; j++) {
                System.out.print("*");

            }
            System.out.println();

        }
    }
}
