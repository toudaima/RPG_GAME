package com.rpg;

import com.rpg.entity.GameEntity;
import com.rpg.entity.NPC;
import com.rpg.entity.QiGong;
import com.rpg.entity.User;
import com.rpg.utils.CreateUtil;
import com.rpg.utils.ImageUtil;

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
    private final static int userWeight = 30;
    private final static int userHeight = 30;

    private Image flushImage;

    User user = CreateUtil.createUser(width / 2 - userWeight / 2, height / 2 - userHeight / 2, 30, 30, 5, this);
    NPC npc = CreateUtil.createNPC(width / 2 - userWeight / 2, 100, 30, 30, 1, this);

    public static List<GameEntity> objectList = new ArrayList<>();
    public static List<NPC> npcList = new ArrayList<>();
    public static List<QiGong> qiGongList = new ArrayList<>();
    public static List<GameEntity> removeList = new ArrayList<>();

    public void launch() {
        this.setVisible(true);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setTitle("战斗爽");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.status = 0;
        objectList.add(user);
        objectList.add(npc);
        npcList.add(npc);
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
        qiGongList.removeAll(MainFrame.removeList);
    }

    public static void main(String[] args) {
        MainFrame gf = new MainFrame();
        gf.launch();
    }

}