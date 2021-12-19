package com.masb.tank;

/**
 * @author Created by yinrg on 2021年11月27日,0027 上午 10:53
 * @fileSimpleName T
 * @fileName com.masb.tank.T
 * @description
 */

public class T {

    public static void main(String[] args) throws InterruptedException {
        TankFrame f = new TankFrame();
        while (true) {
            Thread.sleep(50);
            f.repaint();
        }

    }
}
