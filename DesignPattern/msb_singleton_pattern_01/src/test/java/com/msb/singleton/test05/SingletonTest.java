package com.msb.singleton.test05;

import com.msb.singleton.demo05.Singleton_05;
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

    // 懒汉式测试
    @Test
    public void test01() {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                Singleton_05 singleton05 = Singleton_05.getInstance();
                log.info(Thread.currentThread().getName() + "----" + singleton05);
            }).start();
        }
    }
}
