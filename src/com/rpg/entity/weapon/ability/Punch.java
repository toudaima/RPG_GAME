package com.rpg.entity.weapon.ability;


import com.rpg.MainFrame;
import com.rpg.constant.weapon.PersonHandConstant;
import com.rpg.constant.weapon.ability.PunchConstant;
import com.rpg.constant.weapon.ability.QiGongConstant;
import com.rpg.entity.person.NPC;
import com.rpg.entity.person.PersonEntity;
import com.rpg.entity.weapon.PersonHand;
import com.rpg.enums.AttackStatusEnum;
import com.rpg.enums.DirectionEnum;
import com.rpg.enums.HarmStatus;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * @author liling
 * @date 2025/7/3 13:43
 * @description
 */
public class Punch extends AbilityEntity {

    private HarmStatus harmStatus;

    private long generateTime;

    private PersonHand personHand;

    private long attackTime;

    private DirectionEnum direction;

    public HarmStatus getHarmStatus() {
        return harmStatus;
    }

    public void setHarmStatus(HarmStatus harmStatus) {
        this.harmStatus = harmStatus;
    }

    public long getGenerateTime() {
        return generateTime;
    }

    public void setGenerateTime(long generateTime) {
        this.generateTime = generateTime;
    }

    public PersonHand getPersonHand() {
        return personHand;
    }

    public void setPersonHand(PersonHand personHand) {
        this.personHand = personHand;
    }

    public long getAttackTime() {
        return attackTime;
    }

    public void setAttackTime(long attackTime) {
        this.attackTime = attackTime;
    }

    public DirectionEnum getDirection() {
        return direction;
    }

    public void setDirection(DirectionEnum direction) {
        this.direction = direction;
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
        switch (this.getDirection()) {
            case UP -> {
                this.setY(this.getPersonHand().getY() - this.getPersonHand().getHeight() - (int)PunchConstant.speed);
            }
            case DOWN -> {
                this.setY(this.getPersonHand().getY() + (int)PunchConstant.speed);
            }
            case LEFT -> {
                this.setX(this.getPersonHand().getX() - this.getPersonHand().getHeight() - (int)PunchConstant.speed);
            }
            case RIGHT -> {
                this.setX(this.getPersonHand().getX() + (int)PunchConstant.speed);
            }
        }

        if (this.getAttackTime() == 0L) {
            this.setAttackTime(System.currentTimeMillis());
        } else {
            if (System.currentTimeMillis() - this.getAttackTime() >= 100L) {
                this.setY(this.getPersonHand().getY() + 100000);
                MainFrame.removeList.add(this);
            }
        }
        //碰撞检测
        impactCheck();
    }

    @Override
    public void impactCheck() {
        for (NPC npc : MainFrame.npcList) {
            if (this.getRectangle().intersects(npc.getRectangle())) {
                if (this.getHarmStatus() == HarmStatus.EFFICIENT) {
                    npc.setBlood(npc.getBlood() - this.getPersonHand().getPower());
                    //防止攻击伤害重复计算
                    this.setHarmStatus(HarmStatus.INVALID);
                    //重置伤害
                    this.getPersonHand().setPower(PersonHandConstant.power);
                }
            }
        }

    }
}
