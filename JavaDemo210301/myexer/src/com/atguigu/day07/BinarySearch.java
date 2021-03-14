package com.atguigu.day07;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Fatter
 * @description: 二分查找
 * @time: 2021年3月10日14:39:53
 */
public class BinarySearch {


    public static void main(String[] args) {
        Random random = new Random();

        int[] array = new int[12];
        // 1. 生成随机的int数组
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(99);
        }
        System.out.println("打印原始数组：" + Arrays.toString(array));

        // 2. 数组排序
        Arrays.sort(array);
        System.out.println("打印排序之后的数组：" + Arrays.toString(array));

        /*
            3. 二分法查找：
                - 索引 head tail
         */

        int target = 92;

        boolean isFlag = false;// 是否找到了目标数据，找到了为true，否则为false
        int head = 0;
        int tail = array.length - 1;

        while (head <= tail) {
            int middle = (head + tail) / 2;
            if (array[middle] == target) {
                isFlag = true;
                System.out.println("找到了目标数据，数据的索引为：" + middle);
                break;
            } else if (array[middle] > target) {
                tail = middle - 1;

            } else { // array[middle] < target
                head = middle + 1;
            }

        }

        if (!isFlag) {
            System.out.println("没有找到目标结果。");
        }

    }
}
