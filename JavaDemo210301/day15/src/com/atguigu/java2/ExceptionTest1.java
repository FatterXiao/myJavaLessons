package com.atguigu.java2;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

/**
 * 二、异常(Exception)的处理
 *
 * 有两种方式：方式一：try-catch-finally  方式二：throws + 异常类型
 *
 *  Java提供的是异常处理的抓抛模型。
 *  程序执行过程中，出现了异常，并处理异常，对应着两个过程。
 *  过程一：“抛”：程序执行过程中，一旦出现异常，就会在异常位置生成一个对应异常类型的对象，并将此
 *  对象抛出。
 *
 *  过程二：“抓”  可以广义的理解为异常处理的两种方式。
 *
 * 三、try-catch-finally的使用
 *
 * try{
 *     //可能出现异常的代码
 *
 * }catch(XxxException e){
 *    处理异常的方式
 * }catch(XxxException e){
 *    处理异常的方式
 * }
 * ...
 * finally{
 *    一定会被执行的代码
 * }
 *
 * 说明：
 * 1. finally是可选的。
 * 2. try中声明的变量，在出了try结构之后就失效了
 * 3.
 * ① 执行try中的代码时，一旦执行过程中出现异常，则会在指定代码的位置生成相应的异常类的对象，并将此
 *    对象抛出。之后try中的代码不再执行。
 * ② 抛出的对象根据其类型依次匹配try后面的catch,一旦匹配成功，就进入catch结构，进行异常的处理。处理完以后，
 * 不再匹配其后的catch结构，而是跳出try-catch继续执行其后的代码。
 * 4. 如果声明了多个catch结构，且多个catch中的异常类型没有子父类关系，则多个catch结构谁先声明，谁后声明都可以。
 *    如果多个catch中的异常类型满足子父类的关系，则子类异常类型必须声明在父类异常类型的上面，否则报错。
 *
 * 5. 常见的catch中异常处理的方式：
 *   ① 自定义输出信息
 *   ② 异常类的方法：getMessage() / printStackTrace()
 *
 * 6. 经验：
 *   ① 实际开发中，针对于运行时异常，通常我们就选择不进行异常的处理了。
 *   ② 实际开发中，针对于编译时异常，我们必须进行异常的处理，否则编译不通过。
 *     进行try-catch处理以后，就可以编译通过。那运行是否可以通过，就需要真正执行来看了。
 *
 * 7. try-catch-finally结构可以嵌套使用
 *
 * @author shkstart
 * @create 15:26
 */
public class ExceptionTest1 {

    //NumberFormatException:数字转换异常
    @Test
    public void test1(){
        try {
            String str = "123";
            str = "123a";
            int num = Integer.parseInt(str);//生成了一个NumberFormatException类的对象
            System.out.println(num);
        }catch(NullPointerException e){
            System.out.println("出现了空指针的异常.....");
        }catch(NumberFormatException e){
            //处理方式
            System.out.println("出现了数字转换异常....");
        }catch(Exception e){
            System.out.println("出现了异常....");
        }

        System.out.println("hello!");
    }
    //NullPointerException
    @Test
    public void test2(){
        try{
            String str = "hello";
            str = null;
            System.out.println(str.toString());

        }catch(NullPointerException e){
//            System.out.println(e.getMessage());

            e.printStackTrace();
        }


    }

    //ClassCastException
    @Test
    public void test3(){
        try{
            Object obj = new String("hello");
            Date date = (Date)obj;

        }catch(ClassCastException e){
            e.printStackTrace();
        }
    }

    @Test
    public void test7(){
        try {
            File file = new File("hello.txt");
            FileReader fr = new FileReader(file);
            char[] buffer = new char[4];
            int len;
            while ((len = fr.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
            fr.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
