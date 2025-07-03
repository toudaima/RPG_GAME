package com.rpg.entity.weapon;

import com.rpg.entity.weapon.ability.QiGong;

/**
 * @author liling
 * @date 2025/7/3 11:37
 * @description
 */
public class QiGongGlove extends WeaponEntity {

    private QiGong qiGong;

    public QiGong getQiGong() {
        return qiGong;
    }

    public void setQiGong(QiGong qiGong) {
        this.qiGong = qiGong;
    }
}
