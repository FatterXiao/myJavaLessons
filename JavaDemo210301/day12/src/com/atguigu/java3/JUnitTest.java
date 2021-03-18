package com.atguigu.java3;

import org.junit.Test;
/*
1. 如何添加jar包，并使用@Test
 ① 在当前module下创建一个文件目录：lib
 ② 将junit-4.12.jar 和 hamcrest-core-1.3.jar 粘贴到lib目录下。
    （两个jar包在：尚硅谷_宋红康_210301Java基础\3_软件\开发相关\03_IDEA\需要jar包\libs）
 ③ 选中两个jar包，右键点击-add  as  library

2. 创建一个单元测试类：JUnitTest
   > 要求此类是public的，且提供一个空参的public权限的构造器

   创建单元测试方法：test1()等
   > 要求此方法必须是public、void 、没有形参
   > 此方法的声明上需要添加：@Test
   > 导包：import org.junit.Test;



 */

/**
 * @author shkstart
 * @create 16:42
 */
public class JUnitTest {
    int num = 10;

    public void show(){
        System.out.println("haha");
    }

    public void show(String info){
        System.out.println(info);
    }

    @Test
    public void test1(){
        System.out.println("hello1");
        System.out.println(num);
        show();

        show("hello!");
    }

    @Test
    public void test2(){
        System.out.println("hello2");
    }

    @Test
    public void test3(){
        System.out.println("hello3");
    }
}
