package com.msb.example01.builder;

import com.msb.example01.product.Bike;

/**
 * @author Created by yinrg on 2023/3/22 23:13
 * @description 建造者抽象类(这里对象也可以是接口)
 */
public abstract class Builder {

    // 给具体的建造者使用(就是给子类使用)
    protected Bike mBike = new Bike();


    /**
     * 创建车架
     */
    public abstract void buildFrame();


    /**
     * 创建车座
     */
    public abstract void buildSeat();

    /**
     * 创建自行车对象
     * @return Bike
     */
    public abstract Bike createBike();
}
