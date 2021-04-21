package com.atguigu.service.imp;

import com.atguigu.bookstore.dao.UserDao;
import com.atguigu.bookstore.dao.imp.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

/**
 * @author Mr.Helianthus
 * @create 2021-04-20 9:04 PM
 */
public class UserServiceImp implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public User login(User user) {
        User user1 = userDao.checkedUsernameAndPassword(user.getUsername(), user.getPassword());
        return user1;
    }

    @Override
    public boolean isRegist(User user) {
        boolean b = userDao.checkedUsername(user.getUsername());
        return b;
    }

    @Override
    public void registUser(User user) {
        userDao.addUser(user.getUsername(),user.getPassword(),user.getEmail());

    }
}
