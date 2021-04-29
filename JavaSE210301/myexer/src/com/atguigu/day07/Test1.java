package com.atguigu.day07;

import java.security.Key;
import java.util.Arrays;

/*
    - 练习：
        - 1. 实现2分查找
 */
public class Test1 {

    /**
     * @param array 已经排序过数组
     * @param key   查找的目标值
     * @return 返回 目标值在数组中的索引；如果没有，返回-1
     */
    public static int BinarySearchTest(int[] array, int key) {
        if (array == null) {
            return -1;
        }
        if (array.length == 0) {
            return -1;
        }

        int head = 0;
        int tail = array.length -1;
        //boolean
        while (head <= tail){ // "="很重要
            int middle = (head + tail)>>>1;
            int middleValue = array[middle];

            if(middleValue > key){
                middle--;
                tail = middle;
            }else if(middleValue < key){
                middle++;
                head = middle;
            }else {
                return middle;
            }
        }

        return -1;

    }

    /**
     *
     * @param lines 打印的行数
     */
    public  static  void Yanghui(int lines){
        int[][] yanghui = new int[lines][];

        for (int i = 0; i < yanghui.length; i++) {
            yanghui[i] = new int[i +1];
            yanghui[i][0] = yanghui[i][i] = 1;

            for (int j = 1; j < yanghui[i].length-1; j++) {
                yanghui[i][j] = yanghui[i-1][j] + yanghui[i-1][j-1];
            }
        }


        // 打印杨辉三角
        for (int i = 0; i < yanghui.length ; i++) {
            for (int j = 0; j < yanghui[i].length; j++) {
                System.out.print(yanghui[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {



        int[] arr = new int[]{3, 42, 2, 53, 65, 24, 65, 87, -95, -84, 0, 45};

        System.out.println(Arrays.toString(arr));
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println("打印排序后的数组：");
        System.out.println(Arrays.toString(arr));

    }


}
