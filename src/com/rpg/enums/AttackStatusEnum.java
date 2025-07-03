package com.rpg.enums;

/**
 * @author liling
 * @date 2025/7/3 14:27
 * @description
 */
public enum AttackStatusEnum {

    CHARGE("蓄力"),
    ATTACK("攻击"),
    ;

    private final String name;

    AttackStatusEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
