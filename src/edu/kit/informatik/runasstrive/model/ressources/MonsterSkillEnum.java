package edu.kit.informatik.runasstrive.model.ressources;

/**
 * This Enum represent the names of the different monster skills
 *
 * @author ucfoh
 * @version 1.0
 */
public enum MonsterSkillEnum {

    /**
     * SCRATCH Skill
     */
    SCRATCH("Scratch"),
    /**
     * CLAW Skill
     */
    CLAW("Claw"),
    /**
     * SMASH Skill
     */
    SMASH("Smash"),
    /**
     * BITE Skill
     */
    BITE("Bite"),
    /**
     * FOCUS Skill
     */
    FOCUS("Focus"),
    /**
     * BLOCK Skill
     */
    BLOCK("Block"),
    /**
     * DEFLECT Skill
     */
    DEFLECT("Deflect"),
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
     * LILGHTNING Skill
     */
    LILGHTNING("Lightning");

    private String name;

    MonsterSkillEnum(String name) {
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
