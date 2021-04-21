package com.atguigu.java;

import org.junit.Test;

/**
 * StringBuffer\StringBuilder的测试
 *
 * @author shkstart
 * @create 16:51
 */
public class StringBufferBuilderTest {
    /*
     * 区分String\StringBuffer\StringBuilder
     * 都是字符串相关的类
     *
     * 一、三者的区别？（高频的面试题）
     * String:不可变的字符序列；底层使用char[]数组存储
     * StringBuffer:可变的字符序列；线程安全的，效率低；底层使用char[]数组存储
     * StringBuilder:可变的字符序列；线程不安全的，效率高；jdk5.0引入。底层使用char[]数组存储
     *
     * jdk9中：String、StringBuffer、StringBuilder三者底层都是使用byte[]存储。
     *
     * 二、剖析
     * String str = new String("abc"); // char[] value = new char[]{'a','b','c'}
     * String str1 = new String(); // char[] value = new char[0];
     *
     * StringBuffer sb = new StringBuffer("abc");//char[] value = new char["abc".length + 16]
     *   //value[0] = 'a',value[1] = 'b',value[2] = 'c';
     *
     * StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];
     *
     * sout(sb1.length());//0
     *
     * sb.append("m");//value[3] = 'm'
     * ...
     * 可能添加的数据较多，导致底层value数组长度不够，此时需要扩容。默认扩容为原来的2倍+2
     *
     * 三、开发的启示
     * ① 开发中如何频繁的对字符串进行拼接、删除、修改操作等，建议使用StringBuffer或StringBuilder
     * ② 如果操作字符串的线程不涉及到多线程问题，那么建议使用StringBuilder
     * ③ 如果项目中操作的字符串整体的长度基本确定，建议使用指定capacity参数的构造器，创建StringBuffer或StringBuilder
     *   比如：StringBuffer(int capacity)可以使用：StringBuffer s = new StringBuffer(30);
     *    对应的，底层创建的数组为：char[] value = new char[30]; 避免不必要的扩容。
     *
     *
     * */

    /*
    *   StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
        StringBuffer delete(int start,int end)：删除指定位置的内容
        StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
        StringBuffer insert(int offset, xxx)：在指定位置插入xxx
        StringBuffer reverse() ：把当前字符序列逆转
        public int indexOf(String str)
        public String substring(int start,int end)
        public int length()
        public char charAt(int n )
        public void setCharAt(int n ,char ch)
        *
      小结：StringBuffer 和  StringBuilder通用的方法：
      * 增：append(xxx)
      * 删：delete(int start,int end)
      * 改：setCharAt(int n ,char ch) / replace(int start, int end, String str)
      * 查：charAt(int n )
      * 插：insert(int offset, xxx)
      * 长度：length()
      *
    * */
    @Test
    public void test1() {
        StringBuffer s1 = new StringBuffer();
        System.out.println(s1.length());
        StringBuffer s2 = s1.append(1);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);

        s1.append('a').append(2).append(4);
        System.out.println(s1);
    }

    @Test
    public void test2() {
        StringBuffer s = new StringBuffer("hello");
        s.replace(2, 4, "www");
        System.out.println(s);
    }

    /**
     * 三者的效率从高到低排列：
     * StringBuilder > StringBuffer > String
     */
    @Test
    public void test3(){
        //初始设置
        long startTime = 0L;
        long endTime = 0L;


        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");

        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));


        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));


        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));

    }
}
