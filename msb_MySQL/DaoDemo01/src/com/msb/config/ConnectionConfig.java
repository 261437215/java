package com.msb.config;

import com.msb.util.PropertiesUtil;
import jdk.nashorn.internal.runtime.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 * @author Created by yinrg on 2022/1/9/0009 下午 03:46
 * @fileSimpleName ConnectionConfig
 * @fileName com.msb.config.ConnectionConfig
 * @description 数据库连接池
 */
public class ConnectionConfig {

    static final PropertiesUtil propertiesUtil = new PropertiesUtil("/jdbc.properties");
    private static String url ;
    private static String user ;
    private static String passWord;
    private static Statement statement;
    private static Connection connection;
    private static Integer initSize ;
    private static Integer maxSize ;
    private static LinkedList<Connection> pool;


    static {
        url = propertiesUtil.getPropertiesInfo("url");
        initSize = Integer.getInteger(propertiesUtil.getPropertiesInfo("initSize"));
        user = propertiesUtil.getPropertiesInfo("user");
        passWord = propertiesUtil.getPropertiesInfo("password");
        initSize = Integer.parseInt(propertiesUtil.getPropertiesInfo("initSize"));
        maxSize = Integer.parseInt(propertiesUtil.getPropertiesInfo("maxSize"));
        try {
            Class.forName(propertiesUtil.getPropertiesInfo("driver"));
            pool = new LinkedList<Connection>();
            for (int i = 0; i <= initSize; i++) {
                Connection initConnection = initConnection();
                if (initConnection != null) {
                    pool.add(initConnection);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建数据库连接对象
     *
     * @return
     * @throws SQLException
     */
    private static Connection initConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, user, passWord);
            System.out.println("成功创建一个连接对象!");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 向外界提供连接对象
     *
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;
        if (pool.size() > 0) {

            connection = pool.removeFirst();
            System.out.println("连接池中剩余的连接数量=" + pool.size());
        } else {
            System.out.println("连接池中剩余的连接数量为空,创建新连接!");
            return initConnection();
        }
        return connection;
    }

    /**
     * 回收连接对象
     *
     * @return
     */
    public static void giveBackConnection(Connection connection) {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    if (pool.size() < maxSize) {
                        // 小于连接池的最大数据限制
                        try {
                            // 事务设置为自动提交
                            connection.setAutoCommit(true);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        if (pool.contains(connection)) {
                            System.out.println("该连接已经归还,无需再归还!");
                        } else {
                            pool.addLast(connection);
                        }

                    } else {
                        try {
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("归还成功!");
                } else {
                    System.out.println("连接对象已经被关闭!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static Integer givePoolSize() {
        return pool.size();
    }

}
