package com.masb.tank;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author Created by yinrg on 2021年11月27日,0027 下午 02:39
 * @fileSimpleName Bullet
 * @fileName com.masb.tank.Bullet
 * @description 子弹类
 */
public class Bullet {
    // 子弹移动速度
    private static final int SPEED = 10;
    private static final int WIDTH = 15, HEIGHT = 15;
    private int x, y;

    public boolean isLive() {
        return live;
    }

    // true为子弹活着
    private boolean live = true;
    // 坦克方向
    private int orientation;
    private TankFrame tf;

    public Bullet(int x, int y, int orientation,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        // 子弹死掉
        if (!live) {
            tf.getBulletList().remove(this);
        }
        // 获取颜色
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(c);
        bulletShift();
    }

    private void bulletShift() {
        switch (orientation) {
            case KeyEvent.VK_LEFT:
                x -= SPEED;
                break;
            case KeyEvent.VK_RIGHT:
                x += SPEED;
                break;
            case KeyEvent.VK_UP:
                y -= SPEED;
                break;
            case KeyEvent.VK_DOWN:
                y += SPEED;
                break;
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            live = false;
        }
    }
}
