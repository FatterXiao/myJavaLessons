package com.atguigu.java1;

/**
 * 创建一个分线程，用于遍历100以内的偶数
 *
 * 方式一：使用继承Thread类的方式
 *
 * 1. 创建一个继承于Thread类的子类
 * 2. 重写Thread类的run() : 方法体的内容即为当前创建的线程要执行的操作
 * 3. 创建子类的对象
 * 4. 通过子类对象调用其start(): ① 启动线程  ② 调用当前线程的run()
 *
 * @author shkstart
 * @create 14:17
 */

//1. 创建一个继承于Thread类的子类
class EvenNumber extends Thread {

    int maxNumber;

    public EvenNumber(int maxNumber){
        this.maxNumber = maxNumber;
    }

    //2. 重写Thread类的run()
    @Override
    public void run() {
        //遍历100以内的偶数
        for(int i = 0;i <= maxNumber;i++){
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}


public class EvenNumberTest {
    public static void main(String[] args) {
        //3. 创建子类的对象
        EvenNumber thread1 = new EvenNumber(100);

        //4. 通过子类对象调用其start()
        thread1.start();

        //问题一：能不能通过直接调用run()的方式替换start()，启动线程？ No!
//        thread1.run();

        //问题二：需要再创建一个遍历100以内偶数的线程？如何做？
//        thread1.start();//此时报IllegalThreadStateException异常。

        //正确的：
        EvenNumber thread2 = new EvenNumber(100);
        thread2.start();

        //遍历100以内的偶数
        for(int i = 0;i <= 100;i++){
            if(i % 2 == 0){
                System.out.println(i + "*************");
            }
        }
    }

}
