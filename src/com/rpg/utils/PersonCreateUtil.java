package com.rpg.utils;

import com.rpg.MainFrame;
import com.rpg.constant.weapon.PersonHandConstant;
import com.rpg.entity.weapon.WeaponEntity;
import com.rpg.entity.person.NPC;
import com.rpg.entity.person.User;
import com.rpg.enums.DirectionEnum;
import com.rpg.enums.HandTypeEnum;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author liling
 * @date 2025/7/2 16:35
 * @description
 */
public class PersonCreateUtil {

    public static User createUser(int x, int y, int weight, int height, double speed, MainFrame mainFrame) {
        User user = new User();
        user.setColor(Color.RED);
        user.setX(x);
        user.setY(y);
        user.setWidth(weight);
        user.setHeight(height);
        user.setSpeed(speed);
        user.setMainFrame(mainFrame);
        user.setDirection(DirectionEnum.UP);
        System.out.println("用户坐标：" + x + "," + y);
        user.setLeftHand(WeaponCreateUtil.createPersonHand(x - PersonHandConstant.width, y + 5, user, HandTypeEnum.LEFT_HAND));
        user.setRightHand(WeaponCreateUtil.createPersonHand(x + weight, y + 5, user, HandTypeEnum.RIGHT_HAND));
        mainFrame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_A -> {
                        user.setDirection(DirectionEnum.LEFT);
                        OperateUtil.operateNPC(DirectionEnum.LEFT, user.getSpeed());
                        OperateUtil.operateHands(DirectionEnum.LEFT, user);
                    }
                    case KeyEvent.VK_D -> {
                        user.setDirection(DirectionEnum.RIGHT);
                        OperateUtil.operateNPC(DirectionEnum.RIGHT, user.getSpeed());
                        OperateUtil.operateHands(DirectionEnum.RIGHT, user);
                    }
                    case KeyEvent.VK_W -> {
                        user.setDirection(DirectionEnum.UP);
                        OperateUtil.operateNPC(DirectionEnum.UP, user.getSpeed());
                        OperateUtil.operateHands(DirectionEnum.UP, user);
                    }
                    case KeyEvent.VK_S -> {
                        user.setDirection(DirectionEnum.DOWN);
                        OperateUtil.operateNPC(DirectionEnum.DOWN, user.getSpeed());
                        OperateUtil.operateHands(DirectionEnum.DOWN, user);
                    }
                    case KeyEvent.VK_J -> {
                        System.out.println("左手准备攻击");
                        WeaponEntity leftHand = user.getLeftHand();
                        leftHand.charge();
                    }
                    case KeyEvent.VK_L -> {
                        System.out.println("右手准备攻击");
                        WeaponEntity rightHand = user.getRightHand();
                        rightHand.charge();
                    }
                }

            }
        });
        mainFrame.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_J -> {
                        System.out.println("左手开始攻击");
                        WeaponEntity leftHand = user.getLeftHand();
                        leftHand.attack();
                    }
                    case KeyEvent.VK_L -> {
                        System.out.println("右手开始攻击");
                        WeaponEntity rightHand = user.getRightHand();
                        rightHand.attack();
                    }
                }

            }
        });

        return user;
    }

    public static NPC createNPC(int x, int y, int weight, int height, double speed, MainFrame mainFrame) {
        NPC npc = new NPC();
        npc.setColor(Color.GREEN);
        npc.setX(x);
        npc.setY(y);
        npc.setLastX(x);
        npc.setLastY(y);
        npc.setWidth(weight);
        npc.setHeight(height);
        npc.setSpeed(speed);
        npc.setMainFrame(mainFrame);
        npc.setBlood(100);
        return npc;
    }
}
