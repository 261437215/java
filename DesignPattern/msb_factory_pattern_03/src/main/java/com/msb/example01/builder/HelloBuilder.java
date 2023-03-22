package com.msb.example01.builder;

import com.msb.example01.product.Bike;

/**
 * @author Created by yinrg on 2023/3/22 23:30
 * @description 哈啰单车
 */
public class HelloBuilder extends Builder{
    @Override
    public void buildFrame() {
        System.out.println("哈啰单车-制作碳纤维车架!");
        mBike.setFrame("碳纤维车架");
    }

    @Override
    public void buildSeat() {
        System.out.println("哈啰单车-制作橡胶车座!");
        mBike.setSeat("橡胶车架");
    }

    @Override
    public Bike createBike() {
        return mBike;
    }
}
