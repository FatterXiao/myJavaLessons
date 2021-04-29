package com.atguigu.java3;

import com.atguigu.java1.Employee;
import com.atguigu.java1.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1. Stream关注的是对数据的运算，与CPU打交道
 *    集合关注的是数据的存储，与内存打交道
 *    小结：Stream针对内存中的多个数据进行的操作，所有Stream API 与集合（或数组）是合作关系。
 *
 * 2.
 * ①Stream 自己不会存储元素。
 * ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 *
 * 3.Stream 执行流程
 * ① Stream的实例化
 * ② 一系列的中间操作（过滤、映射、...)
 * ③ 终止操作
 *
 * 4.说明：
 * 4.1 一个中间操作链，对数据源的数据进行处理
 * 4.2 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 *
 *
 *  测试Stream的实例化
 *
 * @author shkstart
 */
public class StreamAPITest {

    //创建 Stream方式一：通过集合
    @Test
    public void test1(){

//        default Stream<E> stream() : 返回一个顺序流
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();

//        default Stream<E> parallelStream() : 返回一个并行流
        List<Employee> list1 = EmployeeData.getEmployees();
        Stream<Employee> stream1 = list1.parallelStream();

    }

    //创建 Stream方式二：通过数组
    @Test
    public void test2(){
        //调用Arrays类的static <T> Stream<T> stream(T[] array): 返回一个流
        Integer[] arr = new Integer[]{1,2,2,3,4};

        Stream<Integer> stream = Arrays.stream(arr);

        IntStream stream1 = Arrays.stream(new int[]{1, 2, 3, 4, 5});



    }
    //创建 Stream方式三：通过Stream的of()
    @Test
    public void test3(){
        Employee e1 = new Employee(1003, "刘强东", 33, 3000.82);
        Employee e2 = new Employee(1004, "雷军", 26, 7657.37);
        Stream<Employee> stream = Stream.of(e1, e2);

    }
    

}
