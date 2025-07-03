package com.rpg.entity.person;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * @author liling
 * @date 2025/7/3 9:20
 * @description
 */
public class NPC extends PersonEntity {

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
    }

}
