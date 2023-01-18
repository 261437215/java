package com.msb.factory.schemes01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Created by yinrg on 2023-01-18 15:29
 * @fileSimpleName DisscountResult
 * @fileName com.msb.factory.schemes01.entity.DisscountResult
 * @description 打折响应信息封装类
 */
@Data
@AllArgsConstructor
public class DiscountResult {

    private String status;

    private String message;
}
