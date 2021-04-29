package com.atguigu.part10.string_operation.exer01;

import java.util.Scanner;

/*
    - 反转键盘录入的字符串。
 */
public class Test01 {
    public static String myReverse(String string){
        if (string == null){
            System.out.println("输入string为null");
            return "";
        }
        int length = string.length();
        if(length == 0){
            return "";
        }
        char[] arr = string.toCharArray();
        for (int i = 0; i < (length>>1); i++) {
            char temp = arr[i];
            arr[i] = arr[length - i- 1];
            arr[length - i - 1] = temp;
        }

        return new String(arr);
    }

    public static String reverseString(String str){
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入内容：");
        String input = scanner.next();
        System.out.println("原始输入：" + input);
        System.out.println("myReverse反转之后：" + myReverse(input));
        System.out.println("reverseString反转之后：" + reverseString(input));
        scanner.close();

    }
}
