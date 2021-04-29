package com.atguigu.bookstore.service.impl;

import com.atguigu.bookstore.beans.User;
import com.atguigu.bookstore.dao.impl.UserDaoImpl;
import com.atguigu.bookstore.service.UserService;

/**
 * @author Mr.Helianthus
 * @create 2021-04-20 3:14 PM
 */
public class UserServiceImpl implements UserService {
    UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public User login(User user) {
        User user1 = userDao.checkUsernameAndPassword(user.getUsername(), user.getPassword());
        return user1;
    }

    @Override
    public boolean regist(User user) {
        boolean b = userDao.checkUsername(user.getUsername());
        return b;
    }

    @Override

    public void addUser(User user) {
        int i = userDao.addUser(user.getUsername(), user.getPassword(), user.getEmail());
    }
}
