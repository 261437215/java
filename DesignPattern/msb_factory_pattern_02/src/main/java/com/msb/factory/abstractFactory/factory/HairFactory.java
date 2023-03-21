package com.msb.factory.abstractFactory.factory;

import com.msb.factory.abstractFactory.product.AbstractFreezer;
import com.msb.factory.abstractFactory.product.AbstractTV;
import com.msb.factory.abstractFactory.product.HairFreezer;
import com.msb.factory.abstractFactory.product.HairTV;

/**
 * @author Created by yinrg on 2023/3/21 23:00
 * @description 海尔工厂
 */
public class HairFactory implements AppliancesFactory{
    @Override
    public AbstractTV createTV() {
        return new HairTV();
    }

    @Override
    public AbstractFreezer createFreezer() {
        return new HairFreezer();
    }
}
