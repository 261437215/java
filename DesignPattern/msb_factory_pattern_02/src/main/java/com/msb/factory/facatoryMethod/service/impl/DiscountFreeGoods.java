package com.msb.factory.facatoryMethod.service.impl;

import com.msb.factory.facatoryMethod.entity.AwardInfo;
import com.msb.factory.facatoryMethod.entity.ResponseResult;
import com.msb.factory.facatoryMethod.service.IFreeGoods;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Created by yinrg on 2023-01-19 15:04
 * @fileSimpleName DiscountFreeGoods
 * @fileName com.msb.factory.schemes02.service.impl.DiscountFreeGoods
 * @description
 */
@Slf4j
public class DiscountFreeGoods implements IFreeGoods {
    @Override
    public ResponseResult sendFreeGoods(AwardInfo awardInfo) {
        log.info("向用户发放打折券:{}",awardInfo.getUid());
        return new ResponseResult("200","打折券发放成功!",null);
    }
}
