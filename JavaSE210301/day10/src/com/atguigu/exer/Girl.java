package com.atguigu.exer;

/**
 * @author shkstart
 * @create 10:29
 */
public class Girl {
    private String name;
    private int age;

    public Girl() {
    }

    public Girl(String name, int age) {
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

    public void marry(Boy boy){
        System.out.println("我是" + name + ",我想嫁给" + boy.getName());
//        boy.marry(new Girl());

        boy.marry(this);
    }

    /**
     * 比较两个对象大小的方法
     * @param girl
     * @return 正数：当前对象大； 0：一样大； 负数：形参对象大
     */
    public int compare(Girl girl){
        if(this.age > girl.age){
            return 1;
        }else if(this.age == girl.age){
            return 0;
        }else{
            return -1;
        }
    }
}
