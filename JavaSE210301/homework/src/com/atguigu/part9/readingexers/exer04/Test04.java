package com.atguigu.part9.readingexers.exer04;

/*
 * （1）finally块中的代码是无论try中是否发生异常，也无论catch是否可以捕获异常，
 * 也不管try和catch中是否有return语句，都会执行的部分
 * （2）如果finally中有return语句，那么try...catch...finally结构
 * 一定从finally中的return回去，但是try和catch中的return语句中返回值的表达式会执行。
 * （3）如果finally中没有return语句，那么try...catch...finally结构
 * 才会从try或catch中的return回去，但是finally值中代码不会影响最终的返回值
 */
public class Test04 {
    static int i = 0;
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test(){
        try{
            return ++i;
        }finally{
            return ++i;
        }
    }
}
