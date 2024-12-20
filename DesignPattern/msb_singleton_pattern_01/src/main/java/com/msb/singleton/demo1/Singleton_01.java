package com.msb.singleton.demo1;

/**
 * @author Created by yinrg on 2023-01-15 16:18
 * @fileSimpleName Singleton_01
 * @fileName com.msb.singleton.demo1.Singleton_01
 * @description 单例模式-饿汉式
 * 在类加载期间初始化私有的静态实例,保证instance实例创建过程中的线程安全的。
 * 特点：不支持延时加载,获取实例对象的速度比较快,但是如果对象比较大,而且一直没有使用就会造成内存浪费
 */
public class Singleton_01 {
    // 1. 私有构造方法
    private Singleton_01() {
    }

    // 2. 在本类中创建私有静态的全局对象
    private static Singleton_01 instance = new Singleton_01();

    // 3. 提供一个全局的访问点,供外部获取单例对象
    public static Singleton_01 getInstance() {
        return instance;
    }
}
