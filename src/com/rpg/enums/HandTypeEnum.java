package com.rpg.enums;

/**
 * @author liling
 * @date 2025/7/3 17:01
 * @description
 */
public enum HandTypeEnum {

    LEFT_HAND("左手"),
    RIGHT_HAND("右手"),
    DOUBLE_HAND("双手"),
    ;

    private final String name;

    HandTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
