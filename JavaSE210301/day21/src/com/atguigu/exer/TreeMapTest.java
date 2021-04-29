package com.atguigu.exer;

import org.junit.Test;

import java.util.*;

/**
 * @author shkstart
 * @create 9:57
 */
public class TreeMapTest {


    //向TreeMap中添加key和value。要求key考虑：① 自然排序 或 ② 定制排序
    @Test
    public void test2() {
        TreeMap<User, Integer> map = new TreeMap<User, Integer>();

        User u1 = new User("Tom", 34);
        User u2 = new User("Jerry", 56);
        User u3 = new User("Jack", 44);
        User u4 = new User("Alice", 34);
        User u5 = new User("Rose", 12);


        map.put(u1, 89);
        map.put(u2, 55);
        map.put(u3, 34);
        map.put(u4, 78);
        map.put(u5, 88);

        Set<Map.Entry<User, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<User, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3() {
        TreeMap<User, Integer> map = new TreeMap<>(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getAge() - u2.getAge();
            }
        });

        User u1 = new User("Tom", 34);
        User u2 = new User("Jerry", 56);
        User u3 = new User("Jack", 44);
        User u4 = new User("Alice", 34);
        User u5 = new User("Rose", 12);


        map.put(u1, 89);
        map.put(u2, 55);
        map.put(u3, 34);
        map.put(u4, 78);
        map.put(u5, 88);

        Set<Map.Entry<User, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<User, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
