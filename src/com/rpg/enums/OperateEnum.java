package com.rpg.enums;

/**
 * @author liling
 * @date 2025/7/3 9:25
 * @description
 */
public enum OperateEnum {

    UP("上"),
    DOWN("下"),
    LEFT("左"),
    RIGHT("右"),
    ;

    private String name;

    OperateEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
