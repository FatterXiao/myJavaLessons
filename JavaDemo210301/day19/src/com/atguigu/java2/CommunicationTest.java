package com.atguigu.java2;

/**
 * 例题：使用两个线程打印 1-100。线程1, 线程2 交替打印
 *
 * 线程的通信：
 *
 * wait():一旦执行此方法，就会使得执行此方法所在的线程进行阻塞状态。同时释放同步监视器。
 * notify():一旦执行此方法，就会唤醒被wait()的线程中优先级最高的那个线程。在获得同步监视器的情况下，
 *         继续执行被wait()之后的代码。
 * notifyAll():一旦执行此方法，就会唤醒所有被wait()的线程。在获得同步监视器的情况下，继续执行被wait()之后的代码。
 *
 *
 * 说明：1. wait()/ notify() / notifyAll() :必须使用在同步代码块或同步方法中。
 *      2. wait()/ notify() / notifyAll()的调用者必须是同步代码块或同步方法中的同步监视器。
 *         否则，会报：IllegalMonitorStateException
 *      3. wait()/ notify() / notifyAll() 是定义在java.lang.Object中。
 *
 *
 * 高频面试题：sleep() 和  wait()的异同？
 *      1. 两个方法声明的位置？Thread:sleep()   / Object:wait()
 *      2. 使用的范围有没有要求？ sleep():在任何想使用的地方。  wait():必须使用在同步代码块或同步方法中
 *      3. 如果都放在同步代码块或同步方法中，是否释放锁？ sleep():不会  wait():会
 *      4. 都会导致线程进入阻塞状态。但是结束阻塞状态的方式不同？ sleep():时间到就结束阻塞。  wait():需要被唤醒
 *
 *
 * @author shkstart
 * @create 14:20
 */

class PrintNumber implements Runnable{
    int number = 1;
    Object obj = new Object();

    @Override
    public void run() {

        while(true){
            synchronized (obj) {
                //唤醒被wait()的线程
                obj.notify();
                if(number <= 100){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                }else{
                    break;
                }
                //当前的线程进入阻塞
                try {
                    obj.wait(); //会释放同步监视器
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //。。。。

            }



        }


    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        PrintNumber num = new PrintNumber();

        Thread t1 = new Thread(num);
        Thread t2 = new Thread(num);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
