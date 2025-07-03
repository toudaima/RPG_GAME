package com.rpg.entity;

import com.rpg.constant.QiGongConstant;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * @author liling
 * @date 2025/7/2 17:29
 * @description
 */
public class QiGong extends GameEntity{

    private int status;

    private long generateTime;

    private int power;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getGenerateTime() {
        return generateTime;
    }

    public void setGenerateTime(long generateTime) {
        this.generateTime = generateTime;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RoundRectangle2D roundRectangle2D = new RoundRectangle2D.Double(this.getX(), this.getY(), this.getWidth(), this.getHeight(), 2, 10);
        g2d.setColor(this.getColor());
        g2d.fill(roundRectangle2D);
        // 绘制边框
        g2d.setColor(Color.BLACK);
        g2d.draw(roundRectangle2D);
        if (status == 0) {
            if (System.currentTimeMillis() - generateTime >= 3000L) {
                this.setColor(Color.CYAN);
                this.setWidth(QiGongConstant.weight * 3);
                this.setPower(QiGongConstant.power * 4);
            } else if (System.currentTimeMillis() - generateTime >= 1000L) {
                this.setColor(Color.PINK);
                this.setWidth(QiGongConstant.weight * 2);
                this.setPower(QiGongConstant.power * 2);
            }
        } else if (status == 1) {
            this.setY((int)(this.getY() - this.getSpeed()));
            this.setSpeed(this.getSpeed() + 0.5);
        }

    }
}
