package com.msb.factory.schemes02.service.impl;

import com.msb.factory.schemes02.entity.AwardInfo;
import com.msb.factory.schemes02.entity.ResponseResult;
import com.msb.factory.schemes02.service.IFreeGoods;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Created by yinrg on 2023-01-19 15:06
 * @fileSimpleName YouKuMemberFreeGoods
 * @fileName com.msb.factory.schemes02.service.impl.YouKuMemberFreeGoods
 * @description
 */
@Slf4j
public class YouKuMemberFreeGoods implements IFreeGoods {
    @Override
    public ResponseResult sendFreeGoods(AwardInfo awardInfo) {
        log.info("向用户发放优酷会员:{},手机号码:{}", awardInfo.getUid()
                , awardInfo.getExtMap().get("phone"));
        return new ResponseResult("200", "优酷会员发放成功!", null);
    }
}
