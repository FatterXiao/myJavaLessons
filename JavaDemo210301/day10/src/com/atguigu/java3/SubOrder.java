package com.atguigu.java3;

import com.atguigu.java2.Order;

/**
 * @author shkstart
 * @create 15:49
 */
public class SubOrder extends Order {

    public void method(){
        orderProtected = 1;
        orderPublic = 2;

        methodProtected();
        methodPublic();


//        orderPrivate = 1;
//        orderDefault = 2;
//        methodPrivate();
//        methodDefault();
    }
}
