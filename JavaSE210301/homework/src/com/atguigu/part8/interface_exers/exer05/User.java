package com.atguigu.part8.interface_exers.exer05;

public class User {
    private String userType;
    private int userID;



    public User(String userType, int userID) {
        super();
        this.userType = userType;
        this.userID = userID;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "User{" +
                "userType='" + userType + '\'' +
                ", userID=" + userID +
                '}';
    }
}
