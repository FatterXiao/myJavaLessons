package com.atguigu.java2;

/**
 * 测试4种不同的权限修饰
 *
 *
 * @author shkstart
 * @create 14:50
 */
public class Order {
    private int orderPrivate;
    int orderDefault;
    protected int orderProtected;
    public int orderPublic;

    private void methodPrivate(){
        System.out.println("methodPrivate");

        orderPrivate = 1;
        orderDefault = 2;
        orderProtected = 3;
        orderPublic = 4;
    }

    void methodDefault(){
        System.out.println("methodDefault");
        orderPrivate = 1;
        orderDefault = 2;
        orderProtected = 3;
        orderPublic = 4;

    }
    protected void methodProtected(){
        System.out.println("methodProtected");
        orderPrivate = 1;
        orderDefault = 2;
        orderProtected = 3;
        orderPublic = 4;
    }
    public void methodPublic(){
        System.out.println("methodPublic");

        orderPrivate = 1;
        orderDefault = 2;
        orderProtected = 3;
        orderPublic = 4;
    }
}
