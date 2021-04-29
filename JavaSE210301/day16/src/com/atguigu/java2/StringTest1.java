package com.atguigu.java2;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @author shkstart
 * @create 16:07
 */
public class StringTest1 {
    /*
     * 基本数据类型、包装类 ---> String : ① + ② valueOf(Xxx xxx)
     *
     * String ----> 基本数据类型、包装类 : 调用包装类Xxx的parseXxx(String s)
     * */
    @Test
    public void test1() {
        String str1 = String.valueOf(123);


        int i = Integer.parseInt(str1);
        System.out.println(i);
    }

    /*
     * String 与char[]之间的转换
     *  String ---> char[] : 调用字符串类的toCharArray()
     *  char[] ----> String : 调用构造器
     * */
    @Test
    public void test2() {
        String str = "hello我";

        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "@");
        }


        char[] arr1 = new char[]{'a', 'b', 'c'};
        String str1 = new String(arr1);
        System.out.println(str1);//"abc"
    }

    /*
     * String 与byte[]之间的转换：
     *
     *String--->byte[] : 调用字符串类的getBytes()
     * byte[] ---> String:调用构造器
     * */
    @Test
    public void test3() {
        String str = "hello";

        byte[] bytes = str.getBytes();

        System.out.println(bytes.length);//5
        for (int i = 0; i < bytes.length; i++) {
            System.out.println((char) bytes[i]);
        }

        String str1 = new String(bytes);
        System.out.println(str1);

    }
    /*
    *  内存层面： char 相当于2个字节， byte就表示1个字节
    *
    * 存储层面：
    * ascii: 只能保存a-z,A-Z,0-9,常用的标点符号等，每个字符使用一个字节存储即可。
    *
    * utf-8:向下兼容ascii,即每个ascii中包含的字符仍然使用一个字节存储。
    *       每个汉字使用3个字节存储。
    *
    * gbk：向下兼容ascii,即每个ascii中包含的字符仍然使用一个字节存储。
    *      每个汉字使用2个字节存储。
    *
    *
    * */
    @Test
    public void test4() throws UnsupportedEncodingException {
        String str = "hello我";

        byte[] bytes = str.getBytes(); //默认的字符集，与IDEA设置的字符集相同
        System.out.println(bytes.length);//UTF-8 : 8

        for (int i = 0; i < bytes.length; i++) {
            System.out.println((char) bytes[i]);
        }

        byte[] bytes1 = str.getBytes("utf-8");
        System.out.println(bytes1.length);//8

        byte[] bytes2 = str.getBytes("gbk");
        System.out.println(bytes2.length);//7
    }
}
