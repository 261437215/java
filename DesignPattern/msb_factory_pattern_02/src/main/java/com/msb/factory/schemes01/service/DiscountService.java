package com.msb.factory.schemes01.service;

import com.msb.factory.schemes01.entity.DiscountResult;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Created by yinrg on 2023-01-18 15:34
 * @fileSimpleName DiscountService
 * @fileName com.msb.factory.schemes01.service.DiscountService
 * @description 打折券服务层
 */

@Slf4j
public class DiscountService {
    public DiscountResult sendDiscount(String uid, String awardNumber) {
        log.info("向用户发送一张打折券:{},{}", uid, awardNumber);
        return new DiscountResult("200","发放打折券成功!");
    }

}
