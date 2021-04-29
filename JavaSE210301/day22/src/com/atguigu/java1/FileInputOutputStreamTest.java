package com.atguigu.java1;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试FileInputStream 和 FileOutputStream的使用
 *
 * 小结：
 * 我们使用字符流来处理文本文件(.txt，.java，.py，....)
 *
 * 使用字节流来处理非文本文件(.doc , .mp3, .avi,.jpg,...)
 *  补充：字节流也可以实现文本文件的复制。
 *
 * @author shkstart
 * @create 15:19
 */
public class FileInputOutputStreamTest {

    //实现图片的复制
    @Test
    public void test1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            //1. 创建流（包括创建文件的过程）
            fis = new FileInputStream(new File("pony.jpg"));
            fos = new FileOutputStream(new File("pony_copy.jpg"));

//            fis = new FileInputStream(new File("hello.txt"));
//            fos = new FileOutputStream(new File("hello_copy1.txt"));

            //2. 读取数据并写出数据
            byte[] buffer = new byte[10];
            int len;//记录每次读入到buffer[]中的字节的个数
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3. 关闭资源
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
