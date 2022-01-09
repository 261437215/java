package com.msb.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Created by yinrg on 2022/1/9/0009 下午 07:31
 * @fileSimpleName Test2
 * @fileName com.msb.test.Test2
 * @description
 * 获取jdbc.properties文件的配置信息
 */
public class Test2 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        // 指向字节码根路径下的文件的IO流
        InputStream resourceAsStream = Test2.class.getResourceAsStream("/jdbc.properties");
        // 根据路径读取配置文件
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String driver = properties.getProperty("driver");
        System.out.println(driver);

    }

}
