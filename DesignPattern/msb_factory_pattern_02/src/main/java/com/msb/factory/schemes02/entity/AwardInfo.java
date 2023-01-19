package com.msb.factory.schemes02.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

/**
 * @author Created by yinrg on 2023-01-18 14:57
 * @fileSimpleName AwardInfo
 * @fileName com.msb.factory.schemes01.entity.AwardInfo
 * @description 获奖信息实体类
 */

@Data
@NoArgsConstructor
@ToString
public class AwardInfo {

    /**
     * 用户id
     */
    private String uid;

    /**
     * 奖品类型
     * 1.打折券、2.优酷会员、3.小礼品
     */
    private Integer awardType;

    /**
     * 奖品编号
     */
    private String awardNumber;

    /**
     * 用于封装的额外信息
     */
    private Map<String, String> extMap;


}
