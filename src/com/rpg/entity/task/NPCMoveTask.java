package com.rpg.entity.task;

import com.rpg.MainFrame;
import com.rpg.entity.person.NPC;
import com.rpg.enums.DirectionEnum;
import com.rpg.utils.OperateUtil;

import java.util.concurrent.locks.LockSupport;

/**
 * @author liling
 * @date 2025/7/4 12:56
 * @description
 */
public class NPCMoveTask {

    public static void start() {
//        new Thread(() -> {
//            while (true) {
                System.out.println("移动NPC");
                for (NPC npc : MainFrame.npcList) {
                    DirectionEnum randomDirection = DirectionEnum.getRandomDirection();
                    if (randomDirection != null) {
                        OperateUtil.operateNPC(randomDirection, npc.getSpeed() * 5);
                    }
                }
//                LockSupport.parkNanos(5 * 1000L);
//            }
//        }).start();
    }
}
