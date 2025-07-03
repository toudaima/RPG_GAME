package com.rpg.utils;

import com.rpg.MainFrame;
import com.rpg.constant.QiGongConstant;
import com.rpg.entity.GameEntity;
import com.rpg.entity.NPC;
import com.rpg.entity.QiGong;
import com.rpg.entity.User;
import com.rpg.enums.OperateEnum;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author liling
 * @date 2025/7/2 16:35
 * @description
 */
public class CreateUtil {

    public static User createUser(int x, int y, int weight, int height, double speed, MainFrame mainFrame) {
        User user = new User();
        user.setColor(Color.RED);
        user.setX(x);
        user.setY(y);
        user.setWidth(weight);
        user.setHeight(height);
        user.setSpeed(speed);
        user.setMainFrame(mainFrame);
        mainFrame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_A -> {
                        System.out.println("向左： " + user.getX());
                        OperateUtil.operateNPC(OperateEnum.LEFT, user.getSpeed());
                    }
                    case KeyEvent.VK_D -> {
                        System.out.println("向右：" + user.getX());
                        OperateUtil.operateNPC(OperateEnum.RIGHT, user.getSpeed());
                    }
                    case KeyEvent.VK_W -> {
                        System.out.println("向上：" + user.getY());
                        OperateUtil.operateNPC(OperateEnum.UP, user.getSpeed());
                    }
                    case KeyEvent.VK_S -> {
                        System.out.println("向下：" + user.getY());
                        OperateUtil.operateNPC(OperateEnum.DOWN, user.getSpeed());
                    }
                    case KeyEvent.VK_J -> {
                        System.out.println("气功蓄力");
                        if (user.getQiGong() == null) {
                            QiGong qiGong = createQiGong(user.getX() + 10, user.getY() - 20, user.getMainFrame());
                            user.setQiGong(qiGong);
                            MainFrame.objectList.add(qiGong);
                            MainFrame.qiGongList.add(qiGong);
                        }
                    }
                }

            }
        });
        mainFrame.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_J -> {
                        System.out.println("气功发射");
                        if (user.getQiGong() != null) {
                            user.getQiGong().setStatus(1);
                            user.setQiGong(null);
                        }
                    }
                }

            }
        });

        return user;
    }

    public static QiGong createQiGong(int x, int y, MainFrame mainFrame) {
        QiGong qiGong = new QiGong();
        qiGong.setColor(Color.YELLOW);
        qiGong.setX(x);
        qiGong.setY(y);
        qiGong.setWidth(QiGongConstant.weight);
        qiGong.setHeight(QiGongConstant.height);
        qiGong.setSpeed(QiGongConstant.speed);
        qiGong.setPower(QiGongConstant.power);
        qiGong.setMainFrame(mainFrame);
        qiGong.setStatus(0);
        qiGong.setGenerateTime(System.currentTimeMillis());
        return qiGong;
    }

    public static NPC createNPC(int x, int y, int weight, int height, double speed, MainFrame mainFrame) {
        NPC npc = new NPC();
        npc.setColor(Color.GREEN);
        npc.setX(x);
        npc.setY(y);
        npc.setWidth(weight);
        npc.setHeight(height);
        npc.setSpeed(speed);
        npc.setMainFrame(mainFrame);
        npc.setBlood(100);
        return npc;
    }
}
