package com.atguigu.part5.exer04;

import java.util.Arrays;

/*
    - 统计字符
        - 字符数组：{'a','l','f','m','f','o','b','b','s','n'}
        - 统计每个字符出现的次数并打印到控制台
    - 可以定义长度26的数组，每个元素，对应去保存每种字符的出现次数，比如0索引保存a的次数，1索引保存b的次数，以此类推
 */
public class CharacterUtil {
    private char[] characters;
    private int[] count = new int[26];// 用于统计每个字符出现的次数

    public CharacterUtil(char[] characters) {
        this.characters = characters;
    }

    /**
     * 统计各个字符出现出次数；
     * 要求字符数组都是小写字符
     */
    public void statisticChars(){
        Arrays.fill(count,0);
        //例如：arr[0]现在是'a'，那么应该counts[0]++
        //arr[1]现在是'l'，那么应该counts[11]++
        //找counts[下标]其中的下标与字母'a','b'等的关系
        //例如：'a' ==》counts[0]的[0]的关系		'a'-97=97-97=0
        //例如：'l' ==》counts[11]的[11]的关系		'l'-97=108-97=11
        int length = characters.length;
        for (int i = 0; i < length; i++) {
            count[characters[i] - 97]++;
        }
    }

    /**
     * 打印统计结果
     */
    public void printStatisticsResult() {
        if(characters == null){
            this.showError();
            return;
        }

        int length = count.length;
        for (int i = 0; i < length; i++) {
            if(count[i] != 0){
                System.out.println((char)(i + 97) + ": " + count[i]);
            }
        }
    }


    /**
     * 打印错误信息
     */
    private void showError() {
        System.out.println("请输入正确的char数组，当前输入的数组为null。");
    }
}
