package com.msb.factory.facatoryMethod.controller;

import com.msb.factory.facatoryMethod.entity.AwardInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Created by yinrg on 2023-01-30 12:27
 * @fileSimpleName DeliverControllerTest
 * @fileName com.msb.factory.facatoryMethod.controller.DeliverControllerTest
 * @description
 */
@Slf4j
public class DeliverControllerTest {
    DeliverController controller = new DeliverController();
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
        controller.awardToUser(awardInfo);
    }
}