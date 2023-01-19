package com.msb.factory.schemes02.factory;

import com.msb.factory.schemes02.service.IFreeGoods;
import com.msb.factory.schemes02.service.impl.DiscountFreeGoods;
import com.msb.factory.schemes02.service.impl.SmallGiftFreeGoods;
import com.msb.factory.schemes02.service.impl.YouKuMemberFreeGoods;

/**
 * @author Created by yinrg on 2023-01-19 15:14
 * @fileSimpleName FreeGoodsFactory
 * @fileName com.msb.factory.schemes02.factory.FreeGoodsFactory
 * @description 具体工厂:生成免费商品
 */
public class FreeGoodsFactory {
    public static IFreeGoods getInstance(Integer awardType) {
        if (awardType == 1) {
            // 打折券
            return new DiscountFreeGoods();
        } else if (awardType == 2) {
            // 优酷会员
            return new YouKuMemberFreeGoods();
        } else if (awardType == 3) {
            // 小礼品
            return new SmallGiftFreeGoods();
        } else {
            throw new RuntimeException("awardType参数错误！");
        }
    }
}
