package com.atguigu.java1;

/**
 * 测试数组中的常见异常
 *
 * @author shkstart
 * @create 11:51
 */
public class ArrayExceptionTest {

    public static void main(String[] args) {
        //1. 数据角标越界的异常：ArrayIndexOutOfBoundsException
        //角标的合法范围为：[0,数组长度-1]
        int[] arr = new int[10];
//        System.out.println(arr[10]);
        //System.out.println(arr[-1]);

        //2. 空指针异常：NullPointerException
        //情况1：
        int[] arr1 = new int[10];
        arr1 =  null;
        //System.out.println(arr1[0]);

        //情况2：
        int[][] arr2 = new int[10][];
        //System.out.println(arr2[0][0]);

        //情况3：后面面向对象内容中最常见的情况
        String[] arr3 = new String[]{"AA","BB"};
        arr3 = new String[4];
        System.out.println(arr3[0].toString());
    }

}
