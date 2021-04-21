package com.atguigu.part15.io_option.exer04;

import org.junit.Test;

import java.io.*;

/**
 * @author Mr.Helianthus
 * @create 2021-03-31 8:58 PM
 */
public class Test04 {

    /*
        把今天的作业文件夹day22_homework下的《我想对你说.txt》字符编码为GBK，
        复制到当前项目的testIO文件夹下的《宋老师的话.txt》字符编码为UTF-8
     */
    @Test
    public void test() {
        String str = "E:\\S_SiliconValley_Tutorial\\01_Java基础\\尚硅谷_1_宋红康_210301Java基础\\5_复习笔记与练习\\章节课后练习\\第15章：File类与IO流\\我想对你说.txt";
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            FileInputStream fis = new FileInputStream(str);
            BufferedInputStream bis = new BufferedInputStream(fis);
            isr = new InputStreamReader(bis, "GBK");

            FileOutputStream fos = new FileOutputStream("testIO/宋老师的话.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            osw = new OutputStreamWriter(bos, "UTF-8");

            char[] chars = new char[1024];
            int len;
            while ((len = isr.read(chars)) != -1) {
                osw.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
