package com.atguigu.part10.string_operation.exer05;

/*
    - 生成一个随机100内小数，转换为保留两位小数的字符串，不考虑四舍五入的问题
 */
public class Test05 {
    public static void main(String[] args) {
        double num = Math.random() * 100;
        System.out.println("随机数为：" +num);
        String str = num + "";
        str = str.substring(0,str.indexOf(".") + 3);
        System.out.println("截取小数点后两位后为：" + str);
    }
}
