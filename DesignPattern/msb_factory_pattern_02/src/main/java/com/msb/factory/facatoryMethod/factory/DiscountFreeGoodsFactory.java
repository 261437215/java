package com.msb.factory.facatoryMethod.factory;


import com.msb.factory.facatoryMethod.service.IFreeGoods;
import com.msb.factory.facatoryMethod.service.impl.DiscountFreeGoods;

/**
 * @author Created by yinrg on 2023-01-20 11:07
 * @fileSimpleName DisscountFreeGoodsFactory
 * @fileName com.msb.factory.facatoryMethod.factory.DisscountFreeGoodsFactory
 * @description 优惠券发放接口-具体工厂
 */
public class DiscountFreeGoodsFactory implements FreeGoodsFactory{
    @Override
    public IFreeGoods getInstance() {
        return new DiscountFreeGoods();
    }
}
