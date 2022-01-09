package com.msb.util;

import com.msb.test.Test2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Created by yinrg on 2022/1/9/0009 下午 07:46
 * @fileSimpleName PropertiesUtil
 * @fileName com.msb.util.PropertiesUtil
 * @description
 */
public class PropertiesUtil {
    private Properties properties;

    public PropertiesUtil(String path) {
        properties = new Properties();
        // 指向字节码根路径下的文件的IO流
        InputStream resourceAsStream = Test2.class.getResourceAsStream(path);
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPropertiesInfo(String key){
        return properties.getProperty(key);
    }

}
