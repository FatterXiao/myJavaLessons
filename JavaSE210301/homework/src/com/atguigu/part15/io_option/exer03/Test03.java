package com.atguigu.part15.io_option.exer03;

import org.junit.Test;

import java.io.*;

/**
 * 1、把老师的word笔记文档《第14章 IO流.docx》，复制到当前项目的testIO文件夹下
 * 2、要求使用缓冲流和文件流一起实现
 *
 * @author Mr.Helianthus
 * @create 2021-03-31 8:34 PM
 */
public class Test03 {
    // 当前module下创建“testIO”文件夹
    @Test
    public void test01() {
        File file = new File("testIO");
        file.mkdir();
        System.out.println(file.getAbsoluteFile());
    }

    //IO流-实验练习.docx
    //把老师的word笔记文档《第14章 IO流.docx》，复制到当前项目的testIO文件夹下
    @Test
    public void test02() {
        String scrFilePath = "E:\\S_SiliconValley_Tutorial\\01_Java基础\\尚硅谷_1_宋红康_210301Java基础\\1-课件\\ppt版\\尚硅谷_宋红康_第15章_File类与IO流\\IO流-实验练习.docx";

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            FileInputStream fis = new FileInputStream(new File(scrFilePath));
            FileOutputStream fos = new FileOutputStream(new File("testIO/IO流-实验练习.docx"));

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
