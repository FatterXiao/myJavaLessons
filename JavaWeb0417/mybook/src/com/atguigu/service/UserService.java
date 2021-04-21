package com.atguigu.service;

import com.atguigu.pojo.User;

/**
 * @author Mr.Helianthus
 * @create 2021-04-20 7:22 PM
 */
public interface UserService {

    /**
     * 登录操作
     * @param user 传入用户对象
     * @return 如果登录成功，返回一个User的对象；
     *         如果登录失败，返回null；
     */
    User login(User user);


    /**
     * 是否可以进行注册操作
     * @param user
     * @return 如果可以注册，返回可以true;
     *         如果不可以注册，返回false
     */
    boolean isRegist(User user);


    /**
     * 注册用户
     * @param user
     */
    void registUser(User user);
}
