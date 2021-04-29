package com.atguigu.exam;

import java.util.Comparator;

/**
 * @author shkstart
 * @create 9:26
 */
public class ComparatorTest {
    public static void main(String[] args) {

        //
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return -p1.name.compareTo(p2.name);
                }
                throw new RuntimeException("输入的类型不匹配");
            }
        };


    }
}
