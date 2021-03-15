package com.atguigu.java;

import com.atguigu.exer.Boy;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 1. package: 包
 *  > 便于针对于大量创建的类进行统一的管理。
 *  > 包，属于标识符，遵循标识符命名的规则、规范(xxxyyyzzz)、“见名知意”
 *  > 包，声明在Java源文件中的首行。
 *  > 包的声明中每"."一次，代表一层文件目录
 *
 *
 *
 * 2. import:导入
 *   > 我们在现有的java源文件中，可以导入其他源文件中声明的结构：类、接口
 *   > 通常import结构声明在 package下，类的声明前。
 *   > 导入的类或接口等，需要写明其完整的结构。比如：import com.atguigu.java.User;
 *   > 一方面，针对于java提供好的api，如果使用的结构来自于java.lang包，则可以声明import导入。
 *     如果来自于其他的包，则必须显式的导入
 *   > 另一方面，如果导入的其他源文件中的结构，与当前源文件在同一个包下，则可以声明省略显式的导入
 *   > 如果有多条import 导入结构，则先后声明即可。没有先后顺序之说。
 *   > 举例：使用import java.util.* 可以表示将util包下的所有类或接口进行导入。
 *   > 如果我们导入指定a包下的*,则a包的子包中的结构是不包含在导入内。如果需要，还得显式导入
 *   > 如果在文件中使用了不同包下的同名的类，则至少有一个类需要使用全类名的方式表示。比如：两个Date
 *
 *
 * 3. 拓展：
 *    同一个包下不能定义同名的类
 *    不同包下，可以定义同名的类
 *
 * @author shkstart
 * @create 11:14
 */
public class PackageImportTest {
    public static void main(String[] args) {
        User u1 = new User();
        String s = "hello";
        Scanner scann = new Scanner(System.in);

        Boy boy = new Boy();

        List list = new ArrayList();
        Map map = new HashMap();

        Field filed = null;

        Date date1 = null;
        java.sql.Date date2 = null;

        System.out.println(u1);
    }
}
