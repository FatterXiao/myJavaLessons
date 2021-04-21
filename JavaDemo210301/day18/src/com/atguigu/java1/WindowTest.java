package com.atguigu.java1;

/**
 *
 * 例题：开启三个窗口售票，总票数为100张。
 *
 * 使用继承Thread类的方式实现
 *
 * @author shkstart
 * @create 15:26
 */

class Window extends Thread{

    static int ticket = 100;//初始票数100张

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

public class WindowTest {
    public static void main(String[] args) {

        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.start();
        t2.start();
        t3.start();

    }

}
