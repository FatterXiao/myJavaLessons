package com.atguigu.java2;

import org.junit.Test;

import java.util.List;

/**
 * @author shkstart
 * @create 16:32
 */
public class GenericTest {
    @Test
    public void test1(){
        CustomerDAO dao = new CustomerDAO();

        List<Customer> list = dao.getForList();

        UserDAO dao1 = new UserDAO();
        List<User> list1 = dao1.getForList();

    }
}
