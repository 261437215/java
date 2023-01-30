package com.msb.factory.facatoryMethod.service.impl;

import com.alibaba.fastjson2.JSON;
import com.msb.factory.facatoryMethod.entity.AwardInfo;
import com.msb.factory.facatoryMethod.entity.ResponseResult;
import com.msb.factory.facatoryMethod.entity.SmallGiftInfo;
import com.msb.factory.facatoryMethod.service.IFreeGoods;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * @author Created by yinrg on 2023-01-19 15:08
 * @fileSimpleName SmallGiftFreeGoods
 * @fileName com.msb.factory.schemes02.service.impl.SmallGiftFreeGoods
 * @description
 */
@Slf4j
public class SmallGiftFreeGoods implements IFreeGoods {
    @Override
    public ResponseResult sendFreeGoods(AwardInfo awardInfo) {
        SmallGiftInfo smallGiftInfo = new SmallGiftInfo();
        smallGiftInfo.setAddress(awardInfo.getExtMap().get("address"));
        smallGiftInfo.setUserName(awardInfo.getExtMap().get("userName"));
        smallGiftInfo.setUserPhone(awardInfo.getExtMap().get("phone"));
        smallGiftInfo.setOrderId(UUID.randomUUID().toString());
        log.info("发放小礼品成功,请用户查收！{}", JSON.toJSON(smallGiftInfo));
        return new ResponseResult("200", "发放小礼品成功！", smallGiftInfo);
    }
}
