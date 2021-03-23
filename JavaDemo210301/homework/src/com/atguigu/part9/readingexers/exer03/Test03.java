package com.atguigu.part9.readingexers.exer03;

public class Test03 {
    {
        System.out.println("a");
    }
    static{
        System.out.println("b");
    }
    Test03(){
        System.out.println("c");
    }
    public static String getOut(){
        try{
            return "1";
        }catch(Exception e){
            return "2";
        }finally{
            return "3";
        }
    }

    /*
     * （1）main()执行之前，需要先完成所在类的初始化
     * （2）类初始化由两部分代码组成：①静态变量的显式赋值代码②静态代码块
     * （3）没有创建对象，不会执行实例初始化相关的代码
     * （4）finally块中的代码是无论try中是否发生异常，也无论catch是否可以捕获异常，
     * 也不管try和catch中是否有return语句，都会执行的部分
     * （5）如果finally中有return语句，那么try...catch...finally结构
     * 一定从finally中的return回去
     */
    public static void main(String[] args) {
        System.out.println(getOut());
    }
}
