package com.masb.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @author Created by yinrg on 2021年11月27日,0027 上午 11:10
 * @fileSimpleName TankFrame
 * @fileName com.masb.tank.TankFrame
 * @description
 */
public class TankFrame extends Frame {

    public static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;
    Tank t = new Tank(this);


    public List<Bullet> getBulletList() {
        return bulletList;
    }

    public void setBulletList(List<Bullet> bulletList) {
        this.bulletList = bulletList;
    }

    private List<Bullet> bulletList = new ArrayList<>();

    public TankFrame() {
        // 设置窗口长宽
        setSize(GAME_WIDTH, GAME_HEIGHT);

        // 设置此框架是否可由用户调整大小
        setResizable(false);

        setTitle("tank war");

        setVisible(true);


        // 键盘监听器,监听按键
        this.addKeyListener(new Tank.MykeyListener());
        // 窗口监听器,可以实现窗口最小化、关闭等
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.black);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);

    }

    @Override
    public void paint(Graphics g) {
        // 获取颜色
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(t.getX(), t.getY(), 50, 50);
        g.drawString("子弹的数量:" + bulletList.size() ,10, 60);
        g.setColor(c);
//        if (bulletList != null && bulletList.size() > 0 ){
//            bulletList.forEach(bullet -> bullet.paint(g));
//        }

//        for (Iterator<Bullet> it = bulletList.iterator();it.hasNext();){
//            Bullet b = it.next();
//            b.paint(g);
//            if (!b.isLive()){
//                it.remove();
//            }
//        }

        for (int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).paint(g);
        }

    }


}
