package com.atguigu.java1;

/**
 * @author shkstart
 * @create 14:50
 */
public class Order {
    private int orderPrivate;
    int orderDefault;
    public int orderPublic;

    private void methodPrivate(){
        System.out.println("methodPrivate");

        orderPrivate = 1;
        orderDefault = 2;
        orderPublic = 3;
    }

    void methodDefault(){
        System.out.println("methodDefault");
        orderPrivate = 1;
        orderDefault = 2;
        orderPublic = 3;

    }
    public void methodPublic(){
        System.out.println("methodPublic");

        orderPrivate = 1;
        orderDefault = 2;
        orderPublic = 3;
    }
}
