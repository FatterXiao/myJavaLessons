package com.atguigu.java1;

/**
 *
 * 例题：开启三个窗口售票，总票数为100张。
 *
 * 使用实现Runnable接口的方式
 *
 *
 * @author shkstart
 * @create 15:48
 */

class Window1 implements Runnable{
    int ticket = 100;
    @Override
    public void run() {
        while(true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + "卖票，当前票号为：" + ticket);
                ticket--;

            }else{
                break;
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();
    }
}
