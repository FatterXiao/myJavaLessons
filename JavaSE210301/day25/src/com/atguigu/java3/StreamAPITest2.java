package com.atguigu.java3;

import com.atguigu.java1.Employee;
import com.atguigu.java1.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Stream的终止操作
 *
 * @author shkstart
 */
public class StreamAPITest2 {

    //1-匹配与查找
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

//        allMatch(Predicate p)——检查是否匹配所有元素。
//          练习：是否所有的员工的年龄都大于18
        System.out.println(employees.stream().allMatch(e -> e.getAge() > 18));

//        anyMatch(Predicate p)——检查是否至少匹配一个元素。
//         练习：是否存在员工的工资大于 10000
        System.out.println(employees.stream().anyMatch(e -> e.getSalary() > 10000));

//        findFirst——返回第一个元素
        Optional<Employee> optional = employees.stream().filter(e -> e.getSalary() > 8000).findFirst();
        System.out.println(optional.get());


    }

    @Test
    public void test2(){
        List<Employee> employees = EmployeeData.getEmployees();
        // count——返回流中元素的总个数
        System.out.println(employees.stream().filter(e -> e.getSalary() > 8000).count());
//        max(Comparator c)——返回流中最大值
//        练习：返回最高的工资的员工：
        System.out.println(employees.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).get());
        //练习：返回最高的工资
//        System.out.println(employees.stream().map(Employee::getSalary).max(Double::compareTo).get());
        System.out.println(employees.stream().map(e->e.getSalary()).max((s1,s2)->Double.compare(s1,s2)).get());

        //        min(Comparator c)——返回流中最小值
//        练习：返回最低工资的员工
        System.out.println(employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).get());
//        forEach(Consumer c)——内部迭代
        EmployeeData.getEmployees().stream().filter(e -> e.getName().length() > 3).forEach(System.out::println);

        System.out.println();
        List<Employee> list1 = EmployeeData.getEmployees();
        list1.forEach(System.out::println);

    }

    //2-归约
    @Test
    public void test3(){
//        reduce(T identity, BinaryOperator)——可以将流中元素反复结合起来，得到一个值。返回 T
//        练习1：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list.stream().reduce(0, (x1, x2) -> x1 + x2));

//        reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
//        练习2：计算公司所有员工工资的总和
//        System.out.println(EmployeeData.getEmployees().stream().map(e -> e.getSalary()).reduce((s1,s2) -> s1 + s2));
        System.out.println(EmployeeData.getEmployees().stream().map(Employee::getSalary).reduce(Double::sum));
    }

    //3-收集
    @Test
    public void test4(){
//        collect(Collector c)——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
//        练习1：查找工资大于6000的员工，结果返回为一个List或Set

        List<Employee> list = EmployeeData.getEmployees();
        List<Employee> list1 = list.stream().filter(e -> e.getSalary() > 7000).collect(Collectors.toList());

        list1.forEach(System.out::println);
        System.out.println();
        list.forEach(System.out::println);


    }
}
