package com.msb.factory.schemes01.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Created by yinrg on 2023-01-18 15:38
 * @fileSimpleName YouKuMemberService
 * @fileName com.msb.factory.schemes01.service.YouKuMemberService
 * @description 优酷会员service
 */

@Slf4j
public class YouKuMemberService {

    public void openMember(String userPhone, String awardNum) {
        log.info("发放优酷会员:{},{}", userPhone, awardNum);
    }
}
