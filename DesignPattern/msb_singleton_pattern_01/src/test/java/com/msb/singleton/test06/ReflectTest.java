package com.msb.singleton.test06;

import com.msb.singleton.demo6.Singleton_06;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Constructor;


/**
 * @author Created by yinrg on 2023-01-16 13:44
 * @fileSimpleName TestReflect
 * @fileName com.msb.singleton.test05.TestReflect
 * @description 反射对单例的破坏
 * 枚举对象中不能使用newInstance()的方式去创建枚举对象,会在底层代码中抛出异常
 */
@Slf4j
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        Class<Singleton_06> singleton06Class = Singleton_06.class;
        // 获取构造方法的对象
        Constructor<Singleton_06> constructor = singleton06Class.getDeclaredConstructor();
        // 设置为true以后就可以对类中的私有成员进行操作了
        constructor.setAccessible(true);
        // 反射不能创建枚举对象
//        Singleton_06 instance = constructor.newInstance();
        Singleton_06 instance = constructor.newInstance(String.class, int.class);
        log.info(instance.toString());
    }
}
