package com.atguigu.java;

/**
 * 例题：开启三个窗口售票，总票数为100张。
 * <p>
 * 使用继承Thread类的方式实现
 *
 * 1. 程序执行中出现了重票、错票
 * 2. 如何解决？需要一个线程针对于ticket完全操作结束之后，其他的线程才能进入继续操作ticket
 *
 * 3. 代码层面如何解决？线程的同步机制。
 *
 * 4. 同步机制的实现方式：
 *  方式一：同步代码块
 *      synchronized(同步监视器){
 *          //需要被同步的代码
 *      }
 *     说明：① 需要被同步的代码，即为操作共享数据的代码
 *          ② 共享数据？ 多个线程共同操作的数据
 *          ③ 同步监视器，即为一个对象。俗称：锁
 *             要求：① 任何一个类的对象都可以充当同步监视器。
 *                  ② 多个线程必须共享同一个同步监视器。
 *
 *
 *  方式二：同步方法
 *       如果操作共享数据的代码完整的声明在一个或多个方法中，此时可以考虑将此方法声明为同步方法。
 *
 *       对于非静态的同步方法而言，默认的同步监视器是：this
 *       对于静态的同步方法而言，默认的同步监视器是：当前类.class
 *
 *
 * 测试使用同步代码块解决继承Thread类的方式中的线程安全问题。
 *
 *  小结：针对同步监视器：实现Runnable的方式中可以考虑使用this。在继承Thread类的方式时，慎重this。
 *                      可以考虑使用的同步监视器是：当前类.class
 *        针对于操作共享数据的代码：不能“包”少了，也不能“包”多了
 *
 *  5. 同步机制：好处：解决了线程的安全问题。
 *              缺点：执行同步代码块的过程中，其实是单线程的。效率低。
 * @author shkstart
 * @create 15:26
 */

class Window extends Thread {

    static int ticket = 100;//初始票数100张
    static Object obj = new Object();
    @Override
    public void run() {
            while (true) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            synchronized(obj){
            synchronized(Window.class){ //Class clazz = Window.class

            //不能使用this
//            synchronized(this){  //此时的this代表w1,w2,w3
                if (ticket > 0) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "卖票，当前票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }

        }

    }
}

public class WindowTest {
    public static void main(String[] args) {

        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }

}
