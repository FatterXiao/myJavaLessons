package com.atguigu.java;

/**
 * @author shkstart
 * @create 11:16
 */
class Window3 extends Thread {

    static int ticket = 100;//初始票数100张

    @Override
    public void run() {
        while (true) {

            show();

        }

    }

    public static synchronized void show(){ //此时的同步监视器是：this。此题中表示：t1,t2,t3
        if (ticket > 0) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "卖票，当前票号为：" + ticket);
            ticket--;
        }
    }
}

public class WindowTest3 {
    public static void main(String[] args) {

        Window3 t1 = new Window3();
        Window3 t2 = new Window3();
        Window3 t3 = new Window3();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }

}
