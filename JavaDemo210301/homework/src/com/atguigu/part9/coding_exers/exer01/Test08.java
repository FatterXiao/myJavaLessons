package com.atguigu.part9.coding_exers.exer01;

public class Test08 {
    public static void main(String[] args) {
        try {
            Person p = new Person("白蛇",-1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Person p2 = new Person();
            p2.setLifeValue(10);
            p2.setLifeValue(-10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
