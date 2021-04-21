package com.atguigu.bookstore.dao;

import com.atguigu.pojo.User;

/**
 * @author Mr.Helianthus
 * @create 2021-04-20 7:03 PM
 */
public interface UserDao {

    /**
     * 根据用户名和密码来验证登录是否正确
     * @param username
     * @param password
     * @return
     */
    User checkedUsernameAndPassword(String username,String password);

    /**
     * 根据用户名来监测是否可以注册
     * @param username
     * @return true:可以注册；false：不可以注册
     */
    boolean checkedUsername(String username);

    /**
     * 添加用户
     * @param username
     * @param password
     * @param email
     * @return
     */
    void addUser(String username,String password,String email);
}
