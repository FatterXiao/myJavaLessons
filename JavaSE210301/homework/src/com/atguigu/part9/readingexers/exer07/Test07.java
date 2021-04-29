package com.atguigu.part9.readingexers.exer07;

public class Test07 {
    public static int aMethod(int i)throws Exception{
        try{
            return i / 10;
        }catch(Exception ex){
            throw new Exception("exception in aMethod");
        }finally{
            System.out.println("finally");
        }
    }

    /*
     * （1）finally块中的代码是无论try中是否发生异常，也无论catch是否可以捕获异常，
     * 也不管try和catch中是否有return语句，都会执行的部分
     * （2）throw用于手动抛出异常
     * （3）throws用于将异常抛给调用者处理
     */
    public static void main(String[] args) {
        try {
            aMethod(0);
        } catch (Exception e) {
            System.out.println("exception in main");
        }
    }
}
