package com.atguigu.java2;

import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;
import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 一、异常的体系结构：
 *   java.lang.Throwable
 *      |----java.lang.Error :错误 ,我们不编写针对性的代码进行处理。
 *             |----StackOverflowError \ OutOfMemoryError
 *      |----java.lang.Exception ： 异常，我们可以编写针对性的代码进行处理
 *          |---编译时异常：
 *              |---FileNotFoundException
 *              |---IOException
 *          |---运行时异常：
 *               |----InputMismatchException
 *               |----ArrayIndexOutOfBoundsException
 *               |----NullPointerException
 *               |----ClassCastException
 *               |----NumberFormatException
 *               |----ArithmeticException
 *
 *
 * 复习：java程序执行过程分为：过程一：编译：javac.exe  --->此过程中出现的异常，称为：编译时异常
 *                          过程二：运行：java.exe   --->此过程中出现的异常，称为：运行时异常
 *
 * 面试题：开发中，你都有遇到过哪些异常呢？
 *
 *
 *
 * @author shkstart
 * @create 14:26
 */
public class ExceptionTest {

    //InputMismatchException
    @Test
    public void test1(){
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你的年龄:");
        int age = scan.nextInt();
        System.out.println(age);
    }
    //ArrayIndexOutOfBoundsException
    @Test
    public void test2(){
        int[] arr = new int[10];
        System.out.println(arr[-1]);
    }

    //NullPointerException
    @Test
    public void test3(){
        //情况1：
//        int[] arr = null;
//        System.out.println(arr[0]);
        //情况2：
//        int[][] arr = new int[10][];
//        System.out.println(arr[0][0]);

        //情况3：
        String str = "hello";
        str = null;
        System.out.println(str.toString());//bank.getCustomer(0).getAccount().withdraw(500);


    }

    //ClassCastException
    @Test
    public void test4(){
        Object obj = new String("hello");
        Date date = (Date)obj;
    }

    //NumberFormatException:数字转换异常
    @Test
    public void test5(){
        String str = "123";
        str = "123a";
        int num = Integer.parseInt(str);
        System.out.println(num);
    }

    //ArithmeticException:算术异常
    @Test
    public void test6(){
        int m = 10;
        int n = 0;
        System.out.println(m / n);
    }

    @Test
    public void test7(){
//        File file = new File("hello.txt");
//        FileReader fr = new FileReader(file);
//        char[] buffer = new char[4];
//        int len;
//        while((len = fr.read(buffer)) != -1){
//            String str = new String(buffer,0,len);
//            System.out.print(str);
//        }
//        fr.close();
    }
}
