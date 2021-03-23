package com.atguigu.java1;

/**
 * main()的体会：
 * 1. main()是程序的入口
 * 2. 体会一下具体的关键字
 * 3. 体会main()也可以作为普通的静态方法调用
 * 4. 体会一下main()形参的使用
 *
 * @author shkstart
 * @create 10:23
 */
public class MainTest {
    public static void main(String[] args) {
        Main.main(null);
    }
}

class Main{
    public static void main(String[] args) {
        System.out.println("hello");
    }
}
