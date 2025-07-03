package com.rpg.entity.weapon.ability;


import com.rpg.MainFrame;
import com.rpg.constant.weapon.ability.PunchConstant;
import com.rpg.constant.weapon.ability.QiGongConstant;
import com.rpg.entity.weapon.PersonHand;
import com.rpg.enums.AttackStatusEnum;
import com.rpg.enums.DirectionEnum;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * @author liling
 * @date 2025/7/3 13:43
 * @description
 */
public class Punch extends AbilityEntity {

    private AttackStatusEnum status;

    private long generateTime;

    private int power;

    private PersonHand personHand;

    private long attackTime;

    private DirectionEnum direction;

    public AttackStatusEnum getStatus() {
        return status;
    }

    public void setStatus(AttackStatusEnum status) {
        this.status = status;
    }

    public long getGenerateTime() {
        return generateTime;
    }

    public void setGenerateTime(long generateTime) {
        this.generateTime = generateTime;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
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
        if (this.status == AttackStatusEnum.ATTACK) {
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

        } else if (this.status == AttackStatusEnum.CHARGE) {
            if (System.currentTimeMillis() - this.getGenerateTime() >= 3000L) {
                this.setColor(PunchConstant.chargeOneColor);
            }
        }

    }
}
