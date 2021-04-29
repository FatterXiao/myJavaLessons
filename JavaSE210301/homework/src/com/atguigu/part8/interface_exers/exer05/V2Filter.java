package com.atguigu.part8.interface_exers.exer05;

public class V2Filter implements Filter {
    @Override
    public void filterUser(User u) {
        u.setUserType("V2");
    }
}
