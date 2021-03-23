package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

/**
 * 异常处理章节内容：
 * 1. 了解异常的体系结构
 * 2. 常见的Error、Exception（编译时异常、运行时异常）的举例
 * 3. 异常处理的方式一：try-catch-finally
 * 4. 异常处理的方式二：throws
 * 5. 手动的抛出一个异常类的对象
 * 6. 用户自定义异常类
 *
 * 测试异常处理的方式二：throws + 异常类型
 *
 *  1. 声明位置：我们在方法的声明处，使用“throws + 异常类型”方式处理异常
 *  2. 与try-catch-finally区别在于：throws方式将可能出现的异常对象抛给方法的调用者。由调用者继续考虑
 *     该如何处理异常。
 *
 *  3. 与try-catch-finally相同的地方：只针对于编译时异常进行处理即可。运行时异常可不用处理。
 *
 *
 *  4. 开发中，该如何选择使用try-catch-finally还是throws的方式处理异常呢？
 *     ① 子类重写父类的方法，如果父类的方法中没有声明throws的结构，则子类方法中如果出现异常，只能使用
 *       try-catch-finally的方式处理异常
 *     ② 如果代码中涉及到相关的资源（IO流、Socket资源、数据库连接）必须手动关闭的话，则只能使用try-catch-finally的方式处理异常。
 *     ③ 如果一个方法a中又调用了相关的数个方法，而此数个方法之间是递进调用的关系。则通常，数个方法内如果有
 *      异常的话，选择使用throws的方式进行处理，而在方法a中统一使用try-catch-finally的方式进行处理。
 *
 *
 * @author shkstart
 * @create 9:30
 */
public class ExceptionTest {

    public static void main(String[] args) {
//        method1();

        method4();
    }

    public static void method4(){
        try {
            method3();
        }catch(FileNotFoundException e){
            e.printStackTrace();

        }catch(IOException e){
            e.printStackTrace();

        }
    }

    public static void method3() throws FileNotFoundException,IOException{
        method2();
    }

    public static void method2() throws FileNotFoundException, IOException {
        File file = new File("hello1.txt");
        FileReader fr = new FileReader(file);
        char[] buffer = new char[4];
        int len;
        while ((len = fr.read(buffer)) != -1) {
            String str = new String(buffer, 0, len);
            System.out.print(str);
        }
        fr.close();
    }

    public static void method1(){
        Object obj = new String("hello");
        Date date = (Date)obj;
    }


    @Test
    public void test(){

        method0();

    }

    public void method0() {
        String str = "123";
        str = "123a";
        int num = Integer.parseInt(str);
        System.out.println(num);
    }
}
