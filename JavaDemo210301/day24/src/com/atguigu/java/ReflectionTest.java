package com.atguigu.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author shkstart
 * @create 9:35
 */
public class ReflectionTest {

    //不使用反射
    @Test
    public void test1(){
        //1. 创建Person类的对象
        Person p1 = new Person();
        //2. 通过对象，调用实例变量
        p1.age = 12;
        System.out.println(p1.age);
        //3. 通过对象，调用方法
        p1.show();

    }



    //使用反射，做上面同样的事
    @Test
    public void test2() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        //1. 创建Person类的对象
        Class clazz = Person.class;
//        Object instance = clazz.newInstance();
        Person p1 = (Person) clazz.newInstance();
        //2. 通过对象，调用实例变量
        Field ageField = clazz.getField("age");
        ageField.set(p1,12);
        System.out.println(ageField.get(p1));
        //3. 通过对象，调用方法
        Method showMethod = clazz.getMethod("show");
        showMethod.invoke(p1);
    }

    //体现了反射的动态性
    public Object method(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName(className);
        Object instance = clazz.newInstance();
        return instance;
    }

    //通过反射，可以调用Person类中的私有结构
    @Test
    public void test3() throws Exception {
        Class clazz = Class.forName("com.atguigu.java.Person");
        //1. 调用私有的构造器：private Person(String name,int age)
        Constructor con = clazz.getDeclaredConstructor(String.class, int.class);
        con.setAccessible(true);
        Person p1 = (Person) con.newInstance("Tom",12);
        System.out.println(p1);
        //2. 调用私有的属性：private String name;
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(p1,"Jerry");
        System.out.println(nameField.get(p1));
        //3. 调用私有的方法：private String showNation(String nation)
        Method showNationMethod = clazz.getDeclaredMethod("showNation", String.class);
        showNationMethod.setAccessible(true);
        String info = (String) showNationMethod.invoke(p1,"中国");
        System.out.println(info);
    }

    /*
    * 问题1：通过反射，也可以创建类的对象、调用方法等操作，那么跟以前的方式比，如何选择？
    *  使用频率上说：以前的方式更多，反射的方式很少。
    *  使用场景上说：大部分的场景中，创建的对象和要调用的方法都是确定的，所有都使用以前的方式。
    *               如果出现了不确定的对象的创建或方法的调用，此时才会考虑用反射。
    *
    * 问题2：反射打破了类的封装的特性？如何看待？ 单例模式可能也不保？如何看待？
    * 不矛盾！
    * 类的封装性：建议我们是否要调用
    * 反射：体现我们是否能调用
    *
    * */
}
