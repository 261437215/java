package com.msb.factory.schemes02.controller;

import com.msb.factory.schemes02.entity.AwardInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by yinrg on 2023-01-19 15:24
 * @fileSimpleName DeliverControllerTest
 * @fileName com.msb.factory.schemes02.controller.DeliverControllerTest
 * @description
 */
@Slf4j
public class DeliverControllerTest {
    static DeliverController deliverController = new DeliverController();
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void awardToUser() {
        AwardInfo awardInfo = new AwardInfo();
        awardInfo.setUid("001");
        awardInfo.setAwardType(1);
        awardInfo.setAwardNumber("DEL12345");
        deliverController.awardToUser(awardInfo);
        log.info("#######################################################");
        awardInfo.setUid("002");
        awardInfo.setAwardType(2);
        awardInfo.setAwardNumber("DEL12345");
        Map<String, String> map = new HashMap<>(8);
        map.put("phone", "9876543210");
        awardInfo.setExtMap(map);
        deliverController.awardToUser(awardInfo);
    }
}