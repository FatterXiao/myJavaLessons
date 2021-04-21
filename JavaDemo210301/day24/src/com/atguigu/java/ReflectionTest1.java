package com.atguigu.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.ElementType;
import java.util.Properties;

/**
 *
 * 1. 理解Class类
 * 2. 获取Class的实例
 * 3. 了解类的加载与类的加载器
 *
 *
 *  Class看做是反射的源头。
 *  java程序经过javac.exe编译之后，会生成一个或多个.class结尾的字节码文件。接着，我们使用java.exe 指令
 *  将指定.class文件对应的类加载到内存中。此类就称为运行时类。此运行时类本身就作为Class的一个实例。
 *  补充：此运行时类加载到方法区的缓存位置；运行时类的加载使用的是类的加载器。
 *
 *  换句话说：Class的一个实例就会对应一个加载到内存中的运行时类。（狭义）
 *
 *  说明：通常加载到方法区的运行时类只有一份，不会重复加载。
 *
 * @author shkstart
 * @create 10:28
 */
public class ReflectionTest1 {

    //获取Class的实例(讲4种方式，需要大家掌握前3种方式)
    @Test
    public void test1() throws ClassNotFoundException {
        //方式1：调用运行时类的class属性
        Class<Person> clazz = Person.class;
        Class<String> clazz1 = String.class;

        //方式2：调用Class的静态方法：forName(String className)
        Class clazz2 = Class.forName("com.atguigu.java.Person");

        //方式3：调用对象的getClass()
        Person p = new Person();
        Class clazz3 = p.getClass();

        System.out.println(clazz == clazz2 && clazz == clazz3);

        //方式4：使用类的加载器
        Class clazz4 = ClassLoader.getSystemClassLoader().loadClass("com.atguigu.java.Person");
        System.out.println(clazz == clazz4);

    }

    /*
        Class的实例都可以指向哪些结构呢？
       （1）class：
        外部类，成员(成员内部类，静态内部类)，局部内部类，匿名内部类
        （2）interface：接口
        （3）[]：数组
        （4）enum：枚举
        （5）annotation：注解@interface
        （6）primitive type：基本数据类型
        （7）void

    * */
    @Test
    public void test2(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        System.out.println(a);
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        //对于数组来说：只要元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);

    }


    /*
    测试类的加载器
     */
    @Test
    public void test3() throws ClassNotFoundException {
        //自定义类使用的是系统类加载器进行的加载
        Class clazz1 = Class.forName("com.atguigu.java.Person");
        System.out.println(clazz1.getClassLoader());

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        //java核心api使用的是引导类加载器。
        //引导类加载器不可以直接获取。
        Class clazz2 = String.class;
        System.out.println(clazz2.getClassLoader());

    }

    @Test
    public void test4(){
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        //获取扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);
        //获取引导类加载器：获取失败
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
    }

    //需要掌握如下的代码
    @Test
    public void test5() throws IOException {
        Properties pros = new Properties();
        //方式1：此时默认的相对路径是当前的module
//        FileInputStream is = new FileInputStream("info.properties");
        FileInputStream is = new FileInputStream("src//info1.properties");

        //方式2：使用类的加载器
        //此时默认的相对路径是当前module的src目录
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("info1.properties");


        pros.load(is);

        //获取配置文件中的信息
        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println("name = " + name + ", password = " + password);
    }
}
