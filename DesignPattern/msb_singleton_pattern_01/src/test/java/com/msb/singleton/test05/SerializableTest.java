package com.msb.singleton.test05;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Created by yinrg on 2023-01-16 16:29
 * @fileSimpleName SerializableTest
 * @fileName com.msb.singleton.test05.SerializableTest
 * @description 序列化对单例的破坏
 */

@Slf4j
public class SerializableTest {

    @Test
    public void test() throws Exception {
        // 序列化对象输出流
        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("tempFile.obj")));
        oos.writeObject(Singleton.getInstance());

        // 序列化对象输入流
        File file = new File("tempFile.obj");
        ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(file.toPath()));
        Singleton instance1 = (Singleton) ois.readObject();
        Singleton instance2 = Singleton.getInstance();
        log.info("对比两个instance对象是否一样:{}", instance1 == instance2);
    }
}

class Singleton implements Serializable {
    // 2. 在本类中创建私有静态的全局对象
    // volatile关键字能保证变量的可见性,屏蔽JVM指令重排序
    private volatile static Singleton singleton;

    private Singleton() {
    }

    // 3. 获取单例对象的静态方法
    public static Singleton getInstance() {
        // 第一次判断,如果instance不为null,不经进入抢锁阶段,直接返回实例
        if (singleton == null) {
            synchronized (Singleton.class) {
                // 第二次判断,抢到锁以后再次进行判断,判断instance是否为空
                if (singleton == null) {
                    singleton = new Singleton();
                }
/*                上面创建对象的代码,在JVM中被分为三部：
                1. 分配内存空间
                2. 初始化对象
                3. 讲instance指向分配好的内存空间
                JVM 可能会对上面的步骤进行指令重排序变为1、3、2
                */

            }
        }
        return singleton;
    }

    /**
     * 为防止序列化对单例的破坏,重写readResolve()方法,可以解决序列化对单例的破坏
     * 程序会判断实现序列化接口的类对象是否包含readResolve()方法,如果有就会调用该类的readResolve()方法;如果不存在该方法就会创建一个新的对象
     * 底层源码的判断逻辑{@link java.io.ObjectInputStream#readOrdinaryObject(boolean)}
     * @return singleton对象
     */
    private Object readResolve(){
        return singleton;
    }

}