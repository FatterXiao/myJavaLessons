package com.atguigu.part15.file_option.exer01;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 1、使用绝对路径，在D盘下创建一个testIO文件夹，然后在testIO文件夹中创建一个1.txt文件
 * 2、使用相对路径，在当前项目下创建一个testIO文件夹，然后在testIO文件夹中创建一个1.txt文件
 * @author Mr.Helianthus
 * @create 2021-03-31 7:56 PM
 */
public class Test01 {
    @Test
    public void test1() throws IOException {
        File dir = new File("d:/testIO");
        dir.mkdir();

        File file = new File("d:/testIO/1.txt");
        file.createNewFile();
    }

    @Test
    public void test2() throws IOException {
        File dir = new File("testIO");
        dir.mkdir();

        File file = new File(dir,"1.txt");
        file.createNewFile();

    }
}
