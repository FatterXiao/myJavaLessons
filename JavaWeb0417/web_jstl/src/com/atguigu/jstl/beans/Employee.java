package com.atguigu.jstl.beans;

public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Department dept;

    public Employee() {
    }

    public Employee(Integer id, String lastName, String email, Department dept) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        System.out.println("getLastName被调用");
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "com.atguigu.el.Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dept=" + dept +
                '}';
    }

    public int getAge(){
        return 23;
    }

    public boolean isMarried(){
        return true;
    }
}
