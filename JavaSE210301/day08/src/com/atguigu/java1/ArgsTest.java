package com.atguigu.java1;

/**
 * jdk5.0新特性：可变个数形参的方法
 * 1. 可变个数形参的格式：数据类型 ... 变量名
 * 2. 我们在调用可变个数形参方法时，可以附的实参的个数有：0个，1个，2个,...多个
 * 3. 将同一个类中，与可变个数形参的方法的方法相同名，但参数类型不同的方法之间，仍构成重载。（除了第4点）
 * 4. 可变个数的形参 与 同类型的数组类型的形参相比，编译器认为是相同的参数类型，不构成重载。
 * 5. 如果一个方法有可变个数的形参，则此可变个数的形参必须声明在方法形参的最后。
 * 6. 一个方法中最多声明一个可变个数的形参。
 *
 * @author shkstart
 * @create 16:08
 */
public class ArgsTest {
    public static void main(String[] args) {
        ArgsTest test = new ArgsTest();

        test.show(123);
        test.show(new int[]{123,234});
        test.show(123,234);
        test.show();
    }
    //如下的4个方法构成重载
    public void show(int i){
        System.out.println("11111");
    }
    public void show(double d){
        System.out.println("22222");
    }
    public void show(String s,int i){
        System.out.println("33333");
    }

    //String sql = "select id ,name,email from table_user where id > ? and email like ? ;
    public void show(int ... args){
        System.out.println("44444");
        for(int i = 0;i < args.length;i++){
            System.out.println(args[i]);
        }
    }

    public void show(String s,int ... args){

    }

//    public void show(int[] args){
//        for(int i = 0;i < args.length;i++){
//            System.out.println(args[i]);
//        }
//    }

}
