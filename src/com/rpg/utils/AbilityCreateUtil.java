package com.rpg.utils;

import com.rpg.MainFrame;
import com.rpg.constant.weapon.ability.PunchConstant;
import com.rpg.constant.weapon.ability.QiGongConstant;
import com.rpg.entity.weapon.PersonHand;
import com.rpg.entity.weapon.ability.Punch;
import com.rpg.entity.weapon.ability.QiGong;
import com.rpg.enums.AttackStatusEnum;
import com.rpg.enums.DirectionEnum;
import com.rpg.enums.HarmStatus;

import java.awt.*;

/**
 * @author liling
 * @date 2025/7/3 11:47
 * @description 生成能力的工具
 */
public class AbilityCreateUtil {

    public static QiGong createQiGong(int x, int y, MainFrame mainFrame) {
        QiGong qiGong = new QiGong();
        qiGong.setColor(Color.YELLOW);
        qiGong.setX(x);
        qiGong.setY(y);
        qiGong.setWidth(QiGongConstant.width);
        qiGong.setHeight(QiGongConstant.height);
        qiGong.setSpeed(QiGongConstant.speed);
        qiGong.setPower(QiGongConstant.power);
        qiGong.setMainFrame(mainFrame);
        qiGong.setStatus(0);
        qiGong.setGenerateTime(System.currentTimeMillis());
        return qiGong;
    }

    /**
     * 生成拳头
     * @param x
     * @param y
     * @param personHand
     * @return
     */
    public static Punch createPunch(int x, int y, PersonHand personHand) {
        Punch punch = new Punch();
        punch.setColor(personHand.getColor());
        punch.setX(x);
        punch.setY(y);
        if (personHand.getDirection() == DirectionEnum.LEFT || personHand.getDirection() == DirectionEnum.RIGHT) {
            punch.setWidth(PunchConstant.height);
            punch.setHeight(PunchConstant.width);
        } else {
            punch.setWidth(PunchConstant.width);
            punch.setHeight(PunchConstant.height);
        }

        punch.setSpeed(PunchConstant.speed);
        punch.setMainFrame(personHand.getMainFrame());
        punch.setGenerateTime(System.currentTimeMillis());
        punch.setPersonHand(personHand);
        punch.setDirection(personHand.getDirection());
        punch.setHarmStatus(HarmStatus.EFFICIENT);
        return punch;
    }
}
