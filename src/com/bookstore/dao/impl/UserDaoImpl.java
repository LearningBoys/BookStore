package com.bookstore.dao.impl;

import com.bookstore.dao.UserDao;
import com.bookstore.domain.User;
import com.bookstore.utils.DBUtils;
import com.bookstore.utils.ManagerThreadLocal;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    QueryRunner qr = new QueryRunner(DBUtils.getDataSource());


    @Override
    public void addUser(User user) throws SQLException {
        //进行用户添加
        String sql = "INSERT INTO users(userName,userPwd,userEmail,userSex,userPhone,userDesc,activeCode,statu,registerTime) VALUES(?,?,?,?,?,?,?,?,?);";
        qr.update(ManagerThreadLocal.getConn(), sql, new Object[]{user.getUserName(), user.getUserPwd(), user.getUserEmail(),
                user.getUserSex(), user.getUserPhone(), user.getUserDesc(), user.getActiveCode(), user.getStaus(),
                user.getRegisterTime()});
    }

    @Override
    public List<User> findUserByUserByEmail(String userEmail) throws SQLException {
        String sql = "SELECT * FROM users WHERE userEmail = ?";
        return qr.query(sql, new BeanListHandler<>(User.class), userEmail);

    }

    @Override
    public User findUserInfo(String userEmail, String userPwd) throws SQLException {
        String sql = "SELECT * FROM  bookstore.users WHERE userEmail = ? AND userPwd = ?";
        return qr.query(sql, new BeanHandler<>(User.class), userEmail, userPwd);
    }

}
