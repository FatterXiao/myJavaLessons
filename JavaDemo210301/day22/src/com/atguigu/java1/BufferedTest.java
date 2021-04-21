package com.atguigu.java1;

import com.sun.media.sound.SoftTuning;
import org.junit.Test;

import java.io.*;

/**
 * 缓冲流的使用
 *
 *
 * @author shkstart
 * @create 15:34
 */
public class BufferedTest {

    //应该使用try-catch-finally处理异常。
    @Test
    public void test1() throws IOException {
        //1. 创建流（包括创建文件的过程）
        FileInputStream fis = new FileInputStream(new File("pony.jpg"));
        FileOutputStream fos = new FileOutputStream(new File("pony_copy.jpg"));

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        //2. 读取数据并写出数据
        byte[] buffer = new byte[10];
        int len;//记录每次读入到buffer[]中的字节的个数
        while ((len = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        System.out.println("复制成功");

        //3. 关闭资源
        //如果涉及到节点流和处理流了，我们应该先关闭处理流，再关闭节点流。（先关外面的流，再关闭里面的流）
        //外部流的关闭操作，自动会在内部将其内部的流关闭。
        bos.close();
        bis.close();

        //省略了
//        fos.close();
//        fis.close();

    }

    //对比FileInputStream 、FileOutputStream 与 BufferedInputStream、BufferedOutputStream的执行效率
    public void copyWithFile(String src,String dest){
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            //1. 创建流（包括创建文件的过程）
            fis = new FileInputStream(new File(src));
            fos = new FileOutputStream(new File(dest));

            //2. 读取数据并写出数据
            byte[] buffer = new byte[1024];
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

    public void copyWithBuffered(String src,String dest){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1. 创建流（包括创建文件的过程）
            FileInputStream fis = new FileInputStream(new File(src));
            FileOutputStream fos = new FileOutputStream(new File(dest));

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //2. 读取数据并写出数据
            byte[] buffer = new byte[1024];
            int len;//记录每次读入到buffer[]中的字节的个数
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3. 关闭资源
            try {
                if(bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test2(){
        long start = System.currentTimeMillis();

        String src = "C:\\Users\\songhk\\Desktop\\考试\\王俊钿\\歌舞.flv";
        String dest = "C:\\Users\\songhk\\Desktop\\考试\\王俊钿\\歌舞2.flv";

//        copyWithFile(src,dest);
        copyWithBuffered(src,dest);

        long end = System.currentTimeMillis();

        System.out.println("花费的总时间为：" + (end - start));//4701 - 937
    }


    //测试BufferedReader和BufferedWriter的使用
    //应该使用try-catch-finally处理异常。
    @Test
    public void test3() throws IOException {

        //1. 造流
        BufferedReader br = new BufferedReader(new FileReader(new File("dbcp.txt")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

        //2. 读写过程
        //方式1：
//        char[] cbuf = new char[10];
//        int len;
//        while((len = br.read(cbuf)) != -1){
//            bw.write(cbuf,0,len);
//        }
        //方式2：
        String str;
        while((str = br.readLine()) != null){
            bw.write(str);
//            bw.write("\n");
            bw.newLine();
        }

        //3. 关闭操作
        bw.close();
        br.close();




    }



}
