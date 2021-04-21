package com.atguigu.day24;

/**
 * @author Mr.Helianthus
 * @create 2021-04-03 3:38 PM
 */
public class Test01 {
    int a;
    int b;
    public void f(){
        a = 0;
        b = 0;
        int[] c = {0};
        g(b,c);
        System.out.println(a + " " + b + " " + c[0]);
    }
    public void g(int b, int[] c){
        a = 1;
        b = 1;
        c[0] = 1;
    }
    public static void main(String[] args) {
        Test01 t = new Test01();
        t.f();
    }
}
