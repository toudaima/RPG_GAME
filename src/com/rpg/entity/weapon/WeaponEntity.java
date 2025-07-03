package com.rpg.entity.weapon;

import com.rpg.entity.GameEntity;
import com.rpg.entity.person.PersonEntity;
import com.rpg.enums.DirectionEnum;
import com.rpg.enums.HandTypeEnum;
import com.rpg.enums.WeaponEnum;

/**
 * @author liling
 * @date 2025/7/3 11:30
 * @description
 */
public class WeaponEntity extends GameEntity {

    private PersonEntity person;

    private WeaponEnum weaponEnum;

    private DirectionEnum direction;

    private HandTypeEnum handType;

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public WeaponEnum getWeaponEnum() {
        return weaponEnum;
    }

    public void setWeaponEnum(WeaponEnum weaponEnum) {
        this.weaponEnum = weaponEnum;
    }

    public DirectionEnum getDirection() {
        return direction;
    }

    public void setDirection(DirectionEnum direction) {
        this.direction = direction;
    }

    public HandTypeEnum getHandType() {
        return handType;
    }

    public void setHandType(HandTypeEnum handType) {
        this.handType = handType;
    }

    public void charge() {}

    public void attack() {}
}
