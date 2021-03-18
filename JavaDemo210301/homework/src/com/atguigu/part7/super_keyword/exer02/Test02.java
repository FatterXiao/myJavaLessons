package com.atguigu.part7.super_keyword.exer02;
/*
    - 考核知识点：继承、this、super、重写
 */
public class Test02 {
    public static void main(String[] args) {
        Father f = new Father();
        Son s = new Son();
        System.out.println(f.getInfo());
        System.out.println(s.getInfo());
        s.test();
        System.out.println("-----------------");
        s.setInfo("大硅谷");
        System.out.println(f.getInfo());
        System.out.println(s.getInfo());
        s.test();
    }
}

class Father {
    private String info = "atguigu";

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}

class Son extends Father {
    private String info = "尚硅谷";

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void test() {
        System.out.println(this.getInfo());
        System.out.println(super.getInfo());
    }
}

