package com.msb.example01;

import com.msb.example01.builder.HelloBuilder;
import com.msb.example01.director.Director;
import com.msb.example01.product.Bike;

/**
 * @author Created by yinrg on 2023/3/22 23:35
 * @description 客户端
 */
public class Client {
    public static void main(String[] args) {
        // 1.创建指挥者
        Director director = new Director(new HelloBuilder());
        Bike construct = director.construct();
        System.out.println(construct.getFrame());
        System.out.println(construct.getSeat());
    }
}
