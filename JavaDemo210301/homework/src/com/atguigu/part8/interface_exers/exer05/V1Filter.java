package com.atguigu.part8.interface_exers.exer05;

public class V1Filter implements Filter {
    @Override
    public void filterUser(User u) {
        u.setUserType("v1");
    }
}
