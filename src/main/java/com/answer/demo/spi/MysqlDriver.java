package com.answer.demo.spi;

import com.mysql.jdbc.NonRegisteringDriver;

import java.sql.Driver;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * created by liufeng
 * 2021/9/30
 */
public class MysqlDriver extends NonRegisteringDriver implements Driver {

    public MysqlDriver() throws SQLException {
        System.out.println("加载自定义Driver");
    }

    static {

        System.out.println("静态代码块");
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
