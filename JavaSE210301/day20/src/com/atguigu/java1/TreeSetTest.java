package com.atguigu.java1;

import com.sun.corba.se.impl.orb.ParserTable;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author shkstart
 * @create 15:31
 */
public class TreeSetTest {

    @Test
    public void test1(){
        TreeSet set = new TreeSet();

        set.add("CC");
//        set.add(123);
        set.add("AA");
        set.add("DD");
        set.add("MM");
        set.add("GG");
        set.add("JJ");

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        TreeSet set = new TreeSet();

        Person p1 = new Person("Tom",12);
        Person p2 = new Person("Jack",34);
        Person p3 = new Person("Rose",2);
        Person p4 = new Person("Jerry",43);
        Person p5 = new Person("Tommy",22);
        Person p6 = new Person("Tony",12);

        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        set.add(p5);
        set.add(p6);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //定制排序
    @Test
    public void test3(){
        Comparator comparator =  new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person)o1;
                    Person p2 = (Person)o2;
                    return p1.getName().compareTo(p2.getName());
                }
                throw new RuntimeException("输入的类型不匹配");
            }
        };
        TreeSet set = new TreeSet(comparator); //类比：Arrays.sort(arr,comparator)

        Person p1 = new Person("Tom",12);
        Person p2 = new Person("Jack",34);
        Person p3 = new Person("Rose",2);
        Person p4 = new Person("Jerry",43);
        Person p5 = new Person("Tommy",22);
        Person p6 = new Person("Tony",12);

        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        set.add(p5);
        set.add(p6);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
