package com.atguigu.part8.interface_exers.exer03;

public class Player {
    /**
     *  输入“法力角色”选择 法师；
     *  输入“武力角色”选择 战士；
     * @param string
     * @return
     */
    public static FightAble select(String string){
        if("法力角色".equals(string)){
            return new Mage();
        }

        if("武力角色".equals(string)){
            return new Fighter();
        }
        return null;

    }
}
