package edu.kit.informatik.runasstrive.model.ressources;


/**
 * This enum represents the different names of Runas skills.
 *
 * @author ucfoh
 * @version 1.0
 */
public enum SkillEnum {

    /**
     * SLASH Skill
     */
    SLASH("Slash"),
    /**
     * SWING Skill
     */
    SWING("Swing"),
    /**
     * THRUST Skill
     */
    THRUST("Thrust"),
    /**
     * PIERCE Skill
     */
    PIERCE("Pierce"),
    /**
     * PARRY Skill
     */
    PARRY("Parry"),
    /**
     * FOCUS Skill
     */
    FOCUS("Focus"),
    /**
     * REFLECT Skill
     */
    REFLECT("Reflect"),
    /**
     * WATER Skill
     */
    WATER("Water"),
    /**
     * ICE Skill
     */
    ICE("Ice"),
    /**
     * FIRE Skill
     */
    FIRE("Fire"),
    /**
     * LIGHTNING Skill
     */
    LIGHTNING("Lightning");


    private String name;

    SkillEnum(String name) {
        this.name = name;
    }

    /**
     * Gets name
     *
     * @return value of name
     */
    public String getName() {
        return name;
    }
}
