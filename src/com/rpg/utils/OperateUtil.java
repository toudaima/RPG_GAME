package com.rpg.utils;

import com.rpg.MainFrame;
import com.rpg.entity.NPC;
import com.rpg.enums.OperateEnum;

import java.util.List;

/**
 * @author liling
 * @date 2025/7/3 9:24
 * @description
 */
public class OperateUtil {

    public static void operateNPC(OperateEnum operateEnum, double speed) {
        List<NPC> npcList = MainFrame.npcList;
        switch (operateEnum) {
            case UP -> {
                for (NPC npc : npcList) {
                    System.out.println("npc位置：" + npc.getX() + "," + npc.getY());
                    npc.setY((int) (npc.getY() + speed));
                }
            }
            case DOWN -> {
                for (NPC npc : npcList) {
                    System.out.println("npc位置：" + npc.getX() + "," + npc.getY());
                    npc.setY((int) (npc.getY() - speed));
                }
            }
            case LEFT -> {
                for (NPC npc : npcList) {
                    System.out.println("npc位置：" + npc.getX() + "," + npc.getY());
                    npc.setX((int) (npc.getX() + speed));
                }
            }
            case RIGHT -> {
                for (NPC npc : npcList) {
                    System.out.println("npc位置：" + npc.getX() + "," + npc.getY());
                    npc.setX((int) (npc.getX() - speed));
                }
            }

        }
    }
}
