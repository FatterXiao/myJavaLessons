package com.atguigu.java3;

import com.atguigu.java1.Employee;
import com.atguigu.java1.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 *
 * @author shkstart
 */
public class StreamAPITest1 {

    //1-筛选与切片
    @Test
    public void test1() {
//        filter(Predicate p)——接收 Lambda ， 从流中排除某些元素。
        //练习：查询员工表中薪资大于7000的员工信息
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();

//        stream.filter(e -> e.getSalary() > 7000).forEach(e -> System.out.println(e));
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

//        limit(n)——截断流，使其元素不超过给定数量。
        System.out.println();
        Stream<Employee> stream1 = list.stream();
        stream1.limit(3).forEach(System.out::println);

//        skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        System.out.println();
        Stream<Employee> stream2 = list.stream();
        stream2.skip(5).forEach(System.out::println);

        System.out.println();
//        distinct()——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        list.add(new Employee(1009, "马斯克", 37, 1));
        list.add(new Employee(1009, "马斯克", 37, 1));
        list.add(new Employee(1009, "马斯克", 37, 1));
        list.add(new Employee(1009, "马斯克", 37, 1));

        list.stream().distinct().forEach(System.out::println);

    }

    //映射
    @Test
    public void test2() {
        //map(Function f)——接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        //练习：转换为大写
        list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);

        System.out.println();
        //练习：获取员工姓名长度大于3的员工。
        EmployeeData.getEmployees().stream().filter(e -> e.getName().length() > 3).forEach(System.out::println);
        System.out.println();
        //练习：获取员工姓名长度大于3的员工的姓名。
//        EmployeeData.getEmployees().stream().filter(e -> e.getName().length() > 3).map(Employee::getName).forEach(System.out::println);
        EmployeeData.getEmployees().stream().map(e->e.getName()).filter(s -> s.length() > 3).forEach(System.out::println);

    }

    //3-排序
    @Test
    public void test3() {
        //sorted()——自然排序
        Integer[] arr = new Integer[]{343,475,3,65,3,43,56,67,343};

        Stream<Integer> stream = Arrays.stream(arr);
        stream.sorted().forEach(System.out::println);

        //报错，因为Employee类没有实现Comparable
//        EmployeeData.getEmployees().stream().sorted().forEach(System.out::println);

        //sorted(Comparator com)——定制排序
        EmployeeData.getEmployees().stream().sorted((e1,e2) -> Integer.compare(e1.getAge(),e2.getAge())).forEach(System.out::println);

//        System.out.println(EmployeeData.getEmployees());
    }
}
