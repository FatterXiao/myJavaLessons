package com.atguigu.part8.interface_exers.exer02;

public class Sun extends Star implements Universe {

    @Override
    public void shine() {
        System.out.println("sun:光照八分钟，到达地球");
    }

    @Override
    public void doAnything() {
        System.out.println("sun: 太阳吸引这9大行星旋转");
    }
}
