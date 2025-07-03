package com.rpg.entity;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * @author liling
 * @date 2025/7/2 16:34
 * @description
 */
public class User extends GameEntity {

    private QiGong qiGong;

    public QiGong getQiGong() {
        return qiGong;
    }

    public void setQiGong(QiGong qiGong) {
        this.qiGong = qiGong;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RoundRectangle2D roundRectangle2D = new RoundRectangle2D.Double(this.getX(), this.getY(), this.getWidth(), this.getHeight(), 10, 10);
        g2d.setColor(this.getColor());
        g2d.fill(roundRectangle2D);
        // 绘制边框
        g2d.setColor(Color.BLACK);
        g2d.draw(roundRectangle2D);
    }
}
