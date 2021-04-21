package com.atguigu.java;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * File类与IO流
 *
 * 1. 掌握File类的实例化的方式、熟悉常用的方法
 * 2. IO的概述：① 流的分类 ② 4个抽象基类 ③ 常见的流
 * 3. 文件流：FileReader\FileWriter ：处理文本文件
 *           FileInputStream\FileOutputStream ： 处理非文本文件
 * 4. 缓冲流：提高数据读写的效率
 *           BufferedReader \ BufferedWriter
 *           BufferedInputStream \ BufferedOutputStream
 * 5. 转换流：实现字节流与字符流之间的转化。
 *           InputStreamReader \ OutputStreamWriter
 *           编码的过程  vs 解码的过程
 *           如何保证不出现文本文件的乱码？ 解码使用的字符集要与编码使用的字符集相同！
 * 6.其它流：(了解)
 *   6.1        System.in:标准的输入流，从键盘输入
 *              System.out:标准的输出流，从屏幕输出
 *   6.2        打印流 PrintStream \ PrintWriter
 *   6.3        数据流：DataInputStream \ DataOutputStream
 *
 * 7. 对象流: 传输对象的流。 ObjectInputStream \ ObjectOutputStream
 *          对象的序列化机制！
 * 8. 随机存取文件流：RandomAccessFile
 *
 * 流处理数据的流程：
 * ① 创建流（包括File文件的创建）
 * ② 数据的读取或写出操作
 * ③ 关闭流资源
 *
 * 凡是涉及到资源关闭的操作，一定需要使用try-catch-finally处理异常。否则可能会出现内存泄漏。
 *
 * @author shkstart
 * @create 8:41
 */
public class OtherStreamTest {

    @Test
    public void test1(){
        Scanner scanner = new Scanner(System.in);

        int i = scanner.nextInt(); //阻塞式的方法
        System.out.println("hello");


        scanner.close();

    }

    @Test
    public void test2(){
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("D:\\io\\text.txt"));
            // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
            if (ps != null) {// 把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }
            for (int i = 0; i <= 255; i++) { // 输出ASCII字符
                System.out.print((char) i);
                if (i % 50 == 0) { // 每50个数据一行
                    System.out.println(); // 换行
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }

    }
    //使用DataOutputStream
    @Test
    public void test3() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("data.dat")));

        dos.writeInt(123);
        dos.writeInt(456);

        dos.writeBoolean(true);

        dos.writeUTF("武汉，你好！");

        dos.close();
    }

    //使用DataInputStream读取数据文件
    @Test
    public void test4() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(new File("data.dat")));

        int num = dis.readInt();
        int num1 = dis.readInt();
        boolean b = dis.readBoolean();
        String info = dis.readUTF();

        System.out.println(num);
        System.out.println(num1);
        System.out.println(b);
        System.out.println(info);

        dis.close();
    }
}
