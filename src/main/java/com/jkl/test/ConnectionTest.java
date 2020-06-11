package com.jkl.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Daryl on 2020/06/11 14:31
 */
public class ConnectionTest {
    public static void main(String[] args) {
        String username="Daryl";
        String password="DarylDarylDaryl";
        String url="jdbc:mysql://10.172.183.13:3306/bigdata";
        String driver_name="com.mysql.jdbc.Driver";

        Connection conn=null;

        try {
            Class.forName(driver_name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DriverManager.getConnection(url,username,password);
            System.out.println("连接成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
