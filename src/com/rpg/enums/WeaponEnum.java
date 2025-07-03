package com.rpg.enums;

/**
 * @author liling
 * @date 2025/7/3 11:31
 * @description
 */
public enum WeaponEnum {

    PERSON_HAND("人类自己的手"),
    QI_GONG_GLOVE("气功手套"),
    ;

    private final String name;

    WeaponEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
