package com.msb.factory.schemes01.service;

import com.alibaba.fastjson2.JSON;
import com.msb.factory.schemes01.entity.SmallGiftInfo;
import lombok.extern.slf4j.Slf4j;
/**
 * @author Created by yinrg on 2023-01-18 15:40
 * @fileSimpleName SmallGiftInfoService
 * @fileName com.msb.factory.schemes01.service.SmallGiftInfoService
 * @description
 */

@Slf4j
public class SmallGiftInfoService {
    public Boolean giveSmallGift(SmallGiftInfo smallGiftInfo){
        log.info("发送小礼品成功,请用户查收！{}", JSON.toJSON(smallGiftInfo));
        return true;
    }
}
