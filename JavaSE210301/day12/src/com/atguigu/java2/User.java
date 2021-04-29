package com.atguigu.java2;

/**
 * @author shkstart
 * @create 14:39
 */
public class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    //手写的：
//    @Override
//    public boolean equals(Object obj) {
//        if(this == obj){
//            return true;
//        }
//        if(obj instanceof User){
//            User u = (User)obj;
//            //比较两个对象的属性是否都相等
////            if(this.age == u.age && this.name.equals(u.name)){
////                return true;
////            }
////            return false;
//
//            //简化为：
//            return this.age == u.age && this.name.equals(u.name);
//        }
//
//        return false;
//    }


    //自动生成:
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

//    @Override
//    public String toString() {
//        return "User{ name : " + name + ",age : " + age +"}";
//    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
