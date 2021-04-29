package com.atguigu.part10.string_operation.exer04;

import java.util.Scanner;

/*
    替换某字符串中的某字符串。

    - 键盘录入一个srcStr字符串，再录入一个delStr字符串。
    - 删除该字srcStr符串中的所有delStr字符串。
    - 并且统计delStr字符串在srcStr中出现的次数
 */
public class Test04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // java woaijava,i like jajavava i enjoy java
        System.out.print("请输入原字符串：");
        String src = input.next();

        System.out.print("请输入要删除的字符串：");
        String del = input.next();

        String result = src.replace(del,"");
        int count = (src.length() - result.length())/del.length();

        System.out.println(del+"共出现了：" + count + "次");
        System.out.println("删除" + del + "后字符串：" + result);

        input.close();
    }
}
