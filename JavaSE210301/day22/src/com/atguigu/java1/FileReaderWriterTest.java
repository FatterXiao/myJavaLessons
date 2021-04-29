package com.atguigu.java1;

import org.junit.Test;

import java.io.*;

/**
 * 一、IO流的分类：
 * 按操作数据单位不同分为：字节流(8 bit)，字符流(16 bit)
 * 按数据流的流向不同分为：输入流，输出流
 * 按流的角色的不同分为：节点流，处理流
 *
 * 二、基本的IO流的框架
 * 抽象基类             节点流（文件流）                              缓冲流（处理流一种），提高数据的读写效率
 * InputStream          FileInputStream （read(byte[]）             BufferedInputStream（read(byte[]）
 * OutputStream         FileOutputStream （write(byte[],0,len）     BufferedOutputStream（write(byte[],0,len）
 * Reader               FileReader（read(char[]）                   BufferedReader  read(char[]） / readLine()
 * Writer               FileWriter（write(char[],0,len）            BufferedWriter （write(char[],0,len）
 *
 * @author shkstart
 * @create 11:28
 */
public class FileReaderWriterTest {
    /*
    使用单元测试方法的话，相对路径指的是当前module
    使用main的话，相对路径指的是当前工程
     */
    @Test
    public void test1() throws IOException {
        //1. 创建流（包含了创建文件）
        FileReader fr = new FileReader(new File("hello.txt"));

        //2. 具体的读取操作
        //read()：读取下一个字符，并返回。如果到达文件末尾，返回-1.
        int data = fr.read();
        while(data != -1){ //判断是否达到文件末尾
            System.out.print((char)data);
            data = fr.read();
        }

        //3. 关闭资源。一旦缺少关闭操作，就会出现内存泄漏
        fr.close();
    }

    //升级操作：本章中凡是出现流资源的关闭操作，都需要使用try-catch-finally来处理。不能使用throws.
    @Test
    public void test2(){
        FileReader fr = null;
        try{
            //1. 创建流（包含了创建文件）
            fr = new FileReader(new File("hello.txt"));

            //2. 具体的读取操作
            int data = fr.read();
            while(data != -1){ //判断是否达到文件末尾
                System.out.print((char)data);
                data = fr.read();
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{

            //3. 关闭资源。一旦缺少关闭操作，就会出现内存泄漏
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    //继续升级操作：每次读取数据使用一个数组。效率更高！
    @Test
    public void test3(){
        FileReader fr = null;
        try{
            //1. 创建流（包含了创建文件）
            fr = new FileReader(new File("hello.txt"));

            //2. 具体的读取操作
            char[] cbuffer = new char[5];
            int len;//记录每次读入到cbuffer数组中的字符的个数
            //read(char[] cbuf): 将数据读入到cbuf数组中，并返回读入到此数组中的个数。
            while((len = fr.read(cbuffer)) != -1){ //判断是否达到文件末尾

                //遍历cbuffer数组
                //错误的
//                for(int i = 0;i < cbuffer.length;i++){
//                    System.out.print(cbuffer[i]);
//                }
                //正确的：
//                for(int i = 0;i < len;i++){
//                    System.out.print(cbuffer[i]);
//                }
                //正确的：
                String str = new String(cbuffer,0,len);
                System.out.print(str);

//                Thread.sleep(3000);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{

            //3. 关闭资源。一旦缺少关闭操作，就会出现内存泄漏
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test4() {
        FileWriter fw = null;

        try {
            //1. 创建流（包含输出的文件的创建）
//            fw = new FileWriter(new File("abc.txt"));
            fw = new FileWriter(new File("abc.txt"),true);

            //2. 写出数据
            fw.write("I love you!\n");
            fw.write("you love him!".toCharArray());
            fw.write("\n我很痛苦！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3. 关闭资源
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    * 小结：
    *
    * 1. FileReader \FileWriter因为涉及资源的关闭操作，所以有异常的话，必须使用try-catch-finally处理
    * 2. 输入流在读取文件中的数据时，要求此文件必须存在。否则会报FileNotFoundException
    * 3. 输出流在写出数据到指定文件时，写出的文件可以不存在。
    *     3.1 如果写出的文件确实不存在，在执行的过程中，会自动的创建此文件。
    *     3.2 如果写出的文件存在，使用FileWriter(File) 或 FileWriter(File,false)构造器时，在执行的过程中，会覆盖原有文件
    *                           使用FileWriter(File,true)构造器时，在执行的过程中，在原有文件的末尾添加新的数据
    *
    * */

    //实现文本文件的复制
    @Test
    public void test5(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1. 创建流（包含文件的创建）
            fr = new FileReader(new File("hello.txt"));
            fw = new FileWriter(new File("hello_copy.txt"));

            //不能处理非文本文件
//            fr = new FileReader(new File("pony.jpg"));
//            fw = new FileWriter(new File("pony_copy.jpg"));


            //2. 数据的读取和写出
            char[] cbuf = new char[5];
            int len;//记录每次读入到cbuf[]中字符的个数
            while((len = fr.read(cbuf)) != -1){
                //操作1：
                fw.write(cbuf,0,len);
                //操作2：
//                String str = new String(cbuf,0,len).toUpperCase();
//                fw.write(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3. 关闭流
            //方式1：
//            try {
//                if(fw != null)
//                    fw.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }finally{
//
//                try {
//                    if(fr != null)
//                        fr.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            //方式2：
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
