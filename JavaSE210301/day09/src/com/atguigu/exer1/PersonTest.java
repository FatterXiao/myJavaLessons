package com.atguigu.exer1;

/**
 * 在PersonTest类中实例化Person类的对象b，调用setAge()和getAge()方法，体会Java的封装性。
 *
 * @author shkstart
 * @create 14:46
 */
public class PersonTest {
    public static void main(String[] args) {
        Person b = new Person();

//        b.age = 10;

        b.setAge(10);

        System.out.println(b);//com.atguigu.exer1.Person@1540e19d

        System.out.println(b.getAge());
    }
}
