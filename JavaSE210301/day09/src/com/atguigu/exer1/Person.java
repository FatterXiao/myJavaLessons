package com.atguigu.exer1;

/**
 * 创建程序,在其中定义两个类：Person和PersonTest类。定义如下：
 * 用setAge()设置人的合法年龄(0~130)，用getAge()返回人的年龄。
 *
 *
 * @author shkstart
 * @create 14:46
 */
public class Person {
    private int age;

    public void setAge(int i){
        if(i >= 0 && i <= 130){
            age = i;
        }
    }

    public int getAge(){
        return age;
    }
}
