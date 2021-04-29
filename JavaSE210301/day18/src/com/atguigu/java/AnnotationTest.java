package com.atguigu.java;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 注解(Annotation)的使用
 *
 * 1. jdk 5.0的新特性
 * 2. Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加载, 运行时被读取, 并执行相应的处理。
 * 3. Annotation 可以像修饰符一样被使用, 可用于修饰包,类, 构造器, 方法, 成员变量, 参数, 局部变量的声明,
 *   这些信息被保存在 Annotation 的 “name=value” 对中。
 *
 * 4. 在编译时进行格式检查(JDK内置的三个基本注解)
 *     @Override: 限定重写父类方法, 该注解只能用于方法
 *     @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
 *     @SuppressWarnings: 抑制编译器警告
 *
 * 5. 如何自定义注解并使用
 *      参照@SuppressWarnings定义。
 *
 * 6. 元注解
 *      ① @Retention: 只能用于修饰一个 Annotation 定义, 用于指定该 Annotation 的生命周期
 *          三种生命周期状态：SOURCE:字节码文件中不保存
 *                          CLASS：会保留到字节码文件中，但是运行时内存中不保存。默认行为
 *                          RUNTIME:运行时会保留到内存中。 可以后期通过反射获取。
 *      ②  @Target: 用于修饰 Annotation 定义, 用于指定被修饰的 Annotation 能用于修饰哪些程序元素。
 *      ③ @Documented: 用于指定被该元 Annotation 修饰的 Annotation 类将被 javadoc 工具提取成文档。
 *         默认情况下，javadoc是不包括注解的。
 *      ④  @Inherited: 被它修饰的 Annotation 将具有继承性。
 *         如果某个类使用了被 @Inherited 修饰的 Annotation, 则其子类将自动具有该注解
 *
 *
 *      上述的元注解中的@Retention、@Target一般在定义注解时，都会使用。
 *
 * 7. 如何通过反射获取注解信息（在反射章节讲）
 *
 * 8. jdk8中，有注解的新特性：重复注解、类型注解 （略）
 *
 * @author shkstart
 * @create 9:57
 */
public class AnnotationTest {
    //main()方法是程序的入口
    public static void main(String[] args) {

        @SuppressWarnings("unused")
        int num = 10;

        Date date = new Date(2021 -1900,3-1,4);

        Person p = new Person();
        p.eat();

        @SuppressWarnings({"unused","rawtype"})
        List list = new ArrayList();
    }
}

@Deprecated
@MyAnnotation("hello")
class Person{
    public void eat(){
        System.out.println("人吃饭");
    }
}


class Student extends Person{

    @Override
    public void eat() {
        super.eat();
    }
    @MyAnnotation("age")
    int age ;

    @MyAnnotation("info")
    public void info(){

    }
}
