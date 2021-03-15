package com.atguigu.part5.exer03;

public class CardTest {
    public static void main(String[] args) {
        // 1. 创建扑克牌
        Card card = new Card();
        card.initailizeCards();

        // 2. 打印指定扑克牌
        card.printSpecialCard(1);
        card.printSpecialCard(5);
        card.printSpecialCard(50);
    }
}
