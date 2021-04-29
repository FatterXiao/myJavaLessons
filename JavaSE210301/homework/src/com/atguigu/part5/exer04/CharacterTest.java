package com.atguigu.part5.exer04;

public class CharacterTest {
    public static void main(String[] args) {
        char[] arr = {'a','l','f','m','f','o','b','b','s','n'};

        CharacterUtil characterUtil = new CharacterUtil(arr);
        // 1. 进行各个字符统计
        characterUtil.statisticChars();
        // 2. 打印最后的统计结果
        characterUtil.printStatisticsResult();
    }
}
