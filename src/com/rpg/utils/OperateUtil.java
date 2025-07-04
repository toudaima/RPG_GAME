package com.rpg.utils;

import com.rpg.MainFrame;
import com.rpg.constant.person.UserConstant;
import com.rpg.constant.weapon.PersonHandConstant;
import com.rpg.entity.person.NPC;
import com.rpg.entity.person.PersonEntity;
import com.rpg.entity.weapon.WeaponEntity;
import com.rpg.enums.DirectionEnum;

import java.util.List;

/**
 * @author liling
 * @date 2025/7/3 9:24
 * @description
 */
public class OperateUtil {

    public static void operateNPC(DirectionEnum directionEnum, double speed) {
        List<NPC> npcList = MainFrame.npcList;
        switch (directionEnum) {
            case UP -> {
                for (NPC npc : npcList) {
                    npc.setLastY(npc.getY());
                    npc.setY((int) (npc.getY() + speed));
                }
            }
            case DOWN -> {
                for (NPC npc : npcList) {
                    npc.setLastY(npc.getY());
                    npc.setY((int) (npc.getY() - speed));
                }
            }
            case LEFT -> {
                for (NPC npc : npcList) {
                    npc.setLastX(npc.getX());
                    npc.setX((int) (npc.getX() + speed));
                }
            }
            case RIGHT -> {
                for (NPC npc : npcList) {
                    npc.setLastX(npc.getX());
                    npc.setX((int) (npc.getX() - speed));
                }
            }

        }
    }

    /**
     * 左右手跟随
     * @param directionEnum
     * @param person
     */
    public static void operateHands(DirectionEnum directionEnum, PersonEntity person) {
        final WeaponEntity leftHand = person.getLeftHand();
        final WeaponEntity rightHand = person.getRightHand();
        leftHand.setDirection(person.getDirection());
        rightHand.setDirection(person.getDirection());
        switch (directionEnum) {
            case UP -> {
                //重新设置宽高
                leftHand.setWidth(PersonHandConstant.width);
                leftHand.setHeight(PersonHandConstant.height);
                rightHand.setWidth(PersonHandConstant.width);
                rightHand.setHeight(PersonHandConstant.height);

                leftHand.setX(person.getX() - PersonHandConstant.width);
                leftHand.setY(person.getY() + 5);
                rightHand.setX(person.getX() + person.getWidth());
                rightHand.setY(person.getY() + 5);
            }
            case DOWN -> {
                //重新设置宽高
                leftHand.setWidth(PersonHandConstant.width);
                leftHand.setHeight(PersonHandConstant.height);
                rightHand.setWidth(PersonHandConstant.width);
                rightHand.setHeight(PersonHandConstant.height);

                leftHand.setX(person.getX() + person.getWidth());
                leftHand.setY(person.getY() + 5);
                rightHand.setX(person.getX() - PersonHandConstant.width);
                rightHand.setY(person.getY() + 5);
            }
            case LEFT -> {
                //重新设置宽高
                leftHand.setWidth(PersonHandConstant.height);
                leftHand.setHeight(PersonHandConstant.width);
                rightHand.setWidth(PersonHandConstant.height);
                rightHand.setHeight(PersonHandConstant.width);

                leftHand.setX(person.getX() + PersonHandConstant.width);
                leftHand.setY(person.getY() + UserConstant.userWeight);
                rightHand.setX(person.getX() + PersonHandConstant.width);
                rightHand.setY(person.getY() - PersonHandConstant.width);
            }
            case RIGHT -> {
                //重新设置宽高
                leftHand.setWidth(PersonHandConstant.height);
                leftHand.setHeight(PersonHandConstant.width);
                rightHand.setWidth(PersonHandConstant.height);
                rightHand.setHeight(PersonHandConstant.width);

                rightHand.setX(person.getX() + PersonHandConstant.width);
                rightHand.setY(person.getY() + UserConstant.userWeight);
                leftHand.setX(person.getX() + PersonHandConstant.width);
                leftHand.setY(person.getY() - PersonHandConstant.width);
            }

        }
    }

}
