package com.msb.factory.schemes02.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author Created by yinrg on 2023-01-18 15:29
 * @fileSimpleName DisscountResult
 * @fileName com.msb.factory.schemes01.entity.DisscountResult
 * @description 响应信息封装类
 */
@Data
@AllArgsConstructor
@ToString
public class ResponseResult {

    /**
     * 状态码
     */
    private String status;

    /**
     * 信息
     */
    private String message;

    /**
     * 数据
     */
    private Object data;
}
