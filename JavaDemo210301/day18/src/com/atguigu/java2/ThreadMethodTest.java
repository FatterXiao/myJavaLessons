package com.atguigu.java2;

/**
 * 测试Thread类中的常用方法
 * 1. run(): 执行分线程的操作
 * 2. start(): ① 启动线程 ② 调用线程的run()
 * 3. currentThread():获取当前执行代码的线程
 * 4. getName():获取线程的名称
 * 5. setName():设置线程的名称
 * 6. yield():一旦执行此方法，cpu就释放对当前线程的执行。
 * 7. join(): 在线程a中调用了线程b的join()，此时线程a进入阻塞状态，直到线程b执行结束之后，才结束阻塞状态继续执行。
 * 8. sleep(long millis):静态方法，让当前线程“睡眠”指定的毫秒数
 * 9. isAlive():是否存活
 *
 * 测试线程的优先级：
 *
 *   getPriority():获取线程的优先级
 *   setPriority():设置线程的优先级
 *
 *   线程的优先级中： MIN_PRIORITY = 1
 *                  NORM_PRIORITY = 5 （默认优先级）
 *                  MAX_PRIORITY = 10
 *
 *   理解：高优先级的线程会抢占低优先级的线程的cpu资源。此时的抢占是从概率上来讲，以更高的概率被cpu执行而已。
 *
 * @author shkstart
 * @create 16:20
 */
class EvenNumber extends Thread {
    @Override
    public void run() {
        //遍历100以内的偶数
        for(int i = 0;i <= 100;i++){

            if(i % 2 == 0){

//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }

//            if(i % 20 == 0){
//                this.yield();
//            }
        }
    }
}


public class ThreadMethodTest {
    public static void main(String[] args) {
        EvenNumber thread1 = new EvenNumber();

        thread1.setName("线程1");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();

        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        //遍历100以内的偶数
        for(int i = 0;i <= 100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }

//            if(i == 40){
//                try {
//                    thread1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
        }
//        System.out.println(thread1.isAlive());
    }

}
