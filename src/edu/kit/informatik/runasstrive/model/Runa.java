package edu.kit.informatik.runasstrive.model;

import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.CharacterClass;
import edu.kit.informatik.runasstrive.model.skills.Skill;
import edu.kit.informatik.runasstrive.model.ressources.SkillEnum;
import edu.kit.informatik.runasstrive.model.skills.magical.ReflectSkill;
import edu.kit.informatik.runasstrive.model.skills.physical.ParrySkill;
import edu.kit.informatik.runasstrive.ui.ressources.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * This class models the playable character Runa.
 *
 * @author ucfoh
 * @version 1.0
 */
public class Runa {

    /**
     * The Max Health of Runa
     */
    public static final int MAX_HEALTH = 50;
    private static final int START_FOCUS_POINTS = 1;
    private static final int REFLECT_MULTIPLIER = 10;
    private static final int PARRY_MULTIPLIER = 7;

    private boolean alive = true;
    private int healthPoints;
    private int focusPoints = START_FOCUS_POINTS;
    private int currentMaxFocusPoints;
    private final List<Skill> skills = new ArrayList<>();
    private boolean isFocused = false;
    private int amountOfFocusAddedNextRound;
    private Skill nextSkill;
    private CharacterClass characterClass;

    /**
     * The public constructor of Runa
     *
     * @param maxFocusPoints amount Runa starts with
     */
    public Runa(int maxFocusPoints) {
        healthPoints = MAX_HEALTH;
        currentMaxFocusPoints = maxFocusPoints;
    }

    /**
     * Method to add a skill to the skilllist of Runa
     *
     * @param skill that need to be added
     */
    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    /**
     * This method calculates and executes the taken magical damage.
     * If runa uses the {@link ReflectSkill} the Method reduces the Damage.
     *
     * @param monster   where the damage came from
     * @param rawDamage the raw amount of the Damage runa takes
     */
    public void takeMagicalDamage(Monster monster, int rawDamage) {

        int damage = rawDamage;

        if (nextSkill.getType().equals(SkillEnum.REFLECT)) {
            if (damage > REFLECT_MULTIPLIER * nextSkill.getSkillLevel()) {
                damage = damage - (REFLECT_MULTIPLIER * nextSkill.getSkillLevel());
                healthPoints -= damage;
                Message.runaTakeMagicalDamage(damage);
                if (healthPoints < 1) {
                    alive = false;
                    healthPoints = 0;
                    return;
                }
                monster.takeMagicalDamage(REFLECT_MULTIPLIER * nextSkill.getSkillLevel());
                damage = 0;
            } else {
                monster.takeMagicalDamage(damage);
                damage = 0;
            }
        }

        healthPoints -= damage;
        Message.runaTakeMagicalDamage(damage);
        if (healthPoints < 1) {
            alive = false;
            healthPoints = 0;
        }
    }

    /**
     * This method calculates and executes the taken physical damage.
     * If runa uses the {@link ParrySkill} the Method reduces the Damage.
     *
     * @param rawDamage the raw amount of the Damage runa takes
     */
    public void takePhysicalDamage(int rawDamage) {

        int damage = rawDamage;

        if (nextSkill.getType().equals(SkillEnum.PARRY)) {
            if (damage > PARRY_MULTIPLIER * nextSkill.getSkillLevel()) {
                damage = damage - (PARRY_MULTIPLIER * nextSkill.getSkillLevel());
            } else {
                damage = 0;
            }
        }
        healthPoints -= damage;
        Message.runaTakePhysicalDamage(damage);
        if (healthPoints < 1) {
            alive = false;
            healthPoints = 0;
        }
    }

    /**
     * Method to heal runa with a given amount
     *
     * @param amount of healing
     */
    public void heal(int amount) {
        healthPoints += amount;
    }

    /**
     * Method to get the stats of Runa with health point and max health
     *
     * @return the stats as string
     */
    public String toStringHealthPoints() {
        return "Runa (" + healthPoints + "/" + MAX_HEALTH + " HP)";
    }


