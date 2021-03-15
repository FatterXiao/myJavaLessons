package com.atguigu.part5.exer05;

public class Statistics {
    private int[] numbers;
    private int amount;
    private double average;

    public Statistics(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * 计算总分
     */
    public void calcAmount(){
        if(numbers == null){
            this.showError();
            return;
        }

        int length = numbers.length;
        this.amount = 0;
        for (int i = 0; i < length; i++) {
            this.amount += numbers[i];
        }

    }

    /**
     * 求平均分
     */
    public void calcAverage(){
        this.calcAmount();
        this.average = (double) this.amount/numbers.length;
    }

    /**
     * 遍历数组，统计比平均分高的个数
     */
    public void printResult(){
        if(numbers == null){
            this.showError();
            return;
        }
        calcAverage();

        int length = numbers.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if(numbers[i] > this.average){
                count++;
                System.out.print(numbers[i] + "\t");
            }
        }
        System.out.println();
        System.out.println("平均分为：" + this.average);
        System.out.println("高于平均分的个数： " + count);
    }
    /**
     * 打印错误信息
     */
    private void showError() {
        System.out.println("请输入正确的char数组，当前输入的数组为null。");
    }
}
