package com.atguigu.java1;

import org.junit.Test;

import java.io.*;

/**
 * 测试转换流的使用
 *
 * InputStreamReader: 将输入型的字节流转换为输入型的字符流
 * OutputStreamWriter: 将输出型的字符流转换为输出型的字节流
 *
 *  编码：字符、字符串 ---> 字节 、字节数组，对应着OutputStreamWriter
 *  解码：字节 、字节数组 ---> 字符、字符串 ，对应着InputStreamReader
 *
 *  要想保证解码之后字符没有乱码，必须保证解码使用的字符集与编码使用的字符集相同！
 *
 *
 * @author shkstart
 * @create 16:30
 */
public class InputStreamReaderTest {

    @Test
    public void test1() throws IOException {
        //1.
//        InputStreamReader isr = new InputStreamReader(new FileInputStream("dbcp.txt"));//当前InputStreamReader使用IDEA默认的字符集
        InputStreamReader isr = new InputStreamReader(new FileInputStream("dbcp.txt"),"UTF-8");//当前InputStreamReader显式使用UTF-8字符集
        //2.
        char[] cbuf = new char[10];
        int len;
        while((len = isr.read(cbuf)) != -1){
            String str = new String(cbuf,0,len);
            System.out.print(str);
        }
        //3.
        isr.close();
    }

    @Test
    public void test2() throws IOException {
        //1.
//        InputStreamReader isr = new InputStreamReader(new FileInputStream("dbcp_gbk.txt"),"UTF-8");//会出现乱码
        InputStreamReader isr = new InputStreamReader(new FileInputStream("dbcp_gbk.txt"),"GBK");//不会出现乱码
        //2.
        char[] cbuf = new char[10];
        int len;
        while((len = isr.read(cbuf)) != -1){
            String str = new String(cbuf,0,len);
            System.out.print(str);
        }
        //3.
        isr.close();
    }

    @Test
    public void test3() throws IOException {
        //1.
        InputStreamReader isr = new InputStreamReader(new FileInputStream("dbcp_gbk.txt"),"GBK");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("dbcp_utf8.txt"),"UTF-8");
        //2
        char[] cbuf = new char[10];
        int len;
        while((len = isr.read(cbuf)) != -1){
            osw.write(cbuf,0,len);
        }

        //3.
        osw.close();
        isr.close();

    }

}
