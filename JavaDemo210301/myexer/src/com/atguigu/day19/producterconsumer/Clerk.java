package com.atguigu.day19.producterconsumer;

/**
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，
 * 店员会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品了，
 * 店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品
 * @author Mr.Helianthus
 * @create 2021-03-27 3:34 PM
 */
public class Clerk {
    /**
     * 货物总数
     */
    private int goodsNum;

    public Clerk(int total) {
        this.goodsNum = total;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    /**
     * 生产货物
     */
    public synchronized void productGoods(){
        if(goodsNum < 20){
            this.goodsNum++;
            System.out.println(Thread.currentThread().getName() + "生产了第" + goodsNum + "个产品");
            this.notifyAll();
        }else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 消费货物
     */
    public synchronized void consumerGoods(){
        if(goodsNum > 0){
            System.out.println(Thread.currentThread().getName() + "消费了第" + goodsNum + "个产品");
            this.goodsNum--;
            this.notifyAll();
        }else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
