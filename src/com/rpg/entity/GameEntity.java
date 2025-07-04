package com.rpg.entity;

import com.rpg.MainFrame;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * @author liling
 * @date 2025/7/2 14:18
 * @description
 */
public class GameEntity {

    private Color color;

    private int x;

    private int y;

    private int width;

    private int height;

    private double speed;

    private MainFrame mainFrame;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public GameEntity() {
    }

    public void draw(Graphics g) {

    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, width, height);
    }

    public void impactCheck() {}
}
