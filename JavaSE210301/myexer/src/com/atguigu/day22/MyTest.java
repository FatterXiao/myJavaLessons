package com.atguigu.day22;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * 复习demo代码
 * @author Mr.Helianthus
 * @create 2021-03-31 6:37 PM
 */
public class MyTest {
    /*
     * File类的使用
     *
     * 1. File类及后续的各种流都声明在java.io 包下
     * 2. File类的对象代表一个文件(.java，.mp3，.doc ，.txt，.avi )或文件目录
     * 3. File通常都是作为IO流的端点出现的。从代码上看，将File类的对象作为参数传递到IO流的构造器中。
     * 4. File类中涉及到文件或文件目录的新建、路径名、大小、删除等操作。具体读取文件内容的行为，File
     *   是无能为力的，必须使用流来操作。
     */
    @Test
    public void test(){
        //file: 文件 或者 目录
        File file = new File("E:\\GitHub\\myJavaLessons");
        String[] list = file.list();
        System.out.println(Arrays.toString(list));

        File[] files = file.listFiles();
        for(File temp : files){
            System.out.println(temp);
        }

        boolean exists = file.exists();// 磁盘中是否存在此文件或文件目录

    }

    // 遍历文件夹中所有的文件
    @Test
    public void test1(){
        File file = new File("E:\\GitHub\\myJavaLessons");
        printAllFiles(file);
    }

    public static void printAllFiles(File file){
        if(file.isFile()){
            System.out.println(file.getAbsoluteFile());
        }else {
            File[] files = file.listFiles();
            for(File f:files){
                printAllFiles(f);
            }
        }
    }


    public int countTotal(File file){
        int total = 0;
        if(file.isFile()){
            total += file.length();

        }else {
            File[] files = file.listFiles();
            for(File f:files){
                total +=countTotal(f);
            }
        }
        return total;
    }

    @Test
    public void test3() throws FileNotFoundException, UnsupportedEncodingException {
        File file = new File("E:\\GitHub\\myJavaLessons");
        System.out.println(file.getAbsoluteFile() + "  的大小为：" + countTotal(file));
//        InputStreamReader isr = new InputStreamReader(new FileInputStream("dbcp.txt"),"UTF-8");//当前InputStreamReader显式使用UTF-8字符集
    }
}
