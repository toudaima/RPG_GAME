package com.rpg.entity.weapon;

import com.rpg.MainFrame;
import com.rpg.constant.person.UserConstant;
import com.rpg.constant.weapon.PersonHandConstant;
import com.rpg.constant.weapon.ability.PunchConstant;
import com.rpg.entity.person.PersonEntity;
import com.rpg.entity.weapon.ability.AbilityEntity;
import com.rpg.entity.weapon.ability.Punch;
import com.rpg.enums.AttackStatusEnum;
import com.rpg.enums.DirectionEnum;
import com.rpg.enums.HandTypeEnum;
import com.rpg.utils.AbilityCreateUtil;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.util.List;

/**
 * @author liling
 * @date 2025/7/3 11:38
 * @description
 */
public class PersonHand extends WeaponEntity {

    private Punch punch;

    public Punch getPunch() {
        return punch;
    }

    public void setPunch(Punch punch) {
        this.punch = punch;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RoundRectangle2D roundRectangle2D = new RoundRectangle2D.Double(this.getX(), this.getY(), this.getWidth(), this.getHeight(), 2, 2);
        g2d.setColor(this.getColor());
        g2d.fill(roundRectangle2D);
        // 绘制边框
        g2d.setColor(Color.BLACK);
        g2d.draw(roundRectangle2D);
    }

    @Override
    public void charge() {
        if (this.getPunch() == null) {
            Punch newPunch = null;
            switch (this.getDirection()) {
                case UP -> {
                    if (this.getHandType() == HandTypeEnum.RIGHT_HAND) {
                        newPunch = AbilityCreateUtil.createPunch(this.getX(), this.getY() - PunchConstant.fightLength, this);
                    } else if (this.getHandType() == HandTypeEnum.LEFT_HAND) {
                        newPunch = AbilityCreateUtil.createPunch(this.getX() - (PunchConstant.width - PersonHandConstant.width), this.getY() - PunchConstant.fightLength, this);
                    }
                } case DOWN -> {
                    if (this.getHandType() == HandTypeEnum.LEFT_HAND) {
                        newPunch = AbilityCreateUtil.createPunch(this.getX(), this.getY(), this);
                    } else if (this.getHandType() == HandTypeEnum.RIGHT_HAND) {
                        newPunch = AbilityCreateUtil.createPunch(this.getX() - (PunchConstant.width - PersonHandConstant.width), this.getY(), this);
                    }
                } case LEFT -> {
                    if (this.getHandType() == HandTypeEnum.LEFT_HAND) {
                        newPunch = AbilityCreateUtil.createPunch(this.getX() - PunchConstant.fightLength, this.getY(), this);
                    } else if (this.getHandType() == HandTypeEnum.RIGHT_HAND) {
                        newPunch = AbilityCreateUtil.createPunch(this.getX() - PunchConstant.fightLength, this.getY()  - (PunchConstant.width - PersonHandConstant.width), this);
                    }

                } case RIGHT -> {
                    if (this.getHandType() == HandTypeEnum.LEFT_HAND) {
                        newPunch = AbilityCreateUtil.createPunch(this.getX(), this.getY() - (PunchConstant.width - PersonHandConstant.width), this);
                    } else if (this.getHandType() == HandTypeEnum.RIGHT_HAND) {
                        newPunch = AbilityCreateUtil.createPunch(this.getX(), this.getY(), this);
                    }

                }
            }
            if (newPunch != null) {
                MainFrame.objectList.add(newPunch);
                MainFrame.abilityEntityList.add(newPunch);
                this.setPunch(newPunch);
            }

        }

    }

    @Override
    public void attack() {
        this.getPunch().setStatus(AttackStatusEnum.ATTACK);
        this.setPunch(null);
    }
}
