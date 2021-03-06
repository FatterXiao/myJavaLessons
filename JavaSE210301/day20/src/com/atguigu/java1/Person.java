package com.atguigu.java1;

import java.util.Comparator;

public class Person implements Comparable {
	private String name;
	private int age;
	public Person() {
		super();
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public boolean equals(Object o) {
		System.out.println("Person equals()....");
		if (this == o) return true;
		if (!(o instanceof Person)) return false;

		Person person = (Person) o;

		if (age != person.age) return false;
		return name != null ? name.equals(person.name) : person.name == null;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + age;
		return result;
	}

	//指名排序方式：年龄从小到大
	@Override
	public int compareTo(Object o) {
//		if(o instanceof Person){
//			Person p = (Person)o;
//			return this.age - p.age;
//		}
//		throw new RuntimeException("输入的类型不匹配");

		if(o instanceof Person){
			Person p = (Person)o;
			int ageValue= this.age - p.age;
			if(ageValue != 0){
				return ageValue;
			}
			return this.name.compareTo(p.name);

		}
		throw new RuntimeException("输入的类型不匹配");
	}
}
