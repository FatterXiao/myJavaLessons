package com.atguigu.bookstore.dao.impl;

import com.atguigu.bookstore.beans.User;
import com.atguigu.bookstore.dao.BaseDao;
import com.atguigu.bookstore.dao.UserDao;

/**
 * @author Mr.Helianthus
 * @create 2021-04-20 1:49 PM
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {

    @Override
    public User checkUsernameAndPassword(String username, String password) {
        String sql = "SELECT id,username,password,email FROM users WHERE username=? AND password=?";
        User bean = getBean(sql, username, password);
        return bean;
    }

    @Override
    public boolean checkUsername(String username) {
        String sql = "SELECT id,username,password,email FROM users WHERE username=?";
        User user = getBean(sql, username);
        return user != null;
    }

    @Override
    public int addUser(String username, String password, String email) {
        String sql = "INSERT INTO users(username,password,email) VALUES(?,?,?) ";
        int update = update(sql, username, password, email);
        return update;
    }
}
