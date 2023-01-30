package com.masb.tank;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author Created by yinrg on 2021年11月27日,0027 下午 04:03
 * @fileSimpleName Tank
 * @fileName com.masb.tank.Tank
 * @description
 */
public class Tank {

    private static int x = 200, y = 200;
    // 移动速度
    private static final int SPEED = 5 ;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static boolean isbL() {
        return bL;
    }

    public static boolean isbR() {
        return bR;
    }

    public static boolean isbU() {
        return bU;
    }

    public static boolean isbD() {
        return bD;
    }

    // 左
    private static boolean bL = false;
    // 右
    private static boolean bR = false;
    // 上
    private static boolean bU = false;
    // 下
    private static boolean bD = false;

    // 坦克调头顺序
    private static Set<Integer> orientationSet = new LinkedHashSet<>();
    // 坦克方向
    private static int orientation ;

    private static TankFrame tf;

    public Tank(TankFrame tf) {
        this.tf = tf;
    }

    public static class MykeyListener extends KeyAdapter {

        /**
         * 按键被按下去的时候调用
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {
            // 获取方向按键
            int  key = e.getKeyCode();

            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = true;
                    orientationSet.add(KeyEvent.VK_LEFT);
                    break;

                case KeyEvent.VK_RIGHT:
                    bR = true;
                    orientationSet.add(KeyEvent.VK_RIGHT);
                    break;

                case KeyEvent.VK_UP:
                    bU = true;
                    orientationSet.add(KeyEvent.VK_UP);
                    break;

                case KeyEvent.VK_DOWN:
                    bD = true;
                    orientationSet.add(KeyEvent.VK_DOWN);
                    break;

                default:
                    break;
            }
            shift(bL,bR,bU,bD);
        }

        /**
         * 按键被抬起来的时候调用
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
            int  key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    orientationSet.remove(KeyEvent.VK_LEFT);
                    break;

                case KeyEvent.VK_RIGHT:
                    bR = false;
                    orientationSet.remove(KeyEvent.VK_RIGHT);
                    break;

                case KeyEvent.VK_UP:
                    bU = false;
                    orientationSet.remove(KeyEvent.VK_UP);
                    break;

                case KeyEvent.VK_DOWN:
                    bD = false;
                    orientationSet.remove(KeyEvent.VK_DOWN);
                    break;
                case KeyEvent.VK_CONTROL:
                    // 发射子弹
                    this.fire();
                    break;

                default:
                    break;
            }
        }

        /**
         * 发射子弹
         */
        private void fire() {
            if (orientation == 0){
                orientation =  KeyEvent.VK_UP;
            }
            // 将子弹存入字典List中
            tf.getBulletList().add(new Bullet(x,y,orientation,tf));
        }

        /**
         * 根据方向的布尔值修改移动值
         * @param bl
         * @param br
         * @param bu
         * @param bd
         */
        public void shift(Boolean bl,Boolean br,Boolean bu,Boolean bd){
            if (bl){
                x -= SPEED;
            }
            if (br){
                x += SPEED;
            }
            if (bu){
                y -= SPEED;
            }
            if (bd){
                y += SPEED;
            }

            // 为坦克方向赋值
            Optional<Integer> first = orientationSet.stream().findFirst();
            first.ifPresent(integer -> orientation = integer);
        }
    }
}
