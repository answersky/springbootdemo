package com.answer.demo.jdbc;

import java.sql.*;

/**
 * created by liufeng
 * 2019/6/27
 */
public class MysqlCon {
    public static void main(String[] args) {
        String sql="select * from user";
        String url="jdbc:mysql://localhost:3306/test";
        String username="root";
        String password="123456";
        doSql(sql,url,username,password);
    }

    private static Connection getConnection(String url,String username,String password) throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    private static void doSql(String sql,String url,String username,String password){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            //只需要加载驱动类就可以注册驱动到DriverManager（具体实现查看Driver中的静态代码块）
//            Class.forName("com.mysql.jdbc.Driver");  底层通过spi技术已经加载了com.mysql.jdbc.Driver
            connection=getConnection(url,username,password);
            preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("id"));
//                System.out.println(resultSet.getString("username"));
//                System.out.println(resultSet.getString("realname"));
//                System.out.println(resultSet.getString("uuid"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
