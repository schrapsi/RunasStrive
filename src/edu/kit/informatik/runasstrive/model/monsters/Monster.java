package edu.kit.informatik.runasstrive.model.monsters;

import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.monsters.skills.MonsterSkill;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.DeflectMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.FocusMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.physical.BlockMonsterSkill;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.ui.ressources.Message;

import java.util.List;
import java.util.Objects;

/**
 * This class models the structure for the monsters.
 *
 * @author ucfoh
 * @version 1.0
 */
public class Monster {


    private static final int DEFLECT_MULTIPLIER = 11;
    private static final int BLOCK_MULTIPLIER = 7;
    /**
     * Boolean state if the monster is alive or not.
     */
    protected boolean alive = true;
    /**
     * Name of the Monster
     */
    protected String name;
    /**
     * Integer for the health points of the Monster.
     */
    protected int healthPoints;
    /**
     * Integer for the focus points of the Monster
     */
    protected int focusPoints;
    /**
     * Type enum for the monster type.
     */
    protected Type type;
    /**
     * Index of the next skill the monster is about to execute.
     */
    protected int nextSkill;
    /**
     * Boolean state if the monster is focused or not (used the {@link FocusMonsterSkill})
     */
    protected boolean isFocused = false;
    /**
     * The Amount of Focus points added in the next round if the Monster is still focused.
     */
    protected int amountOfFocusAddedNextRound;
    /**
     * The skillList inherits all the Skill the monster can use.
     */
    protected List<MonsterSkill> skillList;
    /**
     * The {@link MonsterSkill} the Monster used in the round before (important for the Focus evaluation)
     */
    protected MonsterSkill usedSkill;

    /**
     * Public constructor for the Monster.
     *
     * @param healthPoints health points of the monster
     * @param type         type of the monster
     * @param name         name of the monster
     * @param skillList    skills of the monster
     */
    public Monster(int healthPoints, Type type, String name, List<MonsterSkill> skillList) {
        this.healthPoints = healthPoints;
        this.type = type;
        this.name = name;
        this.nextSkill = 0;
        this.skillList = skillList;

    }

    /**
     * Return the next monster skill
     *
     * @return next monster skill from the next skill index
     */
    public MonsterSkill getNextSkill() {
        return skillList.get(nextSkill);
    }

    /**
     * This Method represents the turn of the Monsters.
     * It needs {@link Runa} as parameter to execute the {@link MonsterSkill} against Runa.
     *
     * @param runa {@link Runa}
     */
    public void monsterTurn(Runa runa) {

        if (focusPoints < skillList.get(nextSkill).getCost()) {
            if (nextSkill == skillList.size() - 1) {
                nextSkill = 0;
            } else {
                nextSkill++;
            }
        }
        Message.monsterUseSkill(this);
        skillList.get(nextSkill).execute(this, runa);
        usedSkill = skillList.get(nextSkill);
        if (nextSkill == skillList.size() - 1) {
            nextSkill = 0;
        } else {
            nextSkill++;
        }
    }

    /**
     * This method calculates and executes the taken magical damage.
     * If the last skill was the {@link DeflectMonsterSkill} the Method reduces the Damage
     *
     * @param rawDamage the raw damage the monster takes
     */
    public void takeMagicalDamage(int rawDamage) {

        int damage = rawDamage;

        MonsterSkill monsterSkill = usedSkill;

        if (monsterSkill != null && monsterSkill.getType().equals(MonsterSkillEnum.DEFLECT)) {
            if (damage > (DEFLECT_MULTIPLIER * monsterSkill.getSkillLevel()) + 2) {
                damage = damage - ((DEFLECT_MULTIPLIER * monsterSkill.getSkillLevel()) + 2);
            } else {
                damage = 0;
            }
        }


        healthPoints -= damage;
        if (healthPoints < 1) {
            alive = false;
            healthPoints = 0;
        }
        Message.monsterTakeMagicalDamage(this, damage);

    }

    /**
     * This method calculates and executes the taken physical damage.
     * If the last skill was the {@link BlockMonsterSkill} the Method reduces the Damage
     *
     * @param rawDamage the raw damage the monster takes
     */
    public void takePhysicalDamage(int rawDamage) {

        int damage = rawDamage;

        MonsterSkill monsterSkill = usedSkill;

        if (monsterSkill != null && monsterSkill.getType().equals(MonsterSkillEnum.BLOCK)) {
            if (damage > BLOCK_MULTIPLIER * monsterSkill.getSkillLevel()) {
                damage = damage - BLOCK_MULTIPLIER * monsterSkill.getSkillLevel();
            } else {
                damage = 0;
            }
        }

        healthPoints -= damage;
        if (healthPoints < 1) {
            alive = false;
            healthPoints = 0;
        }
        Message.monsterTakePhysicalDamage(this, damage);

    }

    /**
     * Method to get the Name, healt hpoints and focus points as string.
     *
     * @return the string with the stats
     */
    public String toStringWithStats() {
        return name + " (" + healthPoints + " HP, " + focusPoints + " FP)";
    }


    @Override
    public String toString() {
        return name;
    }

    /**
     * Gets type
     *
     * @return value of type
     */
    public Type getType() {
        return type;
    }

    /**
     * returns if the monster is dead or not
     *
     * @return if monster is dead or not
     */
    public boolean isDead() {
        return !alive;
    }

    /**
     * Gets name
     *
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the monster to focus and saves the amount of focus point added in the next Round
     *
     * @param amount of focus the monster would get
     */
    public void focus(int amount) {
        amountOfFocusAddedNextRound = amount;
        isFocused = true;
    }

    /**
     * breaks the focus of the monster and resets the amount of focus points
     */
    public void breakFocus() {
        isFocused = false;
        amountOfFocusAddedNextRound = 0;
    }

    /**
     * Returns if the monster is focused or not.
     *
     * @return if the is focused
     */
    public boolean isFocused() {
        return isFocused;
    }

    /**
     * Gives the monster the amount ({@link #amountOfFocusAddedNextRound}) of focus it deserves.
     * And resets the amount.
     */
    public void addFocus() {
        this.focusPoints += amountOfFocusAddedNextRound;
        Message.monsterGainsFocus(this, amountOfFocusAddedNextRound);
        amountOfFocusAddedNextRound = 0;
    }

    /**
     * Removes focus points from the Monster
     *
     * @param cost amount of focus it removes
     */
    public void removeFocusPoint(int cost) {
        this.focusPoints -= cost;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return Objects.equals(name, monster.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
