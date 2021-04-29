package com.atguigu.day07;

import javax.swing.text.AbstractDocument;
import java.util.Arrays;
import java.util.Random;

/**
 * @description: 冒泡排序
 */
public class BubbleSortTest {

    /*
        - 整型数组实现冒泡排序
     */
    public static void bubbleSort(int[] array) {

        label:
        for (int i = 0; i < array.length - 1; i++) {
            // 如果一轮中 没有一次进行交换，则已经完成了排序； "isDone"为true时，已经完成了排序
            for (int j = 0; j < array.length - 1 - i; j++) {
                int temp = array[j];
                if (array[j] > array[j + 1]) {

                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        Random random = new Random();

        int[] array = new int[12];
        // 1. 生成随机的int数组
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(99);
        }
        System.out.println("打印原始数组：" + Arrays.toString(array));

        // 2. 数组排序
        bubbleSort(array);
        System.out.println("打印排序之后的数组：" + Arrays.toString(array));

    }
}


