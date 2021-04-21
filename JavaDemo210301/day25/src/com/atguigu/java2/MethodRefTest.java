package com.atguigu.java2;

import com.atguigu.java1.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *
 * 1. 方法引用，可以理解为对lambda表达式的进一步表达。
 *
 * 2. 方法引用的本质：作为函数式接口的匿名实现类的对象出现
 *
 * 3. 举例：Integer::compare
 *
 * 4. 格式： 类(或对象) :: 方法名
 *
 * 5. 使用
 *   	情况一：对象 :: 实例方法
 *   		说明：接口中要重写的方法a的形参列表(参数个数、参数类型)与返回值类型 与 重写的方法a的方法体中调用的另外的一个方法b的形参列表与返回值类型完全相同。
 *   	        同时，方法b是一个非静态的方法。
 *
 *      情况二：类 :: 静态方法
 *      	说明：接口中要重写的方法a的形参列表(参数个数、参数类型)与返回值类型 与 重写的方法a的方法体中调用的另外的一个方法b的形参列表与返回值类型完全相同。
 *  *   	        同时，方法b是一个静态的方法。
 *
 *      情况三：类 :: 实例方法 （难）
 *			说明：接口中要重写的方法a的返回值类型 与 重写的方法a的方法体中调用的另外的一个方法b的返回值类型相同；
 *		          接口中要重写的方法a的形参个数为n,且 重写的方法a的方法体中调用的另外的一个方法b的形参个数必须为n-1。
 *		          且 方法a的形参列表中的第1个参数作为方法b的调用者，且方法a的形参列表中的除第1个参数外的其他参数类型依次与方法b的形参类型一致。
 *
 *
 * Created by shkstart.
 */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	//Consumer中的void accept(T t)
	//PrintStream中的void println(T t)
	@Test
	public void test1() {
		//方式1：传统的写法
		Consumer<String> con1 = new Consumer<String>() {
			@Override
			public void accept(String s) {
				PrintStream ps = System.out;
				ps.println(s);
			}
		};

		//方式2：lambda表达式
		Consumer<String> con2 = s -> System.out.println(s);

		//方式3：方法引用
		PrintStream ps = System.out;
		Consumer<String> con3 = ps :: println;

		con1.accept("我爱北京天安门");
		con3.accept("我爱北京天安门");

	}
	
	//Supplier中的T get()
	//Employee中的String getName()
	@Test
	public void test2() {
		Employee emp = new Employee(1001, "马化腾", 34, 6000.38);
		//方式1：
		Supplier<String> s1 = new Supplier<String>() {
			@Override
			public String get() {
				return emp.getName();
			}
		};

		//方式2：
		Supplier<String> s2 = () -> emp.getName();

		//方式3：方法引用
		Supplier<String> s3 = emp :: getName;


	}

	// 情况二：类 :: 静态方法
	//Comparator中的int compare(T t1,T t2)
	//Integer中的int compare(T t1,T t2)
	@Test
	public void test3() {
		//方式1：lambda表达式
		Comparator<Integer> com1 = (t1,t2) -> Integer.compare(t1,t2);

		//方式2：方法引用
		Comparator<Integer> com2 = Integer::compare;
		com2.compare(12,32);
	}
	
	//Function中的R apply(T t)
	//Math中的Long round(Double d)
	@Test
	public void test4() {
		//方式1：
		Function<Double,Long> func1  = new Function<Double, Long>() {
			@Override
			public Long apply(Double aDouble) {
				//。。。。
				return Math.round(aDouble);
			}
		};
		//方式2：
		Function<Double,Long> func2 = d -> Math.round(d);

		//方式3：
		Function<Double,Long> func3 = Math::round;
		func3.apply(123.3);

	}

	// 情况三：类 :: 实例方法 
	// Comparator中的int comapre(T t1,T t2)
	// String中的int t1.compareTo(t2)
	@Test
	public void test5() {
		//方式1：lambda表达式
		Comparator<String> com1 = (s1,s2) -> s1.compareTo(s2);

		int compare = com1.compare("abc", "abf");
		System.out.println(compare);

		//方式2：方法引用
		Comparator<String> com2 = String ::compareTo;
		compare = com2.compare("abc", "abf");
		System.out.println(compare);
	}

	//BiPredicate中的boolean test(T t1, T t2);
	//String中的boolean t1.equals(t2)
	@Test
	public void test6() {
		//方式1：lambda表达式
		BiPredicate<String,String> bi1 = (s1,s2) -> s1.equals(s2);

		//方式2：方法引用
		BiPredicate<String,String> bi2 = String ::equals;
	}
	
	// Function中的R apply(T t)
	// Employee中的String getName();
	@Test
	public void test7() {
		//方式1：lambda表达式
		Function<Employee,String> func1 = emp -> emp.getName();
		Employee emp = new Employee(1001, "马化腾", 34, 6000.38);
		System.out.println(func1.apply(emp));

		//方式2：方法引用
		Function<Employee,String> func2 = Employee::getName;
		System.out.println(func2.apply(emp));
	}

}
