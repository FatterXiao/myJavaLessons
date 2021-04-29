package com.atguigu.day19.ppt;

/**
 * @author Mr.Helianthus
 * @create 2021-03-27 11:38 AM
 */
public class Deposite implements Runnable {
    double balance ;


    public Deposite(double balance) {
        this.balance = balance;
    }

    @Override
    public void run() {
        while (true){
            synchronized (Deposite.class){
                try {
                    Deposite.class.notify();
                    if((this.balance += 1000) > 3000){
                        break;
                    }

                    System.out.println(Thread.currentThread().getName() + "当前账户余额：" + balance);
                    Deposite.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }


}
