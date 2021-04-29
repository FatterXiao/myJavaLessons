package com.atguigu.part9.readingexers.exer02;

public class Test02 {
    /*
     * finally块中的代码是无论try中是否发生异常，也无论catch是否可以捕获异常，
     * 也不管try和catch中是否有return语句，都会执行的部分
     */
    public static void main(String[] args) {
        try{
            return;
        }finally{
            System.out.println("finally");
        }
    }
}
