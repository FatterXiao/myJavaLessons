package com.atguigu.java1;

import org.junit.Test;

import java.util.*;


/**
 * 1. 为什么要使用泛型？
 * 2. 掌握：集合中使用泛型： ArrayList \ HashMap \ Comparable \ Comparator
 * 3. 熟悉：自定义泛型类、泛型接口、泛型方法
 * 4. 掌握：泛型在继承上的体现
 * 5. 掌握：通配符的使用
 *
 *
 *
 * @author shkstart
 * @create 14:39
 */
public class GenericTest {

    //1.在集合中使用泛型之前的例子
    @Test
    public void test1(){
        List list = new ArrayList();

        list.add(68);
        list.add(54);
        list.add(88);
        list.add(99);
        //问题一：添加数据时，没有类型的校验，导致数据添加不安全。
//        list.add("AA");


        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            //问题二：可能导致类型转换异常。
            int score = (int) obj;
            System.out.println(score);

        }

    }

    //2. 在集合中使用泛型的例子
    //说明1：泛型参数赋的实参只能是引用数据类型。
    //说明2：在实例化集合类时，指名了泛型的参数类型（比如：Integer)。则集合类内部的属性、方法、构造器中凡是使用类的泛型的位置
    //  都替换为具体的泛型的参数类型（比如：Integer)。
    //说明3：在使用泛型类或泛型接口时，没有指明类或接口的泛型参数，则默认将此类型理解为Object类型。
    @Test
    public void test2(){
//        List<int> list = new ArrayList<int>();//报错
        ArrayList<Integer> list = new ArrayList<>();//类型推断

        list.add(67);
        list.add(65);
        list.add(78);
        //编译不通过
//        list.add("AA");

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            //不会出现类型转换异常
            int score = iterator.next();
            System.out.println(score);
        }

    }

    @Test
    public void test3(){
//        Map<String,Integer> map = new HashMap<String,Integer>();
        Map<String,Integer> map = new HashMap<>();

        map.put("Tom",67);
        map.put("Jack",77);
        map.put("Rose",89);
//        map.put(45,"Jerry");//编译不通过

        //keySet():
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key);
        }

        //values():
        Collection<Integer> values = map.values();

        //entrySet():
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator1 = entrySet.iterator();
        while(iterator1.hasNext()){
            Map.Entry<String,Integer> entry = iterator1.next();
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

    }

    //练习：我们发现Comparable 和 Comparator 是泛型接口。
}
