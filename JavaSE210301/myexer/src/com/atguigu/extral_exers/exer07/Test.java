package com.atguigu.extral_exers.exer07;

import java.util.Random;

/**
 * @author Mr.Helianthus
 * @create 2021-04-07 9:11 PM
 */
public class Test {
    public static void main(String[] args) {
        Houseware h = new Houseware();

        Worker w = new Worker(h);
        Saler s = new Saler(h);

        w.start();
        s.start();
    }
}

class Houseware {
    private Object[] buffer = new Object[10];
    private int total;

    synchronized public void put(Object data) {
        if (total >= buffer.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buffer[total] = data;
        total++;
        System.out.println(data + "被存入，现在数量是：" + total);
        this.notify();
    }

    synchronized public Object take() {
        if (total <= 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object data = buffer[0];
        System.arraycopy(buffer, 1, buffer, 0, total - 1);
        total--;
        this.notify();
        System.out.println(data + "被取出，现在数量是：" + total);
        return data;
    }

}


class Worker extends Thread {
    private Houseware h;

    public Worker(Houseware h) {
        super();
        this.h = h;
    }

    public void run() {
        Random r = new Random();
        while (true) {
            h.put(r.nextInt());
        }
    }
}


class Saler extends Thread {
    private Houseware h;

    public Saler(Houseware h) {
        super();
        this.h = h;
    }

    public void run() {
        while (true) {
            Object take = h.take();
        }
    }
}