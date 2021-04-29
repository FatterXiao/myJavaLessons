package com.atguigu.part5.everyday_review;

import java.util.Arrays;
import java.util.Random;

public class EverydayReview {


    public static int BinarySearch(int[] array, int key){
        if(array == null){
            return  -1;
        }
        if(array.length == 0){
            return -1;
        }
        // array 进行排序
        Arrays.sort(array);

        int head = 0;
        int tail = array.length - 1;
        while (head <= tail){
            int middle = (head + tail) >>> 1;
            int midValue = array[middle];

            if(midValue > key){
                middle--;
                tail = middle;
            }else if(midValue < key){
                middle++;
                head = middle;
            }else {
                return middle;
            }
        }
        return -2;
    }

    /*
        创建一个长度为6的int型数组，要求数组元素的值都在1-30之间，且是随机赋值。同时，要求元素的值各不相同
     */
    public  static void Test01(){
        Random random = new Random();
        int[] array = new int[6];

        for (int i = 0; i < array.length; i++) {
            if(i == 0){
                array[i] = random.nextInt(29) + 1;
                continue;
            }
            while (true){
                int temp = random.nextInt(29) + 1;
//                if(Arrays.binarySearch(array,temp) > 0){
//                    array[i] = temp;
//                    break;
//                }

                if(BinarySearch(array,temp) == -2){
                    array[i] = temp;
                    break;
                }
            }

        }

        System.out.println("打印数组：");
        System.out.println(Arrays.toString(array));

    }

    public static void main(String[] args) {
        Test01();
    }
}
