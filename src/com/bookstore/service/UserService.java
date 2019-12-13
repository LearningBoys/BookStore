package com.bookstore.service;

import com.bookstore.domain.User;
import com.bookstore.exception.IsExistUser;
import com.bookstore.exception.NotExistUser;

import java.util.List;

public interface UserService {
    /**
     * 用户登录
     * @param userEmail
     * @param userPwd
     */
    User login(String userEmail, String userPwd) throws NotExistUser;

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    void register(User user) throws IsExistUser;

    /**
     * 用户邮箱验证
     * @param userEmail
     * @return
     */
    List<User> findUserByUserByEmail(String userEmail);


}
