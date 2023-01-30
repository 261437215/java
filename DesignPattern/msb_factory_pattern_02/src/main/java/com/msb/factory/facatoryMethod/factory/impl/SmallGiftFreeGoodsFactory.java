package com.msb.factory.facatoryMethod.factory.impl;

import com.msb.factory.facatoryMethod.factory.FreeGoodsFactory;
import com.msb.factory.facatoryMethod.service.IFreeGoods;
import com.msb.factory.facatoryMethod.service.impl.SmallGiftFreeGoods;

/**
 * @author Created by yinrg on 2023-01-20 11:28
 * @fileSimpleName SmallGiftFreeGoodsFactory
 * @fileName com.msb.factory.facatoryMethod.factory.impl.SmallGiftFreeGoodsFactory
 * @description
 */
public class SmallGiftFreeGoodsFactory implements FreeGoodsFactory {
    @Override
    public IFreeGoods getInstance() {
        return new SmallGiftFreeGoods();
    }
}
