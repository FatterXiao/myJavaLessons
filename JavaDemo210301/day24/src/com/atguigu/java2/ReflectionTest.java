package com.atguigu.java2;

import com.atguigu.java1.Person;
import junit.extensions.TestSetup;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射的应用三：调用对应的运行时类的指定的结构：属性、方法、构造器
 *
 * @author shkstart
 * @create 15:05
 */
public class ReflectionTest {

    //调用指定的属性
    @Test
    public void test1() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //public int age;
        //getField(String fieldName):可以获取当前运行时类中声明为public权限的属性。
//        Field ageField = clazz.getField("age");
//        //设置一个值
//        ageField.set(p,10);
//        //获取此值
//        System.out.println(ageField.get(p));

        //private String name;
        //使用反射获取指定属性并调用的通用的操作步骤：

        //第1步：getDeclaredField(String fieldName):获取当前运行时类中声明为指定名称的属性
        Field nameField = clazz.getDeclaredField("name");
        //第2步：设置此属性是可访问的
        nameField.setAccessible(true);
        //第3步：针对于属性的设置和调用的过程
        //设置一个值
        nameField.set(p,"Tom");
        //获取此值
        System.out.println(nameField.get(p));

    }

    //调用方法
    @Test
    public void test2() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //使用反射调用指定的方法
        //private String showNation(String nation,int age)
        //1. getDeclaredMethod(String methodName,Class ... paramTypes):获取运行时类中的指定的方法
        Method showNationMethod = clazz.getDeclaredMethod("showNation", String.class, int.class);

        //2.设置此方法是可访问的
        showNationMethod.setAccessible(true);
        //3.调用此方法
        //invoke()方法的返回值即为要调用的方法的返回值。
        String returnValue= (String) showNationMethod.invoke(p,"CHN",20);
        System.out.println(returnValue);
    }

    //调用当前运行时类中静态的结构：属性、方法
    @Test
    public void test3() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Person.class;
        //调用指定的属性：
        //private static String info;
        //1.
        Field infoField = clazz.getDeclaredField("info");
        //2.
        infoField.setAccessible(true);
        //3.1
//        infoField.set(Person.class,"人");
        infoField.set(null,"人");
        //3.2
//        System.out.println(infoField.get(Person.class));
        System.out.println(infoField.get(null));

        //调用指定的方法
        //public static void showInfo()
        Method showInfoMethod = clazz.getDeclaredMethod("showInfo");
        showInfoMethod.setAccessible(true);
        Object returnValue = showInfoMethod.invoke(null);
        System.out.println(returnValue);

    }

    //调用指定的构造器
    @Test
    public void test4() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Person.class;


        //private Person(String name, int age)
        //1. getDeclaredConstructor(Class ... args):获取指定参数的构造器
        Constructor con = clazz.getDeclaredConstructor(String.class, int.class);

        //2. 保证此构造器是可访问的
        con.setAccessible(true);

        //3. 调用此构造器，创建运行时类的对象
        Person p = (Person) con.newInstance("Tom",12);
        System.out.println(p);

        //使用如下的操作，替换原有的Class调用newInstance():
        //public Person()
        Constructor con1 = clazz.getDeclaredConstructor();
        con1.setAccessible(true);
        Person p1 = (Person) con1.newInstance();
        System.out.println(p1);
    }
}
