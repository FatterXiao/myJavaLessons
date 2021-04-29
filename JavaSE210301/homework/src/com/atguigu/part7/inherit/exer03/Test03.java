package com.atguigu.part7.inherit.exer03;

/*
    - 知识点：继承、属性同名问题
 */
/*
 * 当父类与子类有同名的属性时：
 * 通过子类对象调用getName()访问的是父类的name还是子类的name，
 * 那么要看子类是否重写，如果没有重写，就是父类的，重写了就是子类的。
 */
public class Test03 extends Father{
    private String name = "test";

    public static void main(String[] args) {
        Test03 test = new Test03();
        System.out.println(test.getName());
    }
}

class Father {
    private String name = "father";

    public String getName() {
        return name;
    }
}