package com.atguigu.java;

import java.util.Scanner;

/**
 * 测试类中方法的定义
 *
 * 0. 举例：
 *  Scanner类中：nextXxx()：nextInt()
 *  Math类中：random() / sqrt()
 *  Arrays类中：equals() / toString() / sort(int[] arr) / binarySearch()
 *
 * 1. 方法的定义（或声明）格式：
 *   权限修饰符 返回值类型 方法名(形参列表){
 *       //方法体
 *   }
 *   补充：像 static \ final \ abstract \ native 等关键字修饰方法的情况，后续再讲
 *
 * 2. 定义的细节：
 *  ① 权限修饰符：修饰方法可以使用的权限修饰符有：public 、 protected 、缺省 、 private
 *    关于权限修饰符我们放到封装性具体来讲。暂时修饰方法大家都使用public即可。
 *  ② 返回值类型：如果一个方法调用完以后，需要有相关数据的返回。那么我们就可以指定要返回的数据的类型。
 *      方法可以分为：一类是有返回值的（需要指明返回值的类型。并且方法内需要使用return + 具体类型的变量或常量）
 *                   一类是没有返回值的（使用void表示返回值类型即可）。
 *
 *      开发中定义方法的话，到底要不要定义返回值类型呢？
 *          > 根据题目要求
 *          > 具体问题具体分析
 *  ③ 方法名：方法名是一个标识符，需要满足标识符定义的规则、规范。 “见名知意”
 *  ④ 形参列表：在形参的位置可以定义一个或多个变量。
 *           格式：数据类型 变量1,数据类型 变量2,...
 *           赋值：形参在方法被调用时，赋值。赋的值，通常称为实参。
 *
 *        开发中定义方法的话，到底要不要定义形参列表呢？
 *              > 根据题目要求
 *              > 具体问题具体分析
 *  ⑤ 方法体：声明在方法结构的一对{}内。当方法被调用时，真正执行的逻辑。
 *
 *  3.说明：
 *  ① 方法内可以调用当前类的属性。执行方法时，属性的值即为调用当前方法的对象的属性值。
 *  ② 方法内可以调用当前类的(其他)方法。方法内不能定义方法
 *
 * 4. 如果一个方法声明时，有返回值类型（即：返回值类型位置不是void），则方法内部一定要使用return结构。
 *      格式 : return + 变量/常量。
 *      return 的作用： ① 结束方法:在方法体内，一旦执行了return，则跳出当前方法。
 *                     ② 结束方法的同时，可以返回一个变量或常量给方法的调用者。
 *
 *
 * 5. 匿名对象： 创建的对象没有声明一个具体的变量名。
 *    通常匿名对象只能使用一次。
 *
 * @author shkstart
 * @create 9:34
 */
public class UserTest {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int num = scan.nextInt();

        User u1 = new User();

        u1.name = "Tom";
        u1.age = 10;
        String info = u1.show();
        System.out.println(info);

        User u2 = new User();
        u2.name = "Jerry";
        System.out.println(u2.show());
        System.out.println("############");
        u1.eat();

        System.out.println("##########");
        UserTest test = new UserTest();
        User u3 = new User();
        u3.name = "Tonny";
        test.showUser(u3);
        System.out.println(u3);
        //匿名对象
        new User().name = "Kitty";//对象1

        new User().age = 10;//对象2

        test.showUser(new User());//通常见到的匿名对象的使用场景


    }


    public void showUser(User user){
        user.eat();
        System.out.println(user.show());
    }
}

class User{
    //1. 属性
    String name;//名字
    int age;//年龄

    //2. 方法
    public void eat(){
        System.out.println("用户吃饭");
        //eat();

//        walk();
//        System.out.println(show());


    }
    public void walk(){
        System.out.println("用户走路");

    }

    public String show(){
        return "name = " + name + ", age = " + age; //方法内可以调用当前类的属性
//        return 123;
    }

    public void sleep(int hour){
        System.out.println("每天睡眠" + hour + "个小时");
    }

    public double getAge(){
//        return age;
        return 1;
    }

    public void info(){
        if(age >= 18){
            System.out.println("成人了");
            return; //用于表示方法的结束
        }else{
            System.out.println("未成年");
        }
        System.out.println("执行结束");
    }

}
