package com.atguigu.extral_exers.exer07;

/**
 * @author Mr.Helianthus
 * @create 2021-04-08 8:41 AM
 */
public class Test01 {
}
 interface StackInterface {
    public void push(int n);

    public int[] pop();
}

 class SafeStack implements StackInterface {
    private int top = 0;
    private int[] values = new int[10];
    private boolean dataAvailable = false;

    public void push(int n) {
        synchronized (this) {
            while (dataAvailable) {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }
            values[top] = n;
            System.out.println("压入数字" + n + "步骤1完成");
            top++;
            dataAvailable = true;
            notifyAll();
            System.out.println("压入数字完成");
        }
    }

    public int[] pop() {
        synchronized (this) {
            while (!dataAvailable) {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }
            System.out.println("弹出");
            top--;
            int[] test = {values[top],top};
            dataAvailable = false;
            //唤醒正在等待压入数据的线程
            notifyAll();
            return test;
        }
    }
}

//=============== 读线程 ================
class PopThread implements Runnable{
    private StackInterface s;
    public PopThread(StackInterface s){
        this.s = s;
    }
    public void run(){
        while(true){
            System.out.println("-->"+s.pop()[0]+"<--");
            try{Thread.sleep(100);
            }catch(InterruptedException e){

            }
        }
    }
}

// =======================  写线程  ========================
class PushThread implements Runnable{
    private StackInterface s;
    public PushThread(StackInterface s){
        this.s = s;
    }
    public void run(){
        int i = 0;
        while(true){
            java.util.Random r = new java.util.Random();
            i = r.nextInt(10);
            s.push(i);
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){}
        }
    }
}