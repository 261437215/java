package com.msb.example01.director;

import com.msb.example01.builder.Builder;
import com.msb.example01.product.Bike;

/**
 * @author Created by yinrg on 2023/3/22 23:33
 * @description 指挥者类
 */
public class Director {

    private Builder mBuilder;

    public Director(Builder mBuilder) {
        this.mBuilder = mBuilder;
    }

    public Bike construct(){
        mBuilder.buildFrame();
        mBuilder.buildSeat();
        return mBuilder.createBike();
    }
}
