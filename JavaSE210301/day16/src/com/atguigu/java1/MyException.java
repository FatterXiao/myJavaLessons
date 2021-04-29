package com.atguigu.java1;

/**
 * 如何自定义异常类？
 * 1. 需要继承于现有的异常体系结构:Exception
 * 2. 提供一个序列化的版本号：serialVersionUID
 * 3. 提供重载的方法
 * @author shkstart
 * @create 11:18
 */
public class MyException extends Exception{
    static final long serialVersionUID = -7034897166939L;

    public MyException(){

    }

    public MyException(String message){
        super(message);
    }

}
