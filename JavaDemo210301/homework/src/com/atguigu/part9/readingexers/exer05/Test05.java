package com.atguigu.part9.readingexers.exer05;

import java.io.IOException;

/*
 * （1）throw用于手动抛出异常
 * （2）无论是JVM抛出的异常还是throw抛出的异常都需要catch处理
 * （3）catch是多分支结构，从上到下按顺序匹配，只会进入第一个匹配上的catch分支
 * （4）finally块中的代码是无论try中是否发生异常，也无论catch是否可以捕获异常，
 * 也不管try和catch中是否有return语句，都会执行的部分
 */
public class Test05 {
    public static void main(String[] args) {
        int a = -1;
        try{
            if(a>0){
                throw new RuntimeException("");
            }else if(a<0){
                throw new IOException("");
            }else{
                return ;
            }
        }catch(IOException ioe){
            System.out.println("IOException");
        }catch(Throwable e){
            System.out.println("Throwable");
        }finally{
            System.out.println("finally");
        }
    }
}
