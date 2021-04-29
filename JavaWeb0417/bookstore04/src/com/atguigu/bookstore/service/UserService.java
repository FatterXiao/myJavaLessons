package com.atguigu.bookstore.service;

import com.atguigu.bookstore.beans.User;

/**
 * @author Mr.Helianthus
 * @create 2021-04-20 3:12 PM
 */
public interface UserService {

    /**
     * 根据传入的用户中的用户名和密码从数据库中查询对应的记录
     * @param user 封装了用户名和密码的用户对象
     * @return  User 登录成功   null 登录失败
     */
    User login(User user);

    /**
     * 根据传入的用户中的用户名从数据库中查询对应的记录
     * @param user  封装了用户信息的用户对象
     * @return  true 注册失败   false 注册成功
     */
    boolean regist(User user);

    /**
     * 保存用户信息
     * @param user  封装了用户名、密码、邮箱的用户对象
     */
    void addUser(User user);
}
