package com.msb.singleton.demo4;

/**
 * @author Created by yinrg on 2023-01-15 17:18
 * @fileSimpleName Singleton_02
 * @fileName com.msb.singleton.demo2.Singleton_02
 * @description 单例模式-懒汉式(双重校验)
 */
public class Singleton_04 {
    // 1. 私有构造方法
    private Singleton_04() {
    }

    // 2. 在本类中创建私有静态的全局对象
    // volatile关键字能保证变量的可见性,屏蔽JVM指令重排序
    private volatile static Singleton_04 instance;

    // 3. 获取单例对象的静态方法
    public static Singleton_04 getInstance() {
        // 第一次判断,如果instance不为null,不经进入抢锁阶段,直接返回实例
        if(instance == null){
            synchronized (Singleton_04.class){
                // 第二次判断,抢到锁以后再次进行判断,判断instance是否为空
                if(instance == null){
                    instance = new Singleton_04();
                }
/*                上面创建对象的代码,在JVM中被分为三部：
                1. 分配内存空间
                2. 初始化对象
                3. 讲instance指向分配好的内存空间
                JVM 可能会对上面的步骤进行指令重排序变为1、3、2
                */

            }
        }
        return instance;
    }
}
