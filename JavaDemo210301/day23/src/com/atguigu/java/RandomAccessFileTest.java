package com.atguigu.java;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile:随机存取文件流
 *
 * 1. 既是一个输入流，又是一个输出流 （因为实现了DataInput、DataOutput接口）
 * 2. 作为输出流，要输出的文件不存在，则可以在执行过程中，自动创建此文件。
 * 3. 作为输出流，要输出的文件存在，则执行过程中会覆盖原有文件中的内容，而且默认从文件开始的位置覆盖.
 *    我们也可以从指定的位置开始写入数据。
 *
 *
 * @author shkstart
 * @create 10:25
 */
public class RandomAccessFileTest {

    @Test
    public void test1() throws Exception {
        //1.
        RandomAccessFile raf1 = new RandomAccessFile("yangm.png","r");
        RandomAccessFile raf2 = new RandomAccessFile("yangm1.png","rw");
        //2.
        byte[] buffer = new byte[1024];
        int len;
        while((len = raf1.read(buffer)) != -1){
            raf2.write(buffer,0,len);
        }
        //3.
        raf1.close();
        raf2.close();
    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("hello.txt","rw");

        raf.seek(5);
        raf.write("hello".getBytes());

        raf.close();
    }
}
