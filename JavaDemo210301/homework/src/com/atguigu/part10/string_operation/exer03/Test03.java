package com.atguigu.part10.string_operation.exer03;

import java.util.Scanner;

/*
    字符串查找。

- 键盘录入一个大字符串，再录入一个小字符串。
- 统计小字符串在大字符串中出现的次数。
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入大字符串：");
        String big = input.next();

        System.out.print("请输入小字符串：");
        String small = input.next();

        int index;
        int count = 0;
        while ((index = big.indexOf(small) )!= -1){
            big = big.substring(index + small.length());
            count++;
        }
        System.out.println(small + "出现了" +count + "次");

        input.close();

    }
}
