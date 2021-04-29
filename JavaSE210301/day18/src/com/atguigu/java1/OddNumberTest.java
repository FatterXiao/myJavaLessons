package com.atguigu.java1;

/**
 * 遍历100以内的奇数。
 *
 * 方式二：实现Runnable接口的方式：
 * 1. 提供实现Runnable接口的实现类
 * 2. 实现接口中的抽象方法run():方法体的内容即为当前创建的线程要执行的操作
 * 3. 创建实现类的对象
 * 4. 将实现类的对象作为参数，传递到Thread类的构造器中，创建Thread类的对象
 * 5. 通过Thread类的对象调用start():① 启动线程  ② 调用当前线程的run()
 *
 *
 * 对比继承Thread类和实现Runnable接口的方式
 * 1. 哪个更好？实现Runnable接口
 * 2.
 *  ① 继承的方式受到类的单继承性的局限性的影响
 *  ② 对于多个线程操作共享数据的场景，实现的方式更适合。
 *  ③ 实现的方式更好的体现了数据与操作逻辑的分离。
 * 3. 二者的联系：
 *   public class Thread implements Runnable
 *
 * @author shkstart
 * @create 15:05
 */
//1. 提供实现Runnable接口的实现类
class OddNumber implements Runnable{
    //2. 实现接口中的抽象方法run()
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i % 2 != 0){
                System.out.println(i);
            }
        }
    }

}

public class OddNumberTest {

    public static void main(String[] args) {
        //3. 创建实现类的对象
        OddNumber o = new OddNumber();
        //4. 将实现类的对象作为参数，传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(o);
        //5. 通过Thread类的对象调用start()
        t1.start();

        // 再创建一个线程，用于遍历100以内的奇数
        Thread t2 = new Thread(o);
        t2.start();

        System.out.println("========hello========");
    }

}


