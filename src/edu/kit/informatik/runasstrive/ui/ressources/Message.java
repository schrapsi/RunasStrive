package edu.kit.informatik.runasstrive.ui.ressources;

import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.skills.Skill;

/**
 * This Class is a utility class for all the Messages that need to be printed from outside the Game states.
 *
 * @author ucfoh
 * @version 1.0
 */
public final class Message {

    private Message() {
    }

    /**
     * Message for the Monster take physical damage
     *
     * @param target that takes damage
     * @param damage amount of damage
     */
    public static void monsterTakePhysicalDamage(Monster target, int damage) {
        if (damage > 0) {
            System.out.println(target + " takes " + damage + " phy. damage");
            if (target.isDead()) {
                System.out.println(target + " dies");
            }
        }

    }

    /**
     * Message for the Monster take magical damage
     *
     * @param target that takes damage
     * @param damage amount of damage
     */
    public static void monsterTakeMagicalDamage(Monster target, int damage) {
        if (damage > 0) {
            System.out.println(target + " takes " + damage + " mag. damage");
            if (target.isDead()) {
                System.out.println(target + " dies");
            }
        }

    }

    /**
     * Message for Runa to take magical damage
     *
     * @param damage amount of damage
     */
    public static void runaTakeMagicalDamage(int damage) {
        if (damage > 0) {
            System.out.println("Runa takes " + damage + " mag. damage");
        }

    }

    /**
     * Message for Runa to take physical damage
     *
     * @param damage amount of damage
     */
    public static void runaTakePhysicalDamage(int damage) {
        if (damage > 0) {
            System.out.println("Runa takes " + damage + " phy. damage");
        }

    }

    /**
     * Message if Runa dies
     */
    public static void runaDies() {
        System.out.println("Runa dies");
    }

    /**
     * Message if Runa wins
     */
    public static void runaWins() {
        System.out.println("Runa won!");
    }

    /**
     * Message when runa uses a given Skill
     *
     * @param skill runa uses
     */
    public static void runaUseSkill(Skill skill) {
        System.out.println("Runa uses " + skill.toString());
    }

    /**
     * Message when a monster uses a skill
     *
     * @param monster that uses a skill
     */
    public static void monsterUseSkill(Monster monster) {
        System.out.println(monster + " uses " + monster.getNextSkill().toString());
    }

    /**
     * Message for runa to get a skill
     *
     * @param skill that runa gets
     */
    public static void getSkillMessage(Skill skill) {
        System.out.println("Runa gets " + skill.toString());
    }

    /**
     * Message if the dice is upgraded
     *
     * @param dice upgraded dice
     */
    public static void nextDice(int dice) {
        System.out.println("Runa upgrades her die to a d" + dice);
    }

    /**
     * Message for the healing of Runa
     *
     * @param amount of healing
     */
    public static void healingMessage(int amount) {
        System.out.println("Runa gains " + amount + " health");

    }

    /**
     * Message when Runa gains focus
     *
     * @param amount of gained focus
     */
    public static void runaGainsFocus(int amount) {
        if (amount > 0) {
            System.out.println("Runa gains " + amount + " focus");
        }
    }

    /**
     * Message when a monster gains focus
     *
     * @param monster that gains focus
     * @param amount  of gained focus
     */
    public static void monsterGainsFocus(Monster monster, int amount) {
        System.out.println(monster + " gains " + amount + " focus");

    }

    /**
     * Error Message for the start arguments.
     */
    public static void noArgumentAllowedMessage() {
        System.out.println("Error, no arguments allowed");
    }
}
