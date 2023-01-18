package com.msb.factory.schemes01.controller;

import com.msb.factory.schemes01.entity.AwardInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by yinrg on 2023-01-18 16:05
 * @fileSimpleName DeliverControllerTest
 * @fileName com.msb.factory.schemes01.controller.DeliverControllerTest
 * @description
 */
@Slf4j
public class DeliverControllerTest {
    static DeliverController deliverController = null;


    @Before
    public void setUp() throws Exception {
        this.deliverController = new DeliverController();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void awardToUserTest01() {
        AwardInfo awardInfo = new AwardInfo();
        awardInfo.setUid("001");
        awardInfo.setAwardType(1);
        awardInfo.setAwardNumber("DEL12345");
        deliverController.awardToUser(awardInfo);
    }

    @Test
    public void awardToUserTest02() {
        AwardInfo awardInfo = new AwardInfo();
        awardInfo.setUid("002");
        awardInfo.setAwardType(2);
        awardInfo.setAwardNumber("DEL12345");
        Map<String, String> map = new HashMap<>(8);
        map.put("phone", "9876543210");
        awardInfo.setExtMap(map);
        deliverController.awardToUser(awardInfo);
    }

    @Test
    public void awardToUserTest03() {
        AwardInfo awardInfo = new AwardInfo();
        awardInfo.setUid("003");
        awardInfo.setAwardType(3);
        awardInfo.setAwardNumber("DEL12345");
        Map<String, String> map = new HashMap<>(8);
        map.put("userName", "卡牌大师");
        map.put("address", "召唤师峡谷");
        map.put("phone", "9876543210");
        awardInfo.setExtMap(map);
        deliverController.awardToUser(awardInfo);
    }
}