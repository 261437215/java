package com.msb.factory.facatoryMethod.controller;

import com.msb.factory.facatoryMethod.entity.AwardInfo;
import com.msb.factory.facatoryMethod.entity.ResponseResult;
import com.msb.factory.facatoryMethod.factory.DiscountFreeGoodsFactory;
import com.msb.factory.facatoryMethod.factory.FreeGoodsFactory;
import com.msb.factory.facatoryMethod.factory.SmallGiftFreeGoodsFactory;
import com.msb.factory.facatoryMethod.service.IFreeGoods;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Created by yinrg on 2023-01-20 11:23
 * @fileSimpleName DeliverController
 * @fileName com.msb.factory.facatoryMethod.controller.DeliverController
 * @description
 */
@Slf4j
public class DeliverController {
    public ResponseResult awardToUser(AwardInfo awardInfo) {
        FreeGoodsFactory freeGoodsFactory = null;

        if (awardInfo.getAwardType() == 1) {
            freeGoodsFactory = new DiscountFreeGoodsFactory();
        } else if (awardInfo.getAwardType() == 2) {
            freeGoodsFactory = new SmallGiftFreeGoodsFactory();
        }
        IFreeGoods instance = freeGoodsFactory.getInstance();
        log.info("------工厂方法模式------");
        return instance.sendFreeGoods(awardInfo);
    }
}
