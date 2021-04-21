package com.atguigu.extral_exers.exer04;

import java.util.Arrays;

/**
 * @author Mr.Helianthus
 * @create 2021-04-08 12:24 AM
 */
public class Test04 {

    public static void main(String[] args) {
        int[] data = {8, 4, 1, 6, 7, 4, 9, 6, 4};
        sort(data);
        System.out.println(data);
        System.out.println(Arrays.toString(data));
    }

    static void sort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            //能被2整除的数都是偶数，反之为奇数
            if (data[i] % 2 == 0) {
                int j = i + 1;
                while (j < data.length) {
                    if (data[j] % 2 != 0) {
                        int temp = data[i];
                        data[i] = data[j];
                        data[j] = temp;
                        break;
                    }
                    j++;
                }
                //说明后面的全部均为偶数，没必须要往下循环。
                if (j == data.length) {
                    break;
                }
            }

        }
    }
}


