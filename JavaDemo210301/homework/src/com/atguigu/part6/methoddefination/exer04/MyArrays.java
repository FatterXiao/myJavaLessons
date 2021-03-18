package com.atguigu.part6.methoddefination.exer04;

import org.junit.Test;

import java.util.Arrays;

/**
 * 数组管理工具类
 */
public class MyArrays {
    /**
     *  可以为任意一维整型数组arr实现从小到大排序
     * @param arr
     */
    public void sort(int[] arr){

        int length = arr.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    /**
     * 可以在任意一维整型数组arr中查找value值的下标，如果不存在返回-1
     * @param arr
     * @param value
     * @return
     */
    public int indexOf(int[] arr, int value){
        if(arr == null) {
            return -1;
        }

        int length = arr.length;
        if(length == 0){
            return -1;
        }
        boolean isExist = false;
        for (int i = 0; i < length; i++) {
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }





    /**
     * 可以实现从任意一维数组arr中复制一个新数组返回，新数组的长度为len，从arr[0]开始复制
     * @param arr
     * @param len
     * @return
     */
    public int[] copy(int[] arr, int len){


        return  null;
    }

    // ======= Test  ===========
    @Test
    public void testSort(){
        int[] array = {10,13,22,1,87,3,8};
        System.out.println("排序前：" + Arrays.toString(array));

        sort(array);
        System.out.println("排序后：" + Arrays.toString(array));
    }

    @Test
    public void testIndexOf(){
        int[] array = {10,13,22,1,87,3,8};
        int index = indexOf(array,1);
        System.out.println(index);

    }
}
