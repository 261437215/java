package com.msb.test;

import com.msb.config.ConnectionConfig;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Created by yinrg on 2022/1/9/0009 下午 02:04
 * @fileSimpleName Test1
 * @fileName com.msb.test.Test1
 * @description
 */
public class Test1 {
    public static void main(String[] args) throws SQLException {
//        Emp emp = new Emp(null,"Java代码测试","Java",7839,new Date(),new BigDecimal(100.12),new BigDecimal(100.12),30);
//        EmpDao empDao = new EmpDaoImpl();
//        int i = empDao.addEmp(emp);
//        System.out.println(i);
//
//        int i1 = empDao.delEmp(7935);
//        System.out.println(i1);
        System.out.println("初始化池子数量="+ConnectionConfig.givePoolSize());
        Connection connection = ConnectionConfig.getConnection();
        Connection connection2 = ConnectionConfig.getConnection();
        Connection connection3 = ConnectionConfig.getConnection();
        ConnectionConfig.giveBackConnection(connection);
        System.out.println("池子数量="+ConnectionConfig.givePoolSize());
        ConnectionConfig.giveBackConnection(connection2);
        System.out.println("池子数量="+ConnectionConfig.givePoolSize());
        ConnectionConfig.giveBackConnection(connection3);
        System.out.println("池子数量="+ConnectionConfig.givePoolSize());
        ConnectionConfig.giveBackConnection(connection3);
        System.out.println("池子数量="+ConnectionConfig.givePoolSize());
    }
}
