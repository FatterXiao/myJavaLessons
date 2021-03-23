package com.atguigu.java2;

/**
 *
 *  Error: Java虚拟机无法解决的严重问题。如：JVM系统内部错误、资源耗尽等严重情况。比如：StackOverflowError和OOM。
 *
 *  一般不编写针对性的代码进行处理。
 *
 * @author shkstart
 * @create 14:16
 */
public class ErrorTest {
    public static void main(String[] args) {
        //StackOverflowError
//        main(args);
        //设置虚拟机参数：-Xms50m -Xmx50m
        //报错误：OutOfMemoryError：Java heap space
        byte[] arr = new byte[1024 * 1024 * 100];//100MB


    }
}
