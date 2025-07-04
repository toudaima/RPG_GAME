package com.rpg.entity.weapon;

import com.rpg.MainFrame;
import com.rpg.constant.weapon.PersonHandConstant;
import com.rpg.constant.weapon.ability.PunchConstant;
import com.rpg.entity.weapon.ability.Punch;
import com.rpg.enums.AttackStatusEnum;
import com.rpg.enums.HandTypeEnum;
import com.rpg.utils.AbilityCreateUtil;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * @author liling
 * @date 2025/7/3 11:38
 * @description
 */
public class PersonHand extends WeaponEntity {

    private Punch punch;

    private AttackStatusEnum attackStatusEnum;

    private long chargeTime;

    private int power;

    public Punch getPunch() {
        return punch;
    }

    public void setPunch(Punch punch) {
        this.punch = punch;
    }

    public AttackStatusEnum getAttackStatusEnum() {
        return attackStatusEnum;
    }

    public void setAttackStatusEnum(AttackStatusEnum attackStatusEnum) {
        this.attackStatusEnum = attackStatusEnum;
    }

    public long getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(long chargeTime) {
        this.chargeTime = chargeTime;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
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
        if (AttackStatusEnum.CHARGE == this.getAttackStatusEnum()) {
            if (System.currentTimeMillis() - this.getChargeTime() >= 3000L) {
                this.setColor(PersonHandConstant.chargeMaxColor);
                this.setPower(PersonHandConstant.power * 10);
            }
        }

    }

    @Override
    public void charge() {
        if (this.getAttackStatusEnum() == null || this.getAttackStatusEnum() == AttackStatusEnum.ATTACK) {
            System.out.println("蓄力中");
            //改变颜色
            this.setColor(PersonHandConstant.chargeOneColor);
            //记录时间
            this.setChargeTime(System.currentTimeMillis());
            //修改蓄力状态
            this.setAttackStatusEnum(AttackStatusEnum.CHARGE);
        }
    }

    @Override
    public void attack() {
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
        }
        this.setAttackStatusEnum(AttackStatusEnum.ATTACK);
        this.setColor(PersonHandConstant.originColor);
    }
}
