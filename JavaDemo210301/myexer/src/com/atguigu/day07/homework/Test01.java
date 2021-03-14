package com.atguigu.day07.homework;

import java.util.Arrays;
import java.util.Random;

/*
    模拟大乐透号码：

    - 一组大乐透号码由10个1-99之间的数字组成
    - 打印大乐透号码信息
 */
public class Test01 {

    public static void main(String[] args) {
        //1、声明并创建数组
        int[] array = new int[10];

        //2、为元素赋值
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(99) + 1;
        }

        Arrays.sort(array);
        //3.打印输出
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}
