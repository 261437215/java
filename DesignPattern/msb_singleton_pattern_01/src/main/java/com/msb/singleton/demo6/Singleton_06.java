package com.msb.singleton.demo6;

/**
 * @author Created by yinrg on 2023-01-15 17:18
 * @fileSimpleName Singleton_06
 * @fileName com.msb.singleton.demo6.Singleton_06
 * @description 单例模式-懒汉式 枚举实现
 * 反射： 反射方法中不允许反射创建枚举对象(可以防止反射的破坏)
 * 序列化： 在序列化的时候仅仅是将枚举对象的name属性输出到了结果中。在反序列化的时候就会通过Enum的valueOf方法来根据名字查找到对应的枚举对象
 */
public enum Singleton_06 {
    INSTANCE;

    private Object data;

    public java.lang.Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static Singleton_06 getInstance(){
        return INSTANCE;
    }
}
