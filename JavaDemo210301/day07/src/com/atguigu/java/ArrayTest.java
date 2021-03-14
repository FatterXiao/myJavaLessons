package com.atguigu.java;

/**
 * 数组的常见算法一：求数值型数组中元素的最大值、最小值、平均数、总和等
 *
 * @author shkstart
 * @create 9:48
 */
public class ArrayTest {
    public static void main(String[] args) {

        int[] arr = new int[]{3,42,2,53,65,24,65,87,-95,-84,0,45};

        //获取最大值
        int max = arr[0];
        for(int i = 1;i < arr.length;i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        System.out.println("最大值为：" + max);

        //获取最小值
        int min = arr[0];
        for(int i = 1;i < arr.length;i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }
        System.out.println("最小值为：" + min);

        //获取总和
        int sum = 0;
        for(int i = 0;i <arr.length;i++){
            sum += arr[i];
        }
        System.out.println("总和为：" + sum);

        //求平均数
        double avg = (double)sum / arr.length;
        System.out.println("平均数为：" + avg);
    }

}
