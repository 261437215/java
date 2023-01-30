package com.msb.factory.facatoryMethod.factory;


import com.msb.factory.facatoryMethod.service.IFreeGoods;

/**
 * @author Created by yinrg on 2023-01-20 11:05
 * @fileSimpleName FreeGoodsFactory
 * @fileName com.msb.factory.facatoryMethod.factory.FreeGoodsFactory
 * @description 抽象工厂类
 */
public interface FreeGoodsFactory {

    IFreeGoods getInstance();
}
