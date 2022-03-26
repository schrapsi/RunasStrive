package edu.kit.informatik.runasstrive.ui.gamestates;

import edu.kit.informatik.runasstrive.model.RunasStrive;
import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.skills.Skill;
import edu.kit.informatik.runasstrive.ui.ressources.InputParser;
import edu.kit.informatik.runasstrive.ui.ressources.Message;

import static edu.kit.informatik.runasstrive.model.RunasStrive.MAX_STAGE;

/**
 * This Class models the RewardChooseCardsState of the game.
 *
 * @author ucfoh
 * @version 1.0
 */
public class RewardChooseCardsState extends GameState {


    private int amountOfSkills;
    private boolean firstTime = true;
    private Skill[] skillsToChoose;

    /**
     * Public constructor for the RewardChooseCardsState
     *
     * @param game {@link RunasStrive}
     * @param runa {@link Runa}
     */
    public RewardChooseCardsState(RunasStrive game, Runa runa) {
        super(game, runa);
    }

    @Override
    public boolean expectsInput() {
        return true;
    }

    @Override
    public void message() {

        if (firstTime) {
            amountOfSkills = game.getNumberOfMonstersInStage() * 2;
            if (game.getAmountOfSkillsAvailable() < amountOfSkills) {
                amountOfSkills--;
            }
            System.out.println("Pick " + game.getNumberOfMonstersInStage() + " card(s) as loot");
            System.out.println(game.selectRewardCardString(amountOfSkills));
            skillsToChoose = new Skill[amountOfSkills];
            for (int i = 0; i < amountOfSkills; i++) {
                skillsToChoose[i] = game.getAndRemoveSkill(0);
            }
            firstTime = false;
        }
        if (game.getNumberOfMonstersInStage() == 2) {
            System.out.println("Enter numbers [1--"
                    + (amountOfSkills) + "] separated by comma:");
        } else {
            System.out.println("Enter number [1--" + (amountOfSkills) + "]:");
        }

    }

    @Override
    public boolean execute(String input) {

        int[] inputAsNumber;
        if (game.getNumberOfMonstersInStage() == 1) {
            try {
                inputAsNumber = InputParser.parseInput(input, 1, amountOfSkills, false);
            } catch (IllegalArgumentException e) {
                return false;
            }
            runa.addSkill(skillsToChoose[inputAsNumber[0] - 1]);
            Message.getSkillMessage(skillsToChoose[inputAsNumber[0] - 1]);

        } else {
            try {
                inputAsNumber = InputParser.parseInput(input, 2, amountOfSkills, false);
            } catch (IllegalArgumentException e) {
                return false;
            }

            for (int number : inputAsNumber) {
                runa.addSkill(skillsToChoose[number - 1]);
                Message.getSkillMessage(skillsToChoose[number - 1]);
            }
        }
        return true;
    }

    @Override
    public void execute() {
        // This game state has no execution without input
    }

    @Override
    public GameState nextGameState() {
        //Healing requirements
        if (runa.getHealthPoints() == Runa.MAX_HEALTH || runa.getNumberOfSkills() == 1) {
            if (game.getCurrentStage() == MAX_STAGE) {
                game.nextLevel();
                return new ShuffleState(game, runa);
            } else {
                game.nextStage();
                return new PreFightState(game, runa);

            }
        } else {
            return new HealingState(game, runa);
        }

    }


}
