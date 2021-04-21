package com.atguigu.day19.producterconsumer;

/**
 * @author Mr.Helianthus
 * @create 2021-03-27 3:48 PM
 */
public class Test {
    public static void main(String[] args) {
        Clerk clerk = new Clerk(0);
        Producter producter = new Producter(clerk);
        Producter producter1 = new Producter(clerk);
        Consumer consumer = new Consumer(clerk);

        Thread t = new Thread(producter);
        Thread t_consumer = new Thread(producter1);
        Integer i = 123;
    }
}
