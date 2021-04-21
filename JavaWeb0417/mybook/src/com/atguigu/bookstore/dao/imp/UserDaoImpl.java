package com.atguigu.bookstore.dao.imp;

import com.atguigu.bookstore.dao.BaseDao;
import com.atguigu.bookstore.dao.UserDao;
import com.atguigu.pojo.User;

/**
 * @author Mr.Helianthus
 * @create 2021-04-20 6:51 PM
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public User checkedUsernameAndPassword(String username, String password) {
        String sql = "SELECT id,username,password,email FROM users WHERE username=? AND password=?";
        User bean = getBean(sql, username, password);
        return bean;
    }

    @Override
    public boolean checkedUsername(String username) {
        String sql = "SELECT id,username,password,email FROM users WHERE username=? ";
        User bean = getBean(sql, username);
        return bean == null;
    }

    @Override
    public void addUser(String username, String password, String email) {
        String sql = "INSERT INTO users (username,password,email) VULAES(?,?,?)";
        int update = update(sql, username, password, email);

    }
}
