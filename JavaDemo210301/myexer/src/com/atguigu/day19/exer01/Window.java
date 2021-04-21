package com.atguigu.day19.exer01;

/**
 * @author Mr.Helianthus
 * @create 2021-03-27 11:28 AM
 */
public class Window extends Thread {
    static int total = 100;

    @Override
    public void run() {

        while (true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(Window.class){
                if(total > 0){
                    total--;
                    System.out.println(Thread.currentThread().getName() + " 当前剩余票数： " + total);
                }else {
                    System.out.println("票已经售完。");
                    break;
                }
            }

        }
    }
}
