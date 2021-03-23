package com.atguigu.part8.interface_exers.exer03;

public class Test {
    public static void main(String[] args) {
//        FightAble role = Player.select("武力角色");
        FightAble role = Player.select("法力角色");
        if(role instanceof Mage){
            Mage mager = (Mage)role;
            mager.specialFight();
        }

        if(role instanceof Fighter){
            Fighter fighter = (Fighter)role;
            fighter.specialFight();
        }
    }
}
