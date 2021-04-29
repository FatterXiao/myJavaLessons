package com.atguigu.java;

/**
 *
 *
 * @author shkstart
 * @create 11:11
 */
class Window2 implements Runnable {
    int ticket = 100;

    @Override
    public void run() {
        while (true) {
//            synchronized (this){
                show();
//            }
        }
    }

    public synchronized void show() { //默认的同步监视器是this，此题中代表：w
        if (ticket > 0) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "卖票，当前票号为：" + ticket);
            ticket--;

        }
    }

}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w = new Window2();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
