package com.atguigu.exer;

/**
 * 练习：创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数？
 *
 *
 *
 * @author shkstart
 * @create 14:38
 */

class EvenNumber extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
            }
        }

    }
}

class OddNumber extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i % 2 != 0){
                System.out.println(i + "**********");
            }
        }

    }
}

public class NumberTest {
    public static void main(String[] args) {
//        EvenNumber t1 = new EvenNumber();
//        OddNumber t2 = new OddNumber();
//
//        t1.start();
//        t2.start();

        //方式一：创建Thread类的匿名子类的匿名对象
//        new Thread(){
//            @Override
//            public void run() {
//                for (int i = 0; i <= 100; i++) {
//                    if(i % 2 == 0){
//                        System.out.println(i);
//                    }
//                }
//
//            }
//        }.start();
//
//        new Thread(){
//            @Override
//            public void run() {
//                for (int i = 0; i <= 100; i++) {
//                    if(i % 2 != 0){
//                        System.out.println(i + "***************");
//                    }
//                }
//
//            }
//        }.start();

        //方式二：提供Runnable接口匿名实现类的匿名对象
        new Thread(new Runnable(){

            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    if(i % 2 == 0){
                        System.out.println(i);
                    }
                }
            }
        }).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    if(i % 2 != 0){
                        System.out.println(i + "***********");
                    }
                }
            }
        }).start();

    }
}
