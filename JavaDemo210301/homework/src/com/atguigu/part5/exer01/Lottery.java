package com.atguigu.part5.exer01;

import java.util.Random;

/*
    模拟大乐透号码：

    - 一组大乐透号码由10个1-99之间的数字组成
    - 打印大乐透号码信息
 */
public class Lottery {

    private int[] numbers ;

    /**
     * 创建大乐透中奖号码
     * @return
     */
    public int[] createLotteryNumbers(){
        numbers = new int[10];
        Random random = new Random();
        int length = numbers.length;

        for (int i = 0; i < length; i++) {
            numbers[i] = random.nextInt(99) + 1;
        }

        return  numbers;
    }

    /**
     * 打印大乐透的中奖号码
     */
    public void printNumbers(){
        if(numbers == null){
            System.out.println("打印错误。还未生成大乐透中奖号码。");
            return;
        }

        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            System.out.print(numbers[i] + "\t");
        }
        System.out.println();
    }

}
