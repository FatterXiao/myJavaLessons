package com.atguigu.day19.ppt;

/**
 * @author Mr.Helianthus
 * @create 2021-03-27 11:27 AM
 */
public class Test {
    public static void main(String[] args) {
        Deposite deposite = new Deposite(0);

        Thread t1 = new Thread(deposite);
        Thread t2 = new Thread(deposite);
        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();

    }
}
