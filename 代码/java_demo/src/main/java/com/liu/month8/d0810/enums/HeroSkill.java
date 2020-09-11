package com.liu.month8.d0810.enums;

/**
 * ClassName: HeroSkill <br/>
 * Description: <br/>
 * date: 2020/8/10 14:59<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public enum HeroSkill {
    Q("离手之器", "Q", "向指定方向掷一柄长矛，造成320伤害，减速20%"),
    W("不破之盾", "W", "身体包裹一层护盾，可以减少一定伤害"),
    E("亢奋", "E", "增幅一定的移动速度，期间霸体"),
    R("破甲神矛", "R", "长矛短距离刺向指定英雄，造成450真实伤害，减少英雄20%输出");

    private HeroSkill(String skillName, String keyCode, String skillDesc) {
        this.skillName = skillName;
        this.skillDesc = skillDesc;
        this.keyCode = keyCode;
    }

    private final String skillName;
    private final String keyCode;
    private final String skillDesc;

    public String getSkillName() {
        return skillName;
    }

    public String getKeyCode() {
        return keyCode;
    }

    public String getSkillDesc() {
        return skillDesc;
    }

    @Override
    public String toString() {
        return "HeroSkill{" +
                "skillName='" + skillName + '\'' +
                ", keyCode='" + keyCode + '\'' +
                ", skillDesc='" + skillDesc + '\'' +
                '}';
    }
}
