package com.rpg.entity;

import com.rpg.MainFrame;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * @author liling
 * @date 2025/7/3 9:20
 * @description
 */
public class NPC extends GameEntity{

    private int blood;

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RoundRectangle2D roundRectangle2D = new RoundRectangle2D.Double(this.getX(), this.getY(), this.getWidth(), this.getHeight(), 10, 10);
        g2d.setColor(this.getColor());
        g2d.fill(roundRectangle2D);
        g2d.drawString(String.valueOf(this.getBlood()), this.getX(), this.getY());
        // 绘制边框
        g2d.setColor(Color.BLACK);
        g2d.draw(roundRectangle2D);
        for (QiGong qiGong : MainFrame.qiGongList) {
            if (this.getRectangle().intersects(qiGong.getRectangle())) {
                this.blood -= qiGong.getPower();
                qiGong.setY(qiGong.getY() - 10000);
                MainFrame.removeList.add(qiGong);
            }
            if (this.getBlood() <= 0) {
                this.setY(this.getY() - 10000);
                MainFrame.removeList.add(this);
            }
        }

    }

}
