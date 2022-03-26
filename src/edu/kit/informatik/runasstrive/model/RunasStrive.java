package edu.kit.informatik.runasstrive.model;


import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.monsters.level1.SpiderKing;
import edu.kit.informatik.runasstrive.model.monsters.level2.MegaSaurus;
import edu.kit.informatik.runasstrive.model.ressources.Util;
import edu.kit.informatik.runasstrive.model.skills.Skill;
import edu.kit.informatik.runasstrive.model.ressources.RunaSkillEnum;
import edu.kit.informatik.runasstrive.model.skills.magical.FocusSkill;
import edu.kit.informatik.runasstrive.model.skills.magical.ReflectSkill;
import edu.kit.informatik.runasstrive.model.skills.magical.WaterSkill;
import edu.kit.informatik.runasstrive.model.skills.physical.ParrySkill;
import edu.kit.informatik.runasstrive.model.skills.physical.SlashSkill;
import edu.kit.informatik.runasstrive.model.skills.physical.ThrustSkill;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * This Class is the Core of the Game Runa`s Strive.
 * It inherits the Monsters, Runa and all the Skills.
 *
 * @author ucfoh
 * @version 1.0
 */
public class RunasStrive {

    /**
     * Maximum of Stages per level
     */
    public static final int MAX_STAGE = 4;

    private static final int START_DICE = 4;
    private static final int STAGE_THREE = 3;
    private static final int STAGE_FOUR = 4;
    private static final int MAX_DICE = 12;

    private final Runa runa = new Runa(START_DICE);
    private List<Skill> skillList = new LinkedList<>();
    private final List<Monster> monsterList = new ArrayList<>();
    private final LinkedList<Monster> monsterInCurrentStage = new LinkedList<>();
    private Monster boss;

    private int currentDice = START_DICE;
    private Monster currentTarget;

    private int currentDiceThrow;

    private int currentLevel = 1;
    private int currentStage = 1;
    private int numberOfMonstersInStage;


    /**
     * Method to initialize the Level
     *
     * @param level to initialize
     */
    public void initialize(int level) {
        skillList = Util.fillSkillList(level);
        monsterSetup(level);
        Skill classSkill1;
        Skill classSkill2;

        switch (runa.getCharacterClass()) {
            case WARRIOR:
                classSkill1 = new ThrustSkill(RunaSkillEnum.THRUST, level);
                classSkill2 = new ParrySkill(RunaSkillEnum.PARRY, level);
                break;
            case MAGE:
                classSkill1 = new FocusSkill(RunaSkillEnum.FOCUS, level);
                classSkill2 = new WaterSkill(RunaSkillEnum.WATER, level);
                break;
            case PALADIN:
                classSkill1 = new SlashSkill(RunaSkillEnum.SLASH, level);
                classSkill2 = new ReflectSkill(RunaSkillEnum.REFLECT, level);
                break;
            default:
                throw new IllegalStateException();
        }
        runa.addSkill(classSkill1);
        runa.addSkill(classSkill2);
        skillList.remove(classSkill1);
        skillList.remove(classSkill2);

    }

    /**
     * Method to shuffle the monster list and the skill list.
     *
     * @param seed1 skills shuffle seed
     * @param seed2 monster list shuffle seed
     */
    public void shuffle(int seed1, int seed2) {
        Collections.shuffle(skillList, new Random(seed1));
        Collections.shuffle(monsterList, new Random(seed2));
    }

    /**
     * Method to set up the fight phase.
     */
    public void fightSetup() {
        switch (currentStage) {
            case 1:
                numberOfMonstersInStage = 1;
                spawnMonsters(1);
                break;
            case 2:
            case STAGE_THREE:
                numberOfMonstersInStage = 2;
                spawnMonsters(2);
                break;
            case STAGE_FOUR:
                numberOfMonstersInStage = 1;
                monsterInCurrentStage.add(boss);
                break;
            default:
                throw new IllegalStateException();
        }

    }

    /**
     * Method evaluates the damage after the fighting state
     */
    public void evaluate() {

        runa.getNextSkill().execute(currentDiceThrow, currentTarget, runa.getFocusPoints(), runa);
        removeDeadMonsters();
        for (Monster monster : monsterInCurrentStage) {
            if (monster.isFocused()) {
                monster.addFocus();
                monster.breakFocus();
            }
        }
        for (Monster monster : monsterInCurrentStage) {
            monster.monsterTurn(runa);
            if (runa.isDead()) {
                return;
            }
        }
        removeDeadMonsters();
        if (runa.isFocused()) {
            runa.addFocus();
            runa.breakFocus();
        }
    }

    /**
     * Method to get the monsters in the Current stage and the stats of the monsters as string.
     *
     * @return the monsters as string
     */
    public String monsterToStringWithStats() {
        StringBuilder builder = new StringBuilder();
        for (Monster monster : monsterInCurrentStage) {
            builder.append(monster.toStringWithStats());
            builder.append(": attempts ").append(monster.getNextSkill()).append(" next");
            if (!monster.equals(monsterInCurrentStage.getLast())) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    /**
     * Method to get the monsters in the current Stage.
     *
     * @return the monsters as string
     */
    public String monsterToString() {
        StringBuilder builder = new StringBuilder();
        int counter = 1;
        for (Monster monster : monsterInCurrentStage) {
            builder.append(counter).append(") ");
            builder.append(monster.getName());
            if (!monster.equals(monsterInCurrentStage.getLast())) {
                builder.append("\n");
            }
            counter++;
        }
        return builder.toString();

    }

    /**
     * Method to get the given amount of skills from the skills as string
     *
     * @param amountOfSkills amount of skills
     * @return the skills as string
     */
    public String selectRewardCardString(int amountOfSkills) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < (amountOfSkills); i++) {
            builder.append(i + 1).append(") ");
            builder.append(skillList.get(i).toString());
            if ((i != amountOfSkills - 1)) {
                builder.append("\n");
            }
        }
        return builder.toString();

    }

    /**
     * Method to check if the Dice is already maxed.
     *
     * @return true if the dice is not maxed
     */
    public boolean notMaxDiceCheck() {
        return currentDice != MAX_DICE;

    }

    /**
     * Method to increase the dice to the next level
     */
    public void increaseDice() {
        currentDice += 2;
        runa.updateMaxFocusPoints(currentDice);
    }

    /**
     * Method to increase the Level.
     * Resets the stage back to stage one.
     */
    public void nextLevel() {
        currentStage = 1;
        currentLevel += 1;
    }

    /**
     * Method to increase the stage
     */
    public void nextStage() {
        currentStage += 1;
    }

    /**
     * Method to get a skill from the skilllist and remove it from the List afterwards.
     *
     * @param index of the skill to remove
     * @return the removed skill
     */
    public Skill getAndRemoveSkill(int index) {
        Skill skill = skillList.get(index);
        skillList.remove(index);
        return skill;
    }

    private void spawnMonsters(int amount) {
        for (int i = 0; i < amount; i++) {
            monsterInCurrentStage.add(monsterList.get(0));
            monsterList.removeIf(monsterInCurrentStage::contains);
        }
    }

    private void monsterSetup(int level) {
        if (level == 1) {
            monsterList.clear();
            monsterList.addAll(Util.fillMonsterListLevel1());
            boss = new SpiderKing("Spider King");
        } else {
            monsterList.clear();
            monsterList.addAll(Util.fillMonsterListLevel2());
            boss = new MegaSaurus("Mega Saurus");
        }


    }

    private void removeDeadMonsters() {
        monsterInCurrentStage.removeIf(Monster::isDead);
    }

    /**
     * Gets  the list of monsters in the Current Stage
     *
     * @return the list of monsters in the Current Stage
     */
    public List<Monster> getMonsterInCurrentStage() {
        return monsterInCurrentStage;
    }

    /**
     * Sets the current target from an index
     *
     * @param index from the monster in current Stage List
     */
    public void setCurrentTarget(int index) {
        currentTarget = monsterInCurrentStage.get(index);
    }

    /**
     * Sets the player dice Throw to the Given Input
     *
     * @param input player dice Throw
     */
    public void setCurrentDiceThrow(int input) {
        currentDiceThrow = input;
    }

    /**
     * Gets the currentDice
     *
     * @return the dice Size
     */
    public int getDice() {
        return currentDice;
    }

    /**
     * Gets the Character runa
     *
     * @return the Character Runa
     */
    public Runa getRuna() {
        return runa;
    }

    /**
     * Gets currentLevel
     *
     * @return the currentLevel
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Gets currentStage
     *
     * @return value of currentStage
     */
    public int getCurrentStage() {
        return currentStage;
    }

    /**
     * Gets numberOfMonstersInStage
     *
     * @return value of numberOfMonstersInStage
     */
    public int getNumberOfMonstersInStage() {
        return numberOfMonstersInStage;
    }

    /**
     * Gets amount of skills in the Skilllist
     *
     * @return value of skillList
     */
    public int getAmountOfSkillsAvailable() {
        return skillList.size();
    }
}
