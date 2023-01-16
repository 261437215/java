package com.msb.singleton.demo05;

/**
 * @author Created by yinrg on 2023-01-16 13:34
 * @fileSimpleName Singleton_05
 * @fileName com.msb.singleton.demo05.Singleton_05
 * @description 单例模式-懒汉式(双重校验) 静态内部类
 */
public class Singleton_05 {
    // 1. 私有构造方法
    private Singleton_05() {
        // 防止反射对单例的破坏,在构造方法中添加判断
        if (SingletonHandler.instance != null){
            throw new RuntimeException("不允许非法访问!");
        }
    }

    // 创建静态内部类
    private static class SingletonHandler{
        // 在静态内部类中创建单例,在装载内部类的时候,才会创建单例对象
        private static Singleton_05 instance = new Singleton_05();
    }

    public static Singleton_05 getInstance(){
        return SingletonHandler.instance;
    }
}
