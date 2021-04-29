package com.atguigu.java2;

import com.atguigu.java1.Employee;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *      格式： 类名 :: new
 *
 * 二、数组引用
 *      格式： 数组元素类型[] :: new
 *
 * Created by shkstart
 */
public class ConstructorRefTest {
	//构造器引用
    //Supplier中的T get()
    @Test
    public void test1(){
        Supplier<Employee> sup1 = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };

        //
        Supplier<Employee> sup2 = () -> new Employee();

        //
        Supplier<Employee> sup3 = Employee::new;
    }

	//Function中的R apply(T t)
    @Test
    public void test2(){
        //1
        Function<Integer,Employee> func1 = new Function<Integer, Employee>() {
            @Override
            public Employee apply(Integer id) {
                return new Employee(id);
            }
        };

        //2
        Function<Integer,Employee> func2 = id -> new Employee(id);

        //3
        Function<Integer,Employee> func3 = Employee::new;

        Employee employee = func3.apply(12);
        System.out.println(employee);
    }

	//BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){
        //1
        BiFunction<Integer,String,Employee> bi1 = new BiFunction<Integer, String, Employee>() {
            @Override
            public Employee apply(Integer id, String name) {
                return new Employee(id,name);
            }
        };
        //2
        BiFunction<Integer,String,Employee> bi2 = (id,name)-> new Employee(id,name);
        //3.
        BiFunction<Integer,String,Employee> bi3 = Employee::new;
    }

	//数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
        //1.
        Function<Integer,int[]> func1 = new Function<Integer, int[]>() {
            @Override
            public int[] apply(Integer length) {
                return new int[length];
            }
        };
        //2.
        Function<Integer,int[]> func2 = length -> new int[length];

        //3.
        Function<Integer,int[]> func3 = int[] :: new;
        func3.apply(10);

        //另一组：
        Function<Integer,Employee[]> func4 = (length) -> new Employee[length];

        Function<Integer,Employee[]> func5 = Employee[] :: new;

    }
}
