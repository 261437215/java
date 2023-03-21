package com.msb.factory.abstractFactory.factory;

import com.msb.factory.abstractFactory.product.AbstractFreezer;
import com.msb.factory.abstractFactory.product.AbstractTV;
import com.msb.factory.abstractFactory.product.HisenseFreezer;
import com.msb.factory.abstractFactory.product.HisenseTV;

/**
 * @author Created by yinrg on 2023/3/21 23:05
 * @description 海信工厂
 */
public class HisenseFactory implements AppliancesFactory {
    @Override
    public AbstractTV createTV() {
        return new HisenseTV();
    }

    @Override
    public AbstractFreezer createFreezer() {
        return new HisenseFreezer();
    }
}
