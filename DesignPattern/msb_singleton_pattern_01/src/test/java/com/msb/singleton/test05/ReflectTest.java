package com.msb.singleton.test05;

import com.msb.singleton.demo5.Singleton_05;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;

/**
 * @author Created by yinrg on 2023-01-16 13:44
 * @fileSimpleName TestReflect
 * @fileName com.msb.singleton.test05.TestReflect
 * @description 反射对单例的破坏
 */
@Slf4j
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        Class<Singleton_05> singleton05Class = Singleton_05.class;
        Constructor<Singleton_05> constructor = singleton05Class.getDeclaredConstructor();
        // 设置为true以后就可以对类中的私有成员进行操作了
        constructor.setAccessible(true);
        // 多次操作构造方法
        Singleton_05 instance = constructor.newInstance();
        Singleton_05 instance2 = constructor.newInstance();

        log.info(instance.toString());
        log.info(instance2.toString());

    }
}
