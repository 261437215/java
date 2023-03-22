package com.msb.example02;

/**
 * @author Created by yinrg on 2023/3/23 0:56
 * @description
 */
public class App {
    public static void main(String[] args) {
        // 获取连接对象
        RabbitMQClient3 build = new RabbitMQClient3.Builder().setHost("192.168.52.123").setPort(9111).build();
        build.sendMessage("test");
    }
}
