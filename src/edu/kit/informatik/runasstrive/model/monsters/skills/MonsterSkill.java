package edu.kit.informatik.runasstrive.model.monsters.skills;


import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;

import java.util.Objects;

/**
 * This class models the structure of the monster skill.
 *
 * @author ucfoh
 * @version 1.0
 */
public abstract class MonsterSkill {

    /**
     * The name of the Skill as an Enum
     */
    protected MonsterSkillEnum name;
    /**
     * The level of the Skill
     */
    protected int skillLevel;
    /**
     * the amount of focus points the skill costs
     */
    protected int cost;

    /**
     * The public constructor for the monster skill
     *
     * @param name       of the Skill as enum
     * @param skillLevel level of the skill
     * @param cost       cost of the skill
     */
    protected MonsterSkill(MonsterSkillEnum name, int skillLevel, int cost) {
        this.name = name;
        this.skillLevel = skillLevel;
        this.cost = cost;
    }

    /**
     * The execute method for the monster skill.
     *
     * @param monster user of the skill
     * @param runa    target of the skill
     */
    public abstract void execute(Monster monster, Runa runa);

    /**
     * Gets cost
     *
     * @return the cost of the skill
     */
    public int getCost() {
        return cost;
    }

    /**
     * Gets name
     *
     * @return value of name
     */
    public MonsterSkillEnum getType() {
        return name;
    }

    /**
     * Gets skillLevel
     *
     * @return value of skillLevel
     */
    public int getSkillLevel() {
        return skillLevel;
    }


    @Override
    public String toString() {
        return name.getName() + "(" + skillLevel + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonsterSkill that = (MonsterSkill) o;
        return skillLevel == that.skillLevel && name == that.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, skillLevel);
    }
}


