package com.atguigu.java2;

import com.sun.corba.se.impl.orb.ParserTable;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 测试finally的使用
 *
 * 1. 体会finally中存放一定会被执行的代码。
 *  说明：不管try、catch中是否存在未被处理的异常，不管是否存在return语句等。finally都要被执行的。
 *
 * 2. 什么样的代码需要声明在finally中呢？
 *     涉及到系统相关资源的位置。比如：IO流、网络Socket、数据库连接等
 *
 * @author shkstart
 * @create 16:21
 */
public class FinallyTest {

    @Test
    public void test1() {
        try {

            System.out.println( 10 / 0);

            File file = new File("hello.txt");
            FileReader fr = new FileReader(file);
            char[] buffer = new char[4];
            int len;
            while ((len = fr.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
            fr.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        System.out.println("程序执行结束");
    }

    @Test
    public void test2() {
        try {

            System.out.println(10 / 0);

            File file = new File("hello.txt");
            FileReader fr = new FileReader(file);
            char[] buffer = new char[4];
            int len;
            while ((len = fr.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
            fr.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            System.out.println("程序执行结束");

        }

    }
    @Test
    public void test3(){
        System.out.println(method1());
    }

    public int method1(){
        try{
            return 1;
        }catch(Exception e){
            e.printStackTrace();
        }finally{

            return 2;
        }

    }

    @Test
    public void test4() {
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            fr = new FileReader(file);
            char[] buffer = new char[4];
            int len;
            while ((len = fr.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }

        }catch(IOException e){
            e.printStackTrace();
        }finally{
            //流资源的关闭操作。此操作必须执行，否则会出现内存的泄漏
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("程序执行结束");
    }

}
