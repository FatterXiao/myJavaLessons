package com.atguigu.day20.exer_doc;

import com.sun.xml.internal.ws.message.EmptyMessageImpl;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Mr.Helianthus
 * @create 2021-03-29 7:28 PM
 */
public class Test {
    public static void main(String[] args) {
//        impByComparable();
        impByComparator();
    }

    /**
     * 通过Comparable接口实现
     */
    public static void impByComparable(){
        // 1. 初始化数组
        Employee[] employees = new Employee[5];
        for (int i = 0; i < employees.length; i++) {
            MyDate myDate = new MyDate(2000+i,5 + i,20+i);
            Employee employee = new Employee("Tom"+i,10+i,myDate);
            employees[i] = employee;
        }

        // 2. 向TreeSet中添加元素
        TreeSet treeSet = new TreeSet<>();
        for(Employee emp : employees){
            treeSet.add(emp);
        }
        // 3. 遍历打印TreeSet中的元素
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }


    /**
     * 通过比较器实现
     */
    public static void impByComparator(){
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee){
                    Employee emp1 = (Employee)o1;
                    Employee emp2 = (Employee)o2;
                    return emp1.getBirthday().compareTo(emp2.getBirthday());
                }
                throw new RuntimeException("输入类型错误");
            }
        };

        // 1. 初始化数组
        Employee[] employees = new Employee[5];
        for (int i = 0; i < employees.length; i++) {
            MyDate myDate = new MyDate(2000+i,5 + i,20+i);
            Employee employee = new Employee("Tom"+i,10+i,myDate);
            employees[i] = employee;
        }

        // 2. 向TreeSet中添加元素,并添加比较器
        TreeSet treeSet = new TreeSet<>(comparator);
        for(Employee emp : employees){
            treeSet.add(emp);
        }

        // 3. 遍历打印TreeSet中的元素
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
