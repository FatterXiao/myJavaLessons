package com.atguigu.java2;

/**
 * Object类中toString()的测试
 * 0. 当我们print(对象名)时，实际上与print(对象名.toString())是一样的。
 *
 * 1. Object类中toString()的定义：
 *    public String toString() {
 *         return getClass().getName() + "@" + Integer.toHexString(hashCode());
 *     }
 * 2. 自定义类在没有重写toString()时，就是默认调用Object类中的toString(),返回当前对象的类型和内存中的地址值。
 *
 * 3.像String\日期类 Date \ File\包装类等已经重写了Object类中定义的toString(),返回当前对象中
 *  实体内容的信息
 *
 * 4. 对于自定义类，如果希望调用toString()时，显示对象的实体内容的信息，则可以考虑重写toString()
 *
 *
 *
 * @author shkstart
 * @create 15:16
 */
public class ToStringTest {
    public static void main(String[] args) {
        User u1 = new User("Tom",12);
        System.out.println(u1.toString());//com.atguigu.java2.User@1540e19d --> User{ name : Tom,age : 12}
        System.out.println(u1);//com.atguigu.java2.User@1540e19d --> User{ name : Tom,age : 12}

        String str1 = new String("hello");
        String str2 = "abc";
        System.out.println(str1.toString());
        System.out.println(str2);

    }
}
