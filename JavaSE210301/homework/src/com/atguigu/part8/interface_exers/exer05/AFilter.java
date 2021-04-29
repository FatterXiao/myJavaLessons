package com.atguigu.part8.interface_exers.exer05;

public class AFilter implements Filter {
    @Override
    public void filterUser(User u) {
        u.setUserType("A");
    }
}
