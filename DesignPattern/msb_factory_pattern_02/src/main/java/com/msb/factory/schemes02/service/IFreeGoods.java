package com.msb.factory.schemes02.service;

import com.msb.factory.schemes02.entity.AwardInfo;
import com.msb.factory.schemes02.entity.ResponseResult;

/**
 * @author Created by yinrg on 2023-01-19 15:02
 * @fileSimpleName IFreeGoods
 * @fileName com.msb.factory.schemes02.service.IFreeGoods
 * @description 商品发放接口
 */
public interface IFreeGoods {

    ResponseResult sendFreeGoods(AwardInfo awardInfo);
}
