package com.atguigu.part10.string_operation.exer06;

import java.util.Arrays;

/*
    - 筛选字符串。

    - 定义数组，存入多个字符串。
    - 删除长度大于5的字符串，打印删除后的数组
 */
public class Test06 {
    public static void main(String[] args) {
        String[] arr = {"helloworld","java","song","atguigu","li","yan","Iloveyou"};

        System.out.println("原字符串：");
        System.out.println( Arrays.toString(arr));
        int index = 0;
        while(index < arr.length){
            if(arr[index].length()>5){
                System.arraycopy(arr, index+1, arr, index, arr.length-index-1);
                arr = Arrays.copyOf(arr, arr.length-1);
            }else{
                index++;
            }
        }
        System.out.println("删除后：");
        System.out.println(Arrays.toString(arr));
    }
}
