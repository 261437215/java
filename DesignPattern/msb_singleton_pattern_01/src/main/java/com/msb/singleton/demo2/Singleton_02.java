package com.msb.singleton.demo2;

import com.msb.singleton.demo1.Singleton_01;

/**
 * @author Created by yinrg on 2023-01-15 17:18
 * @fileSimpleName Singleton_02
 * @fileName com.msb.singleton.demo2.Singleton_02
 * @description 单例模式-懒汉式(线程不安全)
 * 特点：支持延时加载,只有调用getInstance方法时才会创建对象。
 * 使用该方式创建Singleton_02对象，线程不安全
 */
public class Singleton_02 {
    // 1. 私有构造方法
    private Singleton_02() {
    }

    // 2. 在本类中创建私有静态的全局对象
    private static Singleton_02 instance;

    // 3. 判断对象是否已经创建,如果没有创建对象则创建信息
    public static Singleton_02 getInstance() {
        if(instance == null){
            instance = new Singleton_02();
        }
        return instance;
    }
}
