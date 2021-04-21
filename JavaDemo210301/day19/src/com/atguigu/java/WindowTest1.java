package com.atguigu.java;

/**
 *
 * 例题：开启三个窗口售票，总票数为100张。
 *
 * 使用实现Runnable接口的方式
 *
 *
 * 同步代码块解决实现Runnable的线程安全问题
 * @author shkstart
 * @create 15:48
 */

class Window1 implements Runnable{
    int ticket = 100;
//    Object obj = new Object();
//    Dog dog = new Dog();
    @Override
    public void run() {
        while(true){
            synchronized (this){ //此时的this表示w，是唯一的
//            synchronized (dog){

                if(ticket > 0){
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "卖票，当前票号为：" + ticket);
                    ticket--;

                }else{
                    break;
                }
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

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Dog{

}