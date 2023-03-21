package com.msb.factory.abstractFactory.factory;

import com.msb.factory.abstractFactory.product.AbstractFreezer;
import com.msb.factory.abstractFactory.product.AbstractTV;

/**
 * @author Created by yinrg on 2023/3/21 23:01
 * @description
 */
public interface AppliancesFactory {
    AbstractTV createTV();

    AbstractFreezer createFreezer();
}
