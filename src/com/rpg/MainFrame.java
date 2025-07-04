package com.rpg;

import com.rpg.constant.person.UserConstant;
import com.rpg.entity.GameEntity;
import com.rpg.entity.person.NPC;
import com.rpg.entity.person.PersonEntity;
import com.rpg.entity.weapon.ability.AbilityEntity;
import com.rpg.entity.weapon.ability.QiGong;
import com.rpg.entity.person.User;
import com.rpg.utils.PersonCreateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @author liling
 * @date 2025/7/2 11:09
 * @description
 */
public class MainFrame extends JFrame {

    private int status;

    private final static int width = 1200;
    private final static int height = 800;


    private Image flushImage;

    public static List<GameEntity> objectList = new ArrayList<>();
    public static List<NPC> npcList = new ArrayList<>();
    public static List<AbilityEntity> abilityEntityList = new ArrayList<>();
    public static List<GameEntity> removeList = new ArrayList<>();

    public static User user;

    public void launch() {
        this.setVisible(true);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setTitle("战斗爽");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.status = 0;

        User newUser = PersonCreateUtil.createUser(width / 2, height / 2, UserConstant.userWeight, UserConstant.userHeight, 5, this);
        NPC npc = PersonCreateUtil.createNPC(width / 2 - UserConstant.userWeight / 2, 100, 30, 30, 1, this);
        objectList.add(newUser);
        objectList.add(npc);
        npcList.add(npc);
        user = newUser;
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && status == 0) {
                    status = 1;
                    repaint();
                }
            }
        });
        while (true) {
            repaint();
            LockSupport.parkNanos(25 * 1000L);
        }
    }

    @Override
    public void paint(Graphics g) {
        if (flushImage == null) {
            flushImage = createImage(width, height);
        }
        Graphics graphics = flushImage.getGraphics();
        graphics.fillRect(0, 0, width, height);
        if (status == 0) {
            graphics.setColor(Color.BLACK);
            graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
            graphics.setColor(Color.WHITE);
            graphics.setFont(new Font("宋体", Font.BOLD, 20));
            graphics.drawString("点击开始", 550, 400);

        }
        else if (status == 1) {
            graphics.setColor(Color.BLACK);
            graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
//            g.setColor(Color.WHITE);
//            g.setFont(new Font("宋体", Font.BOLD, 20));
//            g.drawString("来了来了", 550, 400);
            for (GameEntity obj : objectList) {
                obj.draw(graphics);
            }
        }
        g.drawImage(flushImage, 0, 0, null);
        objectList.removeAll(MainFrame.removeList);
        npcList.removeAll(MainFrame.removeList);
        abilityEntityList.removeAll(MainFrame.removeList);
    }

    public static void main(String[] args) {
        MainFrame gf = new MainFrame();
        gf.launch();
    }

}