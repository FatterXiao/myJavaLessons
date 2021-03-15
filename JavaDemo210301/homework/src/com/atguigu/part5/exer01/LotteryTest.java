package com.atguigu.part5.exer01;
/*
    模拟大乐透号码：

    - 一组大乐透号码由10个1-99之间的数字组成
    - 打印大乐透号码信息
 */
public class LotteryTest {
    public static void main(String[] args) {
        Lottery lottery = new Lottery();
        // 1. 创建一组大乐透号码
        lottery.initailizeLotteryNumbers();
        // 2. 打印大乐透号码信息
        lottery.printNumbers();
    }
}
