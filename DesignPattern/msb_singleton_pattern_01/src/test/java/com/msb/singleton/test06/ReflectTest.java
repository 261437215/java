package com.msb.singleton.test06;

import com.msb.singleton.demo6.Singleton_06;
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
        Class<Singleton_06> singleton06Class = Singleton_06.class;
        Constructor<Singleton_06> constructor = singleton06Class.getDeclaredConstructor();
        // 设置为true以后就可以对类中的私有成员进行操作了
        constructor.setAccessible(true);
        // 反射不能创建枚举对象
        Singleton_06 singleton06 = constructor.newInstance(String.class,int.class);
        log.info(singleton06.toString());
    }
}
