package com.rpg.enums;

/**
 * @author liling
 * @date 2025/7/4 10:05
 * @description
 */
public enum HarmStatus {

    EFFICIENT("有效"),
    INVALID("无效"),
    ;
    private final String name;

    HarmStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
