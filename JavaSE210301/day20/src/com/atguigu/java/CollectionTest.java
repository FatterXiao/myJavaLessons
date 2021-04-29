package com.atguigu.java;

import org.junit.Test;

import java.io.Serializable;
import java.util.*;

/**
 * 测试Collection中的常用方法
 *
 *
 * 结论：向Collection集合中添加的元素，要求元素所属的类必须重写equals()
 *
 *
 * 三个层面（递进关系）
 *  * 层次一：掌握不同接口的主要实现类的实例化，及常用方法 （ArrayList\HashSet\HashMap）
 *  * 层次二：掌握不同实现类之间的区别
 *  * 层次三：常用的集合类的底层实现原理--->数据结构。 （ArrayList\LinkedList\HashMap）
 *
 * @author shkstart
 * @create 8:57
 */
public class CollectionTest {

    @Test
    public void test1(){
        //1. add(Object obj):将obj元素添加到Collection中
        Collection coll1 = new ArrayList();

        coll1.add(123);//自动装箱
        coll1.add("AA");
        coll1.add(new Date());

        //2. size():获取集合中元素的个数
        System.out.println(coll1.size());

        //3. addAll(Collection coll2):将coll2中的元素都添加到当前集合中
        Collection coll2 = new ArrayList();
        coll2.add(456);
        coll2.add("BB");
        coll2.add("AA");

        coll1.addAll(coll2);

        System.out.println(coll1.size());//6
        System.out.println(coll1);

        //5. clear():清空集合中的元素
        coll1.clear(); //与coll1 = null;不同

        //4. isEmpty():是否为空
        System.out.println(coll1.isEmpty());
        System.out.println(coll1.size());
    }

    @Test
    public void test2(){
        Collection coll1 = new ArrayList();

        coll1.add(123);//自动装箱
        coll1.add(new String("AA"));
        coll1.add(new Date());
        coll1.add(123);//自动装箱
        coll1.add(new Person("Tom",12));

        //6. contains(Object obj):判断当前集合中是否包含元素obj
        System.out.println(coll1.contains(123));//true
        System.out.println(coll1.contains(new String("AA")));//true

        System.out.println(coll1.contains(new Person("Tom",12)));//false --> true

        //7. constainsAll(Collection coll2):判断当前集合中是否包含coll2中的所有元素
        Collection coll2 = new ArrayList();
//        coll2.add(456);
//        coll2.add("BB");
        coll2.add("AA");
        coll2.add(new Integer(123));

        System.out.println(coll1.containsAll(coll2));

        //8.remove(Object obj):删除集合中的obj元素
//        System.out.println(coll1);
//        coll1.remove(123);
//        System.out.println(coll1);

        //9. removeAll(Collection coll2):差集，从当前集合中删除掉其与coll2共有的元素
        System.out.println(coll1);
        coll1.removeAll(coll2);
        System.out.println(coll1);


    }

    @Test
    public void test3(){
        Collection coll1 = new ArrayList();

        coll1.add(123);//自动装箱
        coll1.add(new String("AA"));
        coll1.add(123);//自动装箱
        coll1.add(new Person("Tom",12));

        //10.retainAll(Collection coll2):
//        Collection coll2 = new ArrayList();
//        coll2.add("AA");
//        coll2.add(new Integer(123));
//
//        coll1.retainAll(coll2);//交集：获取当前集合与coll2共有的元素
//        System.out.println(coll1);

        //11.equals(Object obj):判断两个元素是否相等
        Collection coll3 = new ArrayList();
        coll3.add(new String("AA"));
        coll3.add(123);//自动装箱
        coll3.add(123);//自动装箱
        coll3.add(new Person("Tom",12));
        System.out.println(coll1.equals(coll3));

        //12. hashCode():返回当前对象的哈希值
        System.out.println(coll1.hashCode());

        //13. Object[] toArray():将集合转换为数组
        Object[] arr = coll1.toArray();
        System.out.println(Arrays.toString(arr));

        //数组-->集合：调用Arrays工具类的asList(Object ... objs)
        Object[] arr1 = new Object[]{123,"AA",new Date()};
        List<Object> list = Arrays.asList(arr1);
        System.out.println(list);

        List list1 = Arrays.asList(123, "AA", new Date());
        System.out.println(list1);

    }

}
