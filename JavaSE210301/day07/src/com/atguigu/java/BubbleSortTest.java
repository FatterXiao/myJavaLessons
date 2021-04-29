package com.atguigu.java;

/**
 * 冒泡排序的实现
 *
 * @author shkstart
 * @create 11:18
 */
public class BubbleSortTest {
    public static void main(String[] args) {

        int[] arr = new int[]{3, 42, 2, 53, 65, 24, 65, 87, -95, -84, 0, 45};
        //排序前的遍历
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print("{");
            } else if (i == arr.length - 1) {
                System.out.print(arr[i] + "}");
                break;
            }
            System.out.print(arr[i] + ",");
        }

        //排序操作：冒泡排序
        for(int i = 0;i < arr.length - 1;i++){
            for(int j = 0;j < arr.length -1 - i;j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }


        System.out.println();
        //排序后的遍历
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print("{");
            } else if (i == arr.length - 1) {
                System.out.print(arr[i] + "}");
                break;
            }
            System.out.print(arr[i] + ",");
        }

    }
}
