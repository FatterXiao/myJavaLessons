package com.atguigu.part9.readingexers.exer01;

public class Test {
    /*
     * （1）finally块中的代码是无论try中是否发生异常，也无论catch是否可以捕获异常，
     * 也不管try和catch中是否有return语句，都会执行的部分
     * （2）如果finally中有return语句，那么try...catch...finally结构
     * 一定从finally中的return回去
     * （3）如果finally中没有return语句，那么try...catch...finally结构
     * 才会从try或catch中的return回去，但是finally值中代码不会影响最终的返回值
     */
    public static void main(String[] args) {
        int test = test(3,5);
        System.out.println(test);
    }

    public static int test(int x, int y){
        int result = x;
        try{
            if(x<0 || y<0){
                return 0;
            }
            result = x + y;
            return result;
        }finally{
            result = x - y;
        }
    }
}
