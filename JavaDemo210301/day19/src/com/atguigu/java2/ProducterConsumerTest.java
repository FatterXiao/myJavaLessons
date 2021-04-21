package com.atguigu.java2;

/**
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，
 * 店员会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品了，
 * 店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 *
 *
 * 分析：
 * 1. 是不是多线程问题？是  生产者线程、消费者线程
 * 2. 会出现线程安全问题吗？会。有共享数据
 * 3. 共享数据是什么？ 产品的数量
 * 4. 是否存在线程的通信？ 有！
 *
 * @author shkstart
 * @create 15:05
 */
public class ProducterConsumerTest {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producter p1 = new Producter(clerk);
        Consumer c1 = new Consumer(clerk);
        Consumer c2 = new Consumer(clerk);

        p1.setName("生产者1");
        c1.setName("消费者1");
        c2.setName("消费者2");

        p1.start();
        c1.start();
        c2.start();
    }

}

class Clerk{//店员
    int productNum;//产品数据
    
    //添加产品
    public synchronized void addProduct(){
        if(productNum < 20){
            productNum++;
            System.out.println(Thread.currentThread().getName() + "生产了第" + productNum + "个产品");

            notifyAll();

        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //减少产品
    public synchronized void consumeProduct(){
        if(productNum > 0){
            System.out.println(Thread.currentThread().getName() + "消费了第" + productNum + "个产品");
            productNum--;

            notifyAll();

        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producter extends Thread{ //生产者

    Clerk clerk;

    public Producter(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() { //生产产品

        System.out.println(Thread.currentThread().getName() + "开始生产产品");

        while(true){

            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.addProduct();

        }
    }
}

class Consumer extends Thread{ //消费者
    Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() { //消费产品
        System.out.println(Thread.currentThread().getName() + "开始消费产品");

        while(true){

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.consumeProduct();

        }

    }
}