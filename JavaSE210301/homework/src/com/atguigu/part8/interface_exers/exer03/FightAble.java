package com.atguigu.part8.interface_exers.exer03;

public interface FightAble {
    void specialFight();

    default void commonFight(){
        System.out.println("普通攻击");
    }
}
