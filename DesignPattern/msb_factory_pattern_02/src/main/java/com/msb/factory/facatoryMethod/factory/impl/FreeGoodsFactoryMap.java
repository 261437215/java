package com.msb.factory.facatoryMethod.factory.impl;

import com.msb.factory.facatoryMethod.factory.FreeGoodsFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by yinrg on 2023-01-30 15:22
 * @fileSimpleName FreeGoodsFactoryMap
 * @fileName com.msb.factory.facatoryMethod.factory.impl.FreeGoodsFactoryMap
 * @description 用来创建工厂类对象
 */
public class FreeGoodsFactoryMap {

    // 创建一个map集合,用于保存工厂对象
    private static final Map<Integer, FreeGoodsFactory> cachedFactory = new HashMap<>(8);

    static {
        cachedFactory.put(1, new DiscountFreeGoodsFactory());
        cachedFactory.put(2, new SmallGiftFreeGoodsFactory());
    }

    public static FreeGoodsFactory getParserFactory(Integer type){
        return type == 1 || type == 2 ? cachedFactory.get(type) : null;
    }
}
