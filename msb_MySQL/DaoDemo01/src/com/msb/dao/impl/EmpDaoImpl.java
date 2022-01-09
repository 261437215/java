package com.msb.dao.impl;

import com.msb.dao.EmpDao;
import com.msb.entity.Emp;

import java.sql.*;

/**
 * @author Created by yinrg on 2022/1/9/0009 下午 12:16
 * @fileSimpleName EmpDaoImpl
 * @fileName com.msb.dao.impl.EmpDaoImpl
 * @description
 */
public class EmpDaoImpl implements EmpDao {

    private static Statement statement = null;
    private static Connection connection = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/java?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimeZone=Asia/Shanghai";
            connection = DriverManager.getConnection(url, "root", "");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int addEmp(Emp emp) throws SQLException {
        String sql = "insert into emp values(default,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,emp.getEname());
        preparedStatement.setString(2,emp.getJob());
        preparedStatement.setInt(3,emp.getMgr());
        preparedStatement.setObject(4,emp.getHiredate());
        preparedStatement.setObject(5,emp.getSal());
        preparedStatement.setObject(6,emp.getComm());
        preparedStatement.setInt(7,emp.getDeptno());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int delEmp(Integer entity) throws SQLException {
        String sql = "delete from emp where EMPNO = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,entity);
        return preparedStatement.executeUpdate();
    }
}
