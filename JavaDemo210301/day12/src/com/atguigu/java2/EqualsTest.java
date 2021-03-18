package com.atguigu.java2;

/**
 * Object类中equals()的测试
 *
 * 1. == 的使用
 *  ① 使用范围：基本数据类型、引用数据类型
 *  ② 使用在基本数据类型上，判断两个变量存储的数据值是否相等
 *    使用在引用数据类型上，判断两个引用的地址值是否相等。（判断两个引用是否指向内存中的同一个对象）
 *
 *   对比：equals()只能使用在引用数据类型的变量上。
 *
 * 2. equals()的使用
 * 2.1 java.lang.Object类中equals()的定义：
 *    public boolean equals(Object obj) {
 *         return (this == obj);
 *     }
 *  2.2 当自定义类没有重写equals()时，调用的就是Object类中定义的equals(),比较两个引用的地址值是否相等
 *
 *  2.3 像String\日期类 Date \ File\包装类等已经重写了Object类中定义的equals()，用于判断两个对象
 *      的“实体内容”是否相等。
 *
 * 2.4 开发中，对应自定义类，常常也需要重写equals(),用于判断两个对象的“实体内容”是否相等。
 *
 *
 * 面试题： 区分 == 和 equals()
 *
 * @author shkstart
 * @create 14:32
 */
public class EqualsTest {
    public static void main(String[] args) {
//        EqualsTest test = new EqualsTest();
//        test.method();

        User u1 = new User("Tom",12);
        User u2 = new User("Tom",12);
        System.out.println(u1 == u2);//false
        System.out.println(u1.equals(u2));//false  --> true

        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1 == s2);//false
        System.out.println(s1.equals(s2));//true

    }

    public void method(){
        // ==
        int m = 10;
        int n = 10;
        System.out.println(m == n);//true

        long l = 10L;
        System.out.println(m == l);//true

        int k = 65;
        char c = 'A';
        System.out.println(k == c);//true

        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1 == s2);
        String s3 = s1;
        System.out.println(s1 == s3);
    }
}
