package com.atguigu.day07.homework;

public class Test02 {
    public static void main(String[] args) {

        String[] color = {"黑桃","红桃","梅花","方片"};
        String[] number = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] card = new String[color.length * number.length];

        for (int i = 0, k = 0; i < color.length; i++) {
            for (int j = 0; j < number.length; j++, k++) {
                card[k] = color[i] + number[j];
            }
        }

        // 打印扑克
        for (int i = 0; i < card.length; i++) {
            System.out.print(card[i] + " ");

            if(i != 0 && i%13==0){
                System.out.println();
            }
        }
    }
}
