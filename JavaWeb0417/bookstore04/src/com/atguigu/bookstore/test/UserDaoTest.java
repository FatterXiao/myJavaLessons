package com.atguigu.bookstore.test;

import com.atguigu.bookstore.beans.User;
import com.atguigu.bookstore.dao.impl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mr.Helianthus
 * @create 2021-04-20 3:01 PM
 */
public class UserDaoTest {
    UserDaoImpl userDao = new UserDaoImpl();
    @Test
    public void checkUsernameAndPassword() {
        User admin = userDao.checkUsernameAndPassword("admin", "123456");
        System.out.println(admin);
    }

    @Test
    public void checkUsername() {
        boolean isExist = userDao.checkUsername("admin2");
        System.out.println(isExist);

    }

    @Test
    public void addUser() {
        int count = userDao.addUser("xuweijun", "123456", "xuweijunxinlan@yeah.net");
        System.out.println(count);


    }
}