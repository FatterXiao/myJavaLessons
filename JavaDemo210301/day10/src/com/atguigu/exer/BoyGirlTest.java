package com.atguigu.exer;

/**
 * @author shkstart
 * @create 10:33
 */
public class BoyGirlTest {
    public static void main(String[] args) {
        Boy boy = new Boy("梁山伯",23);
        boy.shout();

        Girl girl = new Girl("祝英台",20);
        girl.marry(boy);

        Girl girl1 = new Girl("朱丽叶",21);

        System.out.println(girl.compare(girl1));
    }
}
