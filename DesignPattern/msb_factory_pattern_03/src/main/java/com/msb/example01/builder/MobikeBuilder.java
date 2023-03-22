package com.msb.example01.builder;

import com.msb.example01.product.Bike;

/**
 * @author Created by yinrg on 2023/3/22 23:28
 * @description 摩拜单车建造者
 */
public class MobikeBuilder extends Builder{
    @Override
    public void buildFrame() {
        System.out.println("摩拜单车-制作铝合金车架!");
        mBike.setFrame("铝合金车架");
    }

    @Override
    public void buildSeat() {
        System.out.println("摩拜单车-制作真皮车座!");
        mBike.setSeat("真皮车座");
    }

    @Override
    public Bike createBike() {
        return mBike;
    }
}
