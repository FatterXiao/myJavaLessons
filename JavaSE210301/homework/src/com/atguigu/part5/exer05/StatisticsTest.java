package com.atguigu.part5.exer05;

public class StatisticsTest {
    public static void main(String[] args) {
        int[] arr = {95, 92, 75, 56, 98, 71, 80, 58, 91, 91};

        Statistics statistics = new Statistics(arr);
        statistics.printResult();
    }
}
