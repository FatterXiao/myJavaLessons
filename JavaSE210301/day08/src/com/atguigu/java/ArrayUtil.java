package com.atguigu.java;

/**
 * 自定义一个数组的工具类
 *
 * @author shkstart
 * @create 14:49
 */
public class ArrayUtil {

    //提供数值类型数组求最大值的方法
    public int getMax(int[] arr){
        int max = arr[0];
        for(int i = 1;i < arr.length;i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }

        return max;
    }

    public double getMax(double[] arr){
        //....
        return 0.0;
    }

    //提供数值类型数组求最小值的方法
    public int getMin(int[] arr){
        int min = arr[0];
        for(int i = 1;i < arr.length;i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }

    //提供数值类型数组求总和的方法
    public int getSum(int[] arr){
        int sum = 0;
        for(int i = 0;i <arr.length;i++){
            sum += arr[i];
        }
        return sum;
    }

    //提供数值类型数组求平均数的方法
    public int getAvg(int[] arr){

        return getSum(arr) / arr.length;
    }

    //数组的反转
    public void reverse(int[] arr){

    }

    //数组的复制
    public int[] copy(int[] arr){

        return null;
    }

    //数组的遍历
    public void printArray(int[] arr){

    }

    //数组的排序,默认从小到大
    public void sort(int[] arr){

    }
}
