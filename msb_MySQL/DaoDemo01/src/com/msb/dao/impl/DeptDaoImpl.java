package com.msb.dao.impl;

import com.msb.dao.DeptDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Created by yinrg on 2022/1/9/0009 下午 12:16
 * @fileSimpleName DeptDaoImpl
 * @fileName com.msb.dao.impl.DeptDaoImpl
 * @description
 */
public class DeptDaoImpl implements DeptDao {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/java?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimeZone=Asia/Shanghai";
            Connection connection = null;

            connection = DriverManager.getConnection(url, "root", "");
            Statement statement = connection.createStatement();
//            String sql = "insert into t_student values(default,'yrg',2)";
//            int rows = statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
