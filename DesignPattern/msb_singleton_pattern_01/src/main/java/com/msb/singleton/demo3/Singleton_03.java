package com.msb.singleton.demo3;

/**
 * @author Created by yinrg on 2023-01-15 17:18
 * @fileSimpleName Singleton_02
 * @fileName com.msb.singleton.demo2.Singleton_02
 * @description 单例模式-懒汉式(线程安全)
 * 特点：支持延时加载,只有调用getInstance方法时才会创建对象。
 * 使用该方式创建Singleton_02对象，线程是安全的。
 * 使用synchronized锁,锁住单例对象的方法,防止多个线程同时调用。
 * 缺点： 因为getInstance方法使用synchronized锁,导致了这个函数的并发度很低。
 */
public class Singleton_03 {
    // 1. 私有构造方法
    private Singleton_03() {
    }

    // 2. 在本类中创建私有静态的全局对象
    private static Singleton_03 instance;

    // 3. 判断对象是否已经创建,如果没有创建对象则创建信息
    public synchronized static Singleton_03 getInstance() {
        if(instance == null){
            instance = new Singleton_03();
        }
        return instance;
    }
}
