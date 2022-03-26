package edu.kit.informatik.runasstrive.model.skills;

import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.RunaSkillEnum;

import java.util.Objects;

/**
 * This class models the structure of the Skills for Runa
 *
 * @author ucfoh
 * @version 1.0
 */
public abstract class Skill {

    /**
     * level of the skill
     */
    protected int skillLevel;
    /**
     * Boolean if the skill is defensive or not
     */
    protected boolean isDefensive;
    /**
     * Integer of the amount the skill costs to use
     */
    protected int cost;
    /**
     * name of the skill as enum
     */
    protected RunaSkillEnum runaSkillName;

    /**
     * public constructor for the skill
     *
     * @param name        of the skill as enum
     * @param skillLevel  level of the skill
     * @param isDefensive if the skill is defensive or not
     * @param cost        cost of the skill
     */
    protected Skill(RunaSkillEnum name, int skillLevel, boolean isDefensive, int cost) {
        this.runaSkillName = name;
        this.skillLevel = skillLevel;
        this.isDefensive = isDefensive;
        this.cost = cost;
    }

    /**
     * The execute method for the skill.
     *
     * @param diceNumber  the dice number the user inputs
     * @param target      the target of the skill
     * @param focusPoints the amount of focus points runa has when she executes the skill
     * @param runa        {@link Runa}
     */
    public abstract void execute(int diceNumber, Monster target, int focusPoints, Runa runa);

    /**
     * Gets isDefensive
     *
     * @return value of isDefensive
     */
    public boolean isDefensive() {
        return isDefensive;
    }

    /**
     * returns the type of the Skill (Enum of the skill name)
     *
     * @return the name
     */
    public RunaSkillEnum getType() {
        return runaSkillName;
    }

    /**
     * Gets cost
     *
     * @return value of cost
     */
    public int getCost() {
        return cost;
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
        return runaSkillName.getName() + "(" + skillLevel + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return skillLevel == skill.skillLevel && runaSkillName == skill.runaSkillName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(skillLevel, runaSkillName);
    }
}
