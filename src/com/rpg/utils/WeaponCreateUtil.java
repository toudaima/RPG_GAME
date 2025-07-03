package com.rpg.utils;

import com.rpg.MainFrame;
import com.rpg.constant.weapon.PersonHandConstant;
import com.rpg.entity.person.User;
import com.rpg.entity.weapon.PersonHand;
import com.rpg.enums.HandTypeEnum;
import com.rpg.enums.WeaponEnum;

import java.awt.*;

/**
 * @author liling
 * @date 2025/7/3 11:42
 * @description
 */
public class WeaponCreateUtil {

    public static PersonHand createPersonHand(int x, int y, User user, HandTypeEnum handTypeEnum) {
        System.out.println("手坐标：" + x + "," + y);
        PersonHand personHand = new PersonHand();
        personHand.setWeaponEnum(WeaponEnum.PERSON_HAND);
        personHand.setColor(PersonHandConstant.originColor);
        personHand.setX(x);
        personHand.setY(y);
        personHand.setWidth(PersonHandConstant.width);
        personHand.setHeight(PersonHandConstant.height);
        personHand.setSpeed(PersonHandConstant.speed);
        personHand.setMainFrame(user.getMainFrame());
        personHand.setPerson(user);
        personHand.setDirection(user.getDirection());
        personHand.setHandType(handTypeEnum);
        MainFrame.objectList.add(personHand);
        return personHand;
    }
}
