package com.atguigu.part12.exer01;


/**
 * 在子线程中输出1-100之间的偶数，主线程输出1-100之间的奇数
 * @author Mr.Helianthus
 * @create 2021-03-26 9:20 PM
 */
public class Test01 {
    public static void main(String[] args) {
        Runnable r = ()->{
            for (int i = 0; i < 100; i++) {
                if((i & 1) == 0){
                    System.out.println(Thread.currentThread().getName() + ":" + i + "***");
                }
            }
        };

        Thread t1 = new Thread(r);
        t1.setName("子线程");
        t1.start();

        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if((i & 1) != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
