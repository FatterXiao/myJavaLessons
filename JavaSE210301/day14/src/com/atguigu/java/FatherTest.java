package com.atguigu.java;

/**
 * @author shkstart
 * @create 9:09
 */
public class FatherTest {
    public static void main(String[] args) {
        Son s1 = new Son();
        System.out.println(s1.name);
        System.out.println(s1.getName());

        Father f1 = s1;
        System.out.println(f1.name);
        System.out.println(f1.getName());

        Father f2 = new Father();
        System.out.println(f2.name);//
        System.out.println(f2.getName());//
    }
}

class Father{
    String name = "1111";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Son extends Father{
    String name = "2222";

    public String getName() {
        return name;
    }
}