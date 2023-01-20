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
 * 简单工厂模式的优点：
 *  封装了创建对象的过程,可以通过参数直接获取对象,把对象的创建和业务逻辑分开,避免了可能会直接修改客户代码的问题。
 *  如果要实现新产品,直接修改工厂类,不需要再源代码中进行修改,降低了客户端修改代码的可能性,更加容易扩展。
 *
 * 简单工厂的缺点：
 *  在增加新产品的时候还是要修改工厂类的代码,违背了开闭原则。
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
