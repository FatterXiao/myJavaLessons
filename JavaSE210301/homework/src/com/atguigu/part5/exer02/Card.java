package com.atguigu.part5.exer02;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * - 打印扑克牌
 * - 开发提示：
 *  - 使用两个字符串数组，分别保存花色和点数
 *  - 再用一个字符串数组保存最后的扑克牌
 *  - 遍历显示
 */
public class Card {
    private String[][] cards ;

    // 扑克牌点数
    private String[] cardNumbers = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    // 扑克牌花色
    private String[] cardColors = {"黑桃","红桃","梅花","方片"};

    /**
     * 创建一幅扑克牌
     * @return
     */
    public  String[][] initailizeCards(){

        int numLength = cardNumbers.length;
        int colorLength = cardColors.length;

        cards = new String[colorLength][numLength];


        for (int i = 0; i < colorLength; i++) {
            for (int j = 0; j < numLength; j++) {
                cards[i][j] =  cardColors[i] + cardNumbers[j] ;
            }
        }

        return cards;
    }

    /**
     * 打印整副扑克牌
     */
    public void printCards(){
        if(cards == null){
            System.out.println("打印错误。请先初始化扑克牌。");
            return;
        }

        int length = cards.length;
        for (int i = 0; i < length; i++) {
            int len = cards[i].length;
            for (int j = 0; j < len; j++) {
                System.out.print(cards[i][j] + "\t");
            }
            System.out.println();
        }
    }



}
