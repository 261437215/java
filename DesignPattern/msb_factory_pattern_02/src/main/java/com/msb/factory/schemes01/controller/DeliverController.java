package com.msb.factory.schemes01.controller;

import com.msb.factory.schemes01.entity.AwardInfo;
import com.msb.factory.schemes01.entity.DiscountResult;
import com.msb.factory.schemes01.entity.SmallGiftInfo;
import com.msb.factory.schemes01.service.DiscountService;
import com.msb.factory.schemes01.service.SmallGiftInfoService;
import com.msb.factory.schemes01.service.YouKuMemberService;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.UUID;

/**
 * @author Created by yinrg on 2023-01-18 15:47
 * @fileSimpleName DeliverController
 * @fileName com.msb.factory.schemes01.controller.DeliverController
 * @description 奖品controller层
 */

@Slf4j
public class DeliverController {

    /**
     * 按照类型的不同发放奖品
     *
     * @param awardInfo {@link AwardInfo}
     */
    protected void awardToUser(AwardInfo awardInfo) {
        Integer awardType = awardInfo.getAwardType();
        Map<String, String> extMap = awardInfo.getExtMap();
        if (awardType == 1) {
            // 打折券
            DiscountService discountService = new DiscountService();
            DiscountResult discountResult = discountService
                    .sendDiscount(awardInfo.getUid(), awardInfo.getAwardNumber());
            log.info("打折券发送成功!{}",discountResult.toString());
        } else if (awardType == 2) {
            // 优酷会员
            YouKuMemberService youKuMemberService = new YouKuMemberService();
            youKuMemberService.openMember(extMap.get("phone"),awardInfo.getAwardNumber());
            log.info("优酷会员发放成功!");
        } else if (awardType == 3) {
            // 小礼品
            SmallGiftInfoService smallGiftInfoService = new SmallGiftInfoService();
            // 封装收货人信息
            SmallGiftInfo smallGiftInfo = new SmallGiftInfo();
            smallGiftInfo.setUserName(extMap.get("name"));
            smallGiftInfo.setAddress(extMap.get("address"));
            smallGiftInfo.setUserPhone(extMap.get("phone"));
            smallGiftInfo.setOrderId(UUID.randomUUID().toString());
            Boolean aBoolean = smallGiftInfoService.giveSmallGift(smallGiftInfo);
            log.info(aBoolean ? "小礼品发放成功!" : "小礼品发放失败!");
        }
    }
}
