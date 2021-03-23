package com.atguigu.java;

import org.junit.Test;

/**
 * @author shkstart
 * @create 10:50
 */
public class InterViewTest {
    @Test
    public void method1() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);//false

        //Integer内部缓存了一个Integer[] cache，此数组的长度是256，
        // 元素的值：cache[0] = new Integer(-128),cache[1] = new Integer(-127),...
        // cache[255] = new Integer(127)
        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);//true
        //当Integer对象赋的值，超出了[-128,127]，则每次都重新创建对象。
        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);//false

    }

}
