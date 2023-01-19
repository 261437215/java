package com.msb.factory.schemes02.controller;

import com.msb.factory.schemes02.entity.AwardInfo;
import com.msb.factory.schemes02.entity.ResponseResult;
import com.msb.factory.schemes02.factory.FreeGoodsFactory;
import com.msb.factory.schemes02.service.IFreeGoods;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Created by yinrg on 2023-01-19 15:19
 * @fileSimpleName DeliverController
 * @fileName com.msb.factory.schemes02.controller.DeliverController
 * @description 发放奖品
 */
@Slf4j
public class DeliverController {
    /**
     * 发放奖品
     * @param awardInfo AwardInfo对象
     * @return ResponseResult
     */
    public ResponseResult awardToUser(AwardInfo awardInfo){
        IFreeGoods instance = FreeGoodsFactory.getInstance(awardInfo.getAwardType());
        ResponseResult responseResult = instance.sendFreeGoods(awardInfo);
        log.info(responseResult.toString());
        return responseResult;
    }
}
