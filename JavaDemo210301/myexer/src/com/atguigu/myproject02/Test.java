package com.atguigu.myproject02;

/**
 * @author Mr.Helianthus
 * @create 2021-04-06 11:47 PM
 */
public class Test {
    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char findValue = 'g';
        int findIndex = -1;

        int head = 0;
        int len = arr.length - 1;
        int tail = len;
        int mid;
        while (head <= tail) {
            mid = (head + tail) / 2;

            if (arr[mid] == findValue) {
                findIndex = mid;
                break;
            }

            if (mid == 0 || mid == len) {
                break;
            }

            if (arr[mid] > findValue) {
                tail = mid - 1;

            }

            if (arr[mid] < findValue) {
                head = mid + 1;
            }
        }

        if(findIndex == -1){
            System.out.println("没有找到");
        }else {
            System.out.println("找到了，位置为" + findIndex);
        }

        String str = "hello";
        str.replace("ll","pp");
    }
}
