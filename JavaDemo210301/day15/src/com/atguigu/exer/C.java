package com.atguigu.exer;

/**
 * @author shkstart
 * @create 9:37
 */
interface A {
    int x = 0;
}
class B {
    int x = 1;
}
class C extends B implements A {
    public void pX() {
//        System.out.println(x);
        System.out.println(super.x);
        System.out.println(A.x);
    }
    public static void main(String[] args) {
        new C().pX();
    }
}

