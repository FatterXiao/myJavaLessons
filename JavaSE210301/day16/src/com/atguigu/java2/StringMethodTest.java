package com.atguigu.java2;

import org.junit.Test;

/**
 * @author shkstart
 * @create 15:30
 */
public class StringMethodTest {
    /*
    *   int length()：返回字符串的长度： return value.length
        char charAt(int index)： 返回某索引处的字符return value[index]
        boolean isEmpty()：判断是否是空字符串：return value.length == 0
        String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
        String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
        String trim()：返回字符串的副本，忽略前导空白和尾部空白
        boolean equals(Object obj)：比较字符串的内容是否相同
        boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
        String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
        int compareTo(String anotherString)：比较两个字符串的大小
        String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
        String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。

    * */
    @Test
    public void test1(){
        String str = "";
//        str = null;
        System.out.println(str.isEmpty());

        String str1 = "abc123我ABC";
        System.out.println(str1.toLowerCase());
        System.out.println(str1.toUpperCase());

        String  str2 = "   he  llo  world   ";
        System.out.println("***" + str2.trim() + "###");

        String str3 = "abc";
        String str4 = "abe";
        System.out.println(str3.compareTo(str4));

        String str5 = "helloworld";
        String str6 = str5.substring(3);
        System.out.println(str6);//loworld
        System.out.println(str5);//helloworld

        String str7 = str5.substring(3,6);
        System.out.println(str7);//low

    }

    /*
    *   boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
        boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
        boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始

        *
        * boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true
         int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引。如果没有此字符串，则返回-1
         int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
         int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
         int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
         注：indexOf和lastIndexOf方法如果未找到都是返回-1

    * */
    @Test
    public void test2(){
        String str = "helloworldo";
        System.out.println(str.endsWith("orld"));
        System.out.println(true);

        System.out.println(str.indexOf("owo"));//4
        System.out.println(str.indexOf("o",5));//6
        System.out.println(str.lastIndexOf("o"));//10
    }
}
