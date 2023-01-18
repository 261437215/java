package com.msb.factory.schemes01.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author Created by yinrg on 2023-01-18 15:03
 * @fileSimpleName SmallGiftInfo
 * @fileName com.msb.factory.schemes01.entity.SmallGiftInfo
 * @description 小礼品实体类
 */
@Data
@ToString
public class SmallGiftInfo {
    private String userName;

    private String userPhone;

    private String orderId;

    private String address;

}
