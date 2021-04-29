package com.atguigu.java;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author shkstart
 * @create 9:57
 */
public class TreeMapTest {

    @Test
    public void test1(){
        TreeMap map = new TreeMap();

        map.put("Tom",67);
        map.put("Jerry",76);
        map.put("Tonny",78);
        map.put("Jack",99);
        map.put("Jack",77);
        map.put("Alice",66);
//        map.put(87,66);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    //向TreeMap中添加key和value。要求key考虑：① 自然排序 或 ② 定制排序
    @Test
    public void test2(){
        TreeMap map = new TreeMap();

        User u1 = new User("Tom",34);
        User u2 = new User("Jerry",56);
        User u3 = new User("Jack",44);
        User u4 = new User("Alice",34);
        User u5 = new User("Rose",12);


        map.put(u1,89);
        map.put(u2,55);
        map.put(u3,34);
        map.put(u4,78);
        map.put(u5,88);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return u1.getAge() - u2.getAge();

                }
                throw new RuntimeException("输入的类型不匹配");
            }
        });

        User u1 = new User("Tom",34);
        User u2 = new User("Jerry",56);
        User u3 = new User("Jack",44);
        User u4 = new User("Alice",34);
        User u5 = new User("Rose",12);


        map.put(u1,89);
        map.put(u2,55);
        map.put(u3,34);
        map.put(u4,78);
        map.put(u5,88);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
