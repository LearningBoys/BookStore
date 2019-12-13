package com.bookstore.dao;

import com.bookstore.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user) throws SQLException;

    /**
     * 验证邮箱是否存在
     * @param userInfo
     * @return
     * @throws SQLException
     */
    List<User> findUserByUserByEmail(String userInfo) throws SQLException;

    /**
     * 根据用户所给信息进行查询
     * @param userEmail
     * @param userPwd
     */
    User findUserInfo(String userEmail, String userPwd) throws SQLException;
}
