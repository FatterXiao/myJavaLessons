package com.atguigu.part5.exer12;

import java.util.Scanner;

/*
    案例：从键盘输入一个英语单词，然后查找这个单词中是否存在'a'字母

    提示：把字符串转成字符数组，可以使用String类型的toCharArray()方法
 */
public class ExistLetterTest {
    public static void main(String[] args) {
        String target = "hello";
        char[] chars = target.toCharArray();

        Scanner input = new Scanner(System.in);
        System.out.print("请输入一串英文字符：");
        String recieve = input.next();
    }
}
