package com.atguigu.part17.exer01;

/**
 * @author Mr.Helianthus
 * @create 2021-04-12 9:21 PM
 */
public class Test {
    public static void main(String[] args) {
        ThreadDemo t = new ThreadDemo();
        t.start();
        t.getClass();
//        ClassLoader
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(t.isFlag()){
                System.out.println("mian : flag is " + t.isFlag());
                break;
            }
        }
    }

    @org.junit.Test
    public void test() throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);

        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader1);
    }

}


class ThreadDemo extends Thread{
    private boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag = " + flag);
    }
}

