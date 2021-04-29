package com.atguigu.java2;

import org.junit.Test;

import java.util.*;

/**
 * 一、框架
 *  java.util.Map:存储一对一对的数据 (key-value) ----> 高中学的"函数" y = f(x)   y = 2 * x + 1 (x1,y1),(x2,y2)
 *       |---- HashMap:Map的主要实现类
 *         |---- LinkedHashMap
 *         |---- TreeMap
 *         |---- Hashtable
 *         |---- Properties
 *
 * 二、Map的理解：(主要针对的是HashMap)
 *   Map中的所有的key彼此是不可重复的、是无序的。所有的key构成的集合是一个Set  --->要求key所在的类要重写equals()和hashCode()
 *   Map中的所有的value彼此是可重复的、是无序的。所有的value构成的集合是一个Collection  --->要求value所在的类要重写equals()
 *   Map中的一个key-value构成一个entry，作为entry的两个属性出现的。
 *   Map中的所有的Entry彼此是不可重复的、是无序的。所有的entry构成的集合是一个Set
 *
 *
 * @author shkstart
 * @create 16:04
 */
public class MapTest {
    /*
    添加、删除、修改操作：



    元素查询的操作：


    元视图操作的方法：




     */
    @Test
    public void test1(){
        HashMap map = new HashMap();

        //1. 添加\修改：Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
        map.put("Tom",67);
        map.put(56,"AA");
        map.put(null,"AA");
        map.put(67,null);
        map.put("Tim",78);
        map.put("Tim",98);

        //2. int size()：返回map中key-value对的个数
        System.out.println(map.size());

        System.out.println(map);

        //3. Object remove(Object key)：移除指定key的key-value对，并返回value
        map.remove(67);
        System.out.println(map);

        //4. void clear()：清空当前map中的所有数据
        map.clear();

        //5. boolean isEmpty()：判断当前map是否为空
        System.out.println(map.isEmpty());

    }

    @Test
    public void test2(){
        HashMap map = new HashMap();
        map.put("Tom",67);
        map.put(56,"AA");
        map.put(null,"AA");
        map.put(67,null);
        map.put("Tim",78);

        //6. Object get(Object key)：获取指定key对应的value
        Object value = map.get(566);
        System.out.println(value);

        //boolean containsKey(Object key)：是否包含指定的key
        System.out.println(map.containsKey("Tom"));
        //    boolean containsValue(Object value)：是否包含指定的value
        System.out.println(map.containsValue("AA"));

    }

    @Test
    public void test3(){
        HashMap map = new HashMap();
        map.put("Tom",67);
        map.put(56,"AA");
        map.put(null,"AA");
        map.put(67,null);
        map.put("Tim",78);

        //Set keySet()：返回所有key构成的Set集合
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println();

        //Collection values()：返回所有value构成的Collection集合
        Collection values = map.values();
        Iterator iterator1 = values.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        System.out.println();

        //Set entrySet()：返回所有key-value对构成的Set集合
        Set entrySet = map.entrySet();
        Iterator iterator2 = entrySet.iterator();
        while(iterator2.hasNext()){
            Map.Entry entry = (Map.Entry) iterator2.next();
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

        System.out.println("*****");
        Set set1 = map.keySet();
        Iterator iterator3 = set.iterator();
        while(iterator3.hasNext()){
            Object key = iterator3.next();
            System.out.println(key + "******" + map.get(key));

        }
    }

}
