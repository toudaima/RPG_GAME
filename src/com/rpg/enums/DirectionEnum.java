package com.rpg.enums;

import java.util.Random;

/**
 * @author liling
 * @date 2025/7/3 9:25
 * @description
 */
public enum DirectionEnum {

    UP("上"),
    DOWN("下"),
    LEFT("左"),
    RIGHT("右"),
    ;

    private String name;

    DirectionEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static DirectionEnum getRandomDirection() {
        Random random = new Random();
        int abs = Math.abs(random.nextInt() % 4);
        switch (abs) {
            case 0 -> {
                return UP;
            }
            case 1 -> {
                return DOWN;
            }
            case 2 -> {
                return LEFT;
            }
            case 3 -> {
                return RIGHT;
            }
        }
        return null;
    }
}
