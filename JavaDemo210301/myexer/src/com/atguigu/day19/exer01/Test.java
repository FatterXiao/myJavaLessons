package com.atguigu.day19.exer01;

/**
 * @author Mr.Helianthus
 * @create 2021-03-27 11:31 AM
 */
public class Test    {
    public static void main(String[] args) {
        Window window = new Window();
        Window window1 = new Window();
        Window window2 = new Window();
        window.setName("窗口1");
        window1.setName("窗口2");
        window2.setName("窗口3");

        window.start();
        window1.start();
        window2.start();

    }
}
