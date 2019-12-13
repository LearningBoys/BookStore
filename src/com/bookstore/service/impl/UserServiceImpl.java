package com.bookstore.service.impl;

import com.bookstore.dao.UserDao;
import com.bookstore.dao.impl.UserDaoImpl;
import com.bookstore.domain.User;
import com.bookstore.exception.IsExistUser;
import com.bookstore.exception.NotExistUser;
import com.bookstore.service.UserService;
import com.bookstore.utils.ManagerThreadLocal;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();


    @Override
    public User login(String userEmail, String userPwd) throws NotExistUser {
        User user = null;
        try {
            user = userDao.findUserInfo(userEmail, userPwd);
            if (user == null) {
                throw new NotExistUser("登陆失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void register(User user) throws IsExistUser {
        try {
            ManagerThreadLocal.startTransaction();
            userDao.addUser(user);
            ManagerThreadLocal.commitTransaction();
        } catch (SQLException e) {
            try {
                ManagerThreadLocal.rollBackTransaction();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            throw new IsExistUser("注册失败");
        } finally {
            try {
                ManagerThreadLocal.closeConn();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<User> findUserByUserByEmail(String userEmail) {
        try {
            List<User> userByUserInfo = userDao.findUserByUserByEmail(userEmail);
            System.out.println(userByUserInfo);
            return userByUserInfo;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
