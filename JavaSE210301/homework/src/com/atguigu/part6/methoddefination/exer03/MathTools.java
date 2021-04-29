package com.atguigu.part6.methoddefination.exer03;

import sun.nio.cs.FastCharsetProvider;

/**
 * 数学计算工具类
 */
public class MathTools {

    /**
     * 求a+b
     *
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * 求a-b
     *
     * @param a
     * @param b
     * @return
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * 求a*b
     *
     * @param a
     * @param b
     * @return
     */
    public int mutiply(int a, int b) {
        return a * b;
    }

    /**
     * 求a/b
     *
     * @param a
     * @param b
     * @return
     */
    public int divide(int a, int b) {
        return a / b;
    }

    /**
     * 求a%b
     *
     * @param a
     * @param b
     * @return
     */
    public int remainder(int a, int b) {
        return a % b;
    }

    /**
     * 求a和b中的最大值
     * @param a
     * @param b
     * @return
     */
    public int max(int a, int b) {
        return  a >= b ? a : b;
    }


    /**
     * 求a和b中的最小值
     * @param a
     * @param b
     * @return
     */
    public int min(int a, int b){

        return  a <= b ? a : b;
    }


    /**
     * 判断a和b是否相等
     * @param a
     * @param b
     * @return
     */
    boolean equals(int a, int b)
    {
        return a == b;
    }


    /**
     * 判断a是否是偶数
     * @param a
     * @return
     */
    boolean isEven(int a)
    {
        if ((a&1) == 0){
            return true;
        }
        return false;
    }

    /**
     * 判断a是否是素数
     * @param a
     * @return
     */
    boolean isPrimeNumer(int a){
        return false;
     }


    /**
     * 返回d的四舍五入后的整数值
     * @param d
     * @return
     */
    int round(double d){
        return (int)(d + 0.5);
    }
}
