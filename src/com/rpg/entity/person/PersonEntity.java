package com.rpg.entity.person;

import com.rpg.entity.GameEntity;
import com.rpg.entity.weapon.WeaponEntity;
import com.rpg.enums.DirectionEnum;

/**
 * @author liling
 * @date 2025/7/3 13:55
 * @description
 */
public class PersonEntity extends GameEntity {

    private WeaponEntity rightHand;

    private WeaponEntity leftHand;

    private DirectionEnum direction;

    public WeaponEntity getRightHand() {
        return rightHand;
    }

    public void setRightHand(WeaponEntity rightHand) {
        this.rightHand = rightHand;
    }

    public WeaponEntity getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(WeaponEntity leftHand) {
        this.leftHand = leftHand;
    }

    public DirectionEnum getDirection() {
        return direction;
    }

    public void setDirection(DirectionEnum direction) {
        this.direction = direction;
    }
}
