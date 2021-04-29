package com.atguigu.myproject02;

/**
 * 封装客户信息
 */
public class Customer {

    private String name; //客户姓名
    private char gender; //性别
    private int age; //年龄
    private String phone; //电话号码
    private String email; //电子邮箱

    public Customer() {
    }

    /**
     *
     * @param name 姓名
     * @param gender 性别（男/女）
     * @param age 年龄
     * @param phone 电话
     * @param email 邮箱
     */
    public Customer(String name, char gender, int age, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 返回消费者的详细信息
     * @return
     */
    public String getDetial(){
        return name + "\t" + gender + "\t\t" + age + "\t\t\t" + phone + "\t\t" + email;
    }
}
