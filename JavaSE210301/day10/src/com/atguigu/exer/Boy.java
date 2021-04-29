package com.atguigu.exer;

/**
 * @author shkstart
 * @create 10:24
 */
public class Boy {
    private String name;
    private int age;

    public Boy() {
    }

    public Boy(String name, int age) {
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

    public void shout(){
        if(this.age >= 22){
            System.out.println("我已经到了法定可以结婚的年龄");
        }else{
            System.out.println("先谈谈恋爱~~");
        }
    }

    public void marry(Girl girl){
        System.out.println("我是" + name + ",我想娶" + girl.getName());
    }
}