    /**
     * Method to get the skills Runa owns at the Moment as string
     *
     * @return skills as string
     */
    public String skillsToString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < skills.size(); i++) {
            builder.append(i + 1).append(") ");
            builder.append(skills.get(i).toString());
            if ((i != skills.size() - 1)) {
                builder.append("\n");
            }
        }

        return builder.toString();
    }

    /**
     * Method to get a skill from the skillist with an index
     *
     * @param index of the skill
     * @return the skill
     */
    public Skill getSkillAtIndex(int index) {
        return skills.get(index);
    }

    /**
     * Gets healthPoints
     *
     * @return value of healthPoints
     */
    public int getHealthPoints() {
        return healthPoints;
    }

    /**
     * returns the amount of skills runa owns
     *
     * @return the amount of skills
     */
    public int getNumberOfSkills() {
        return skills.size();
    }

    /**
     * updates the max Focus point to the given amount
     *
     * @param maxFocusPoints new max focus amount
     */
    public void updateMaxFocusPoints(int maxFocusPoints) {
        currentMaxFocusPoints = maxFocusPoints;
    }

    /**
     * This method sets runa to focus.
     *
     * @param amount of focus points Runa gets if she is still focused after the monster turn
     */
    public void focus(int amount) {
        amountOfFocusAddedNextRound = amount;
        isFocused = true;
    }

    /**
     * This method breaks Runas focus and resets the amount of focus points she would get
     */
    public void breakFocus() {
        isFocused = false;
        amountOfFocusAddedNextRound = 0;
    }

    /**
     * returns if Runa is in the focused or not
     *
     * @return if Runa is focused
     */
    public boolean isFocused() {
        return isFocused;
    }

    /**
     * This method adds the amount of Focus Runa deserves.
     */
    public void addFocus() {
        if (currentMaxFocusPoints - this.focusPoints >= amountOfFocusAddedNextRound) {
            Message.runaGainsFocus(amountOfFocusAddedNextRound);
            this.focusPoints += amountOfFocusAddedNextRound;
        } else {
            Message.runaGainsFocus(currentMaxFocusPoints - this.focusPoints);
            this.focusPoints = currentMaxFocusPoints;
        }

        amountOfFocusAddedNextRound = 0;

    }

    /**
     * Method to remove focus points from Runa
     *
     * @param cost amount of focus points to remove
     */
    public void removeFocusPoint(int cost) {
        if (this.focusPoints > 1) {
            this.focusPoints -= cost;
        }
    }

    /**
     * Gets focusPoints
     *
     * @return value of focusPoints
     */
    public int getFocusPoints() {
        return focusPoints;
    }

    /**
     * returns if Runa is dead or not
     *
     * @return if Runa is dead or not
     */
    public boolean isDead() {
        return !alive;
    }

    /**
     * Method to remove a given skill from Runas skills
     *
     * @param skill to remove
     */
    public void removeSkill(Skill skill) {
        skills.remove(skill);
    }

    /**
     * Sets the class attribute nextSkill to the given parameter "nextSkill"
     *
     * @param input raw input of the player (needs to be decreased)
     */
    public void setNextSkill(int input) {
        this.nextSkill = skills.get(input - 1);
    }

    /**
     * Gets nextSkill
     *
     * @return value of nextSkill
     */
    public Skill getNextSkill() {
        return nextSkill;
    }

    /**
     * Gets characterClass
     *
     * @return value of characterClass
     */
    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    /**
     * Sets the class attribute characterClass to the given parameter "characterClass"
     *
     * @param characterClass Character Class enum the player chooses for Runa
     */
    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    @Override
    public String toString() {
        return "Runa (" + healthPoints + "/" + MAX_HEALTH + " HP, "
                + focusPoints + "/" + currentMaxFocusPoints + " FP)";
    }
}
