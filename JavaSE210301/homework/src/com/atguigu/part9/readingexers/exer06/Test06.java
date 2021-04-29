package com.atguigu.part9.readingexers.exer06;

public class Test06 {
    public static int fun(){
        int result = 5;
        try{
            result = result / 0;
            return result;
        }catch(Exception e){
            System.out.println("Exception");
            result = -1;
            return result;
        }finally{
            result = 10;
            System.out.println("I am in finally.");
        }
    }

    /*
     * （1）finally块中的代码是无论try中是否发生异常，也无论catch是否可以捕获异常，
     * 也不管try和catch中是否有return语句，都会执行的部分
     * （2）如果finally中有return语句，那么try...catch...finally结构
     * 一定从finally中的return回去
     * （3）如果finally中没有return语句，那么try...catch...finally结构
     * 才会从try或catch中的return回去，但是finally值中代码不会影响最终的返回值
     */
    public static void main(String[] args) {
        int x = fun();
        System.out.println(x);
    }
}
