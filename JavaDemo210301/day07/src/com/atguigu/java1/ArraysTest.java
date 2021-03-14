package com.atguigu.java1;

import java.util.Arrays;

/**
 *
 * 测试Arrays的使用
 *
 * Arrays:操作数组的工具类，在java.util包下提供
 *
 * @author shkstart
 * @create 11:40
 */
public class ArraysTest {
    public static void main(String[] args) {
        //1. boolean equals(int[] a,int[] b)
        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr2 = new int[]{1,2,4,3,5};
        System.out.println(Arrays.equals(arr1, arr2));

        //2. String toString(int[] a)
        System.out.println(arr1);//[I@1540e19d

        System.out.println(Arrays.toString(arr1));

        //3. void fill(int[] a,int val)
        Arrays.fill(arr1,10);
        System.out.println(Arrays.toString(arr1));

        //4. void sort(int[] a)
        int[] arr3 = new int[]{3, 42, 2, 53, 65, 24, 65, 87, -95, -84, 0, 45};
        Arrays.sort(arr3);
        System.out.println(Arrays.toString(arr3));

        //5. int binarySearch(int[] a,int key)
        System.out.println(Arrays.binarySearch(arr3, 53));

    }
}
