package com.atguigu.java1;


/**
 * @author shkstart
 * @create 16:12
 */
public class SingletonTest1 {
    public static void main(String[] args) {
        Runtime r1 = Runtime.getInstance();
        Runtime r2 = Runtime.getInstance();

        System.out.println(r1 == r2);
    }
}

//懒汉式
class Runtime {
    //1. 私有化类的构造器
    private Runtime() {

    }

    //2. 声明当前类的一个变量
    private static Runtime instance = null;

    //3. 调用方法，返回当前类的一个实例
    //方式1：
//    public static synchronized Runtime getInstance(){
//
//        if(instance == null){
//
//            instance = new Runtime();
//        }
//        return instance;
//    }
    //方式2：比方式1好
//    public static Runtime getInstance() {
//
//        synchronized (Runtime.class) {
//            if (instance == null) {
//
//                instance = new Runtime();
//            }
//        }
//        return instance;
//    }

    //方式3：推荐
    public static Runtime getInstance() {

        if(instance == null){

            synchronized (Runtime.class) {
                if (instance == null) {

                    instance = new Runtime();
                }
            }
        }
        return instance;

    }

}
