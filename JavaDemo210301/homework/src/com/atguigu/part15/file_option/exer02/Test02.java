package com.atguigu.part15.file_option.exer02;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 *
 * 1、检查D盘的testIO文件夹下是否存在文件a.txt，如果不存在则创建该文件;
 * 2、获取D盘的testIO文件夹下的a.txt文件的文件名，文件大小，文件的绝对路径和父路径等信息，并将信息输出在控制台
 * 3、判断File file = new File("d:\testIO");是否文件,是文件则输出：xxx是一个文件，是否文件夹,是文件夹则输出：xxx是一个文件夹
 * 4、删除D盘的testIO文件夹下的a.txt文件
 * 5、删除当前项目下的testIO文件夹下的1.txt文件，然后删除testIO文件夹
 *
 * @author Mr.Helianthus
 * @create 2021-03-31 8:01 PM
 */
public class Test02 {

//    1、检查D盘的testIO文件夹下是否存在文件a.txt，如果不存在则创建该文件;
    @Test
    public void test01(){
        File file = new File("d:/testIO/a.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    2、获取D盘的testIO文件夹下的a.txt文件的文件名，文件大小，文件的绝对路径和父路径等信息，并将信息输出在控制台
    @Test
    public void test02(){
        System.out.println("打印->获取D盘的testIO文件夹下的a.txt文件的文件名，文件大小，文件的绝对路径和父路径:");
        File file = new File("d:/testIO/a.txt");
        System.out.println("文件名: " + file.getName());
        System.out.println("文件大小： " + file.length());
        System.out.println("文件的绝对路径:" + file.getAbsolutePath());
//        System.out.println(file.getAbsoluteFile());
        System.out.println("文件的父路径：" + file.getParent());
    }

    // 3、判断File file = new File("d:\testIO");是否文件,是文件则输出：xxx是一个文件，是否文件夹,是文件夹则输出：xxx是一个文件夹
    @Test
    public void test03(){
        File file = new File("d:/testIO");
        if(file.isFile()){
            System.out.println(file.getAbsoluteFile().toString() + "是一个文件");
            return;
        }
        if(file.isDirectory()){
            System.out.println(file.getAbsoluteFile().toString() + "是一个文件夹");
            return;
        }
    }

    // 4、删除D盘的testIO文件夹下的a.txt文件
    @Test
    public void test04(){
        File file = new File("d:/testIO/a.txt");
        if(file.delete()){
            System.out.println("删除成功。");
            return;
        }
        System.out.println("删除失败。");
    }

    // 5、删除当前项目下的testIO文件夹下的1.txt文件，然后删除testIO文件夹
    @Test
    public void test05(){
        File file = new File("d:/testIO/1.txt");
        file.delete();

        File dir = new File("d:/testIO");
        dir.delete();
    }

}
