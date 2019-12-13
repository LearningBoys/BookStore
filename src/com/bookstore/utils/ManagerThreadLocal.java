package com.bookstore.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class ManagerThreadLocal {
    //管理当前线程
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    /**
     * 为当前线程获取连接
     * @return
     */
    public static Connection getConn(){
        Connection conn = tl.get();
        if (conn == null){  //判断但前线程是否获得连接
            conn = DBUtils.getConnection();
            tl.set(conn);
        }
        return conn;
    }

    /**
     * 为当前线程操作数据库开启事务
     * @throws SQLException
     */
    public static void startTransaction() throws SQLException {
        getConn().setAutoCommit(false);
    }

    /**
     * 当前线程操作完数据库数据，提交事务
     * @throws SQLException
     */
    public static void commitTransaction() throws SQLException {
        getConn().commit();
    }

    /**
     * 当前线程中更新数据可出现异常，事务回滚
     * @throws SQLException
     */
    public static void rollBackTransaction() throws SQLException {
        getConn().rollback();
    }

    /**
     * 当前线程完成数据操作，关闭连接，归还连接
     * @throws SQLException
     */
    public static void closeConn() throws SQLException {
        getConn().close();  //关闭连接
        tl.remove();    //归还链接
    }
}
