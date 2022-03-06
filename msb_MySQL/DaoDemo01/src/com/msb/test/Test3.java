package com.msb.test;

import org.apache.log4j.Logger;

/**
 * @author Created by yinrg on 2022/1/16/0016 上午 11:57
 * @fileSimpleName Test3
 * @fileName com.msb.test.Test3
 * @description log4j日志
 */
public class Test3 {


    public static void main(String[] args) {
        //创建一个日志记录器
        Logger logger = Logger.getLogger(Test3.class);

        //在合适的地方添加日志
        logger.info("正确的读取了属性文件" );

        logger.debug("正确的关闭了结果集");

        logger.error("DML操作错误：");

        try {
            int i = 1/0;
        } catch (Exception e) {
            logger.error("DML操作错误：",e);
        }
    }
}
