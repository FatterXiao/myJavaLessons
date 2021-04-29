package com.atguigu.java1;

/**
 *    Java提供的是异常处理的抓抛模型。
 *    程序执行过程中，出现了异常，并处理异常，对应着两个过程。
 *
 *    过程一：“抛”：理解为异常对象生成的过程
 *          > 系统自动创建的指定异常类型的对象
 *          > 手动创建异常类的对象，并抛出。 使用 throw
 *
 *    过程二：“抓”  理解为异常处理的两种方式：① try-catch-finally ② throws + 异常类型
 *
 *
 * 测试throw的使用：手动抛出异常类的对象
 *  我们可以在方法内部，手动的使用"throw + 异常类的对象"的方式，显式的生成一个异常类的对象，并throw出去。
 *
 *  面试题：throw 、 throws 的区别
 *
 * @author shkstart
 * @create 10:35
 */
public class ThrowTest {
    public static void main(String[] args) {
        Student s = new Student();

        try {
            s.regist(-10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Student{
    int id;
    public void regist(int id) throws Exception{
        if(id > 0){
            this.id = id;
        }else{
            //手动抛出一个异常类的对象
//            throw new RuntimeException("输入的id不合法");
//            throw new Exception("输入的id不合法");

            //throw一个自定义异常类的对象
            throw new MyException("输入的id不合法....");

//            throw new String("输入的id不合法");
        }
    }
}
