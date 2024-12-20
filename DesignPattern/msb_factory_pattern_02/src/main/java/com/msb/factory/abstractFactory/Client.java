package com.msb.factory.abstractFactory;

import com.msb.factory.abstractFactory.factory.AppliancesFactory;
import com.msb.factory.abstractFactory.factory.HairFactory;
import com.msb.factory.abstractFactory.product.AbstractFreezer;
import com.msb.factory.abstractFactory.product.AbstractTV;
import lombok.Data;

/**
 * @author Created by yinrg on 2023/3/21 22:51
 * @description 客户端
 * 在理解抽象工厂模式原理的时候，需要记住"如何找到某一类产品的正确共性功能"这个重点
 * JDBC的实现就是抽象工厂模式
 */

@Data
public class Client {

    private AppliancesFactory appliancesFactory;

    private AbstractTV abstractTV;

    private AbstractFreezer abstractFreezer;


    public Client(AppliancesFactory appliancesFactory) {
        this.appliancesFactory = appliancesFactory;
        this.abstractTV = this.appliancesFactory.createTV();
        this.abstractFreezer = this.appliancesFactory.createFreezer();
    }

    public static void main(String[] args) {
        Client client = new Client(new HairFactory());
        System.out.println(client.abstractTV);
        System.out.println(client.abstractFreezer);
    }
}
