package com.atguigu.java;

/**
 * @author shkstart
 * @create 9:59
 */
public class Man extends Person {

    boolean isSmoking;

    int id = 1002;

    public void eat(){
        System.out.println("男人应该多吃肉，长肌肉");
    }

    public void walk(){
        System.out.println("男人西装笔挺的走路");
    }

    public void earnMoney(){
        System.out.println("男人赚钱养家");
    }

}
