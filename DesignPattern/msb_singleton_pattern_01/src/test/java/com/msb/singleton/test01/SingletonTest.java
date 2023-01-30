package com.msb.singleton.test01;

import com.msb.singleton.demo1.Singleton_01;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Created by yinrg on 2023-01-15 16:27
 * @fileSimpleName SingletonTest
 * @fileName com.msb.singleton.test01.SingletonTest
 * @description
 */

@Slf4j
public class SingletonTest {

    // 饿汉式测试
    @Test
    public void test01(){
        Singleton_01 instance = Singleton_01.getInstance();
        Singleton_01 instance2 = Singleton_01.getInstance();
        log.info("比较对象内存地址是否相等：{}",instance == instance2);
    }
}
