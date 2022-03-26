package edu.kit.informatik.runasstrive.ui.gamestates;

import edu.kit.informatik.runasstrive.model.RunasStrive;
import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.ressources.RunaSkillEnum;
import edu.kit.informatik.runasstrive.ui.ressources.InputParser;
import edu.kit.informatik.runasstrive.ui.ressources.Message;

/**
 * This Class models the FightingStateChooseTarget state of the game.
 *
 * @author ucfoh
 * @version 1.0
 */
public class FightingStateChooseTarget extends GameState {

    private boolean firstTime = true;

    /**
     * Public constructor for the FightingStateChooseTarget state
     *
     * @param game {@link RunasStrive}
     * @param runa {@link Runa}
     */
    public FightingStateChooseTarget(RunasStrive game, Runa runa) {
        super(game, runa);
    }


    @Override
    public boolean expectsInput() {
        return true;
    }

    @Override
    public void message() {
        if (firstTime) {
            System.out.println("Select Runa's target.");
            System.out.println(game.monsterToString());
            firstTime = false;
        }
        System.out.println("Enter number [1--" + game.getNumberOfMonstersInStage() + "]:");

    }

    @Override
    public boolean execute(String input) {
        int[] inputAsNumber;
        try {
            inputAsNumber = InputParser.parseInput(input, 1, game.getNumberOfMonstersInStage(), false);
        } catch (IllegalArgumentException e) {
            return false;
        }
        game.setCurrentTarget(inputAsNumber[0] - 1);
        Message.runaUseSkill(runa.getNextSkill());
        return true;
    }

    @Override
    public void execute() {
        // This game state has no execution without input
    }

    @Override
    public GameState nextGameState() {
        if (runa.getNextSkill().getType() == RunaSkillEnum.LIGHTNING
                || runa.getNextSkill().getType() == RunaSkillEnum.WATER
                || runa.getNextSkill().getType() == RunaSkillEnum.FIRE
                || runa.getNextSkill().getType() == RunaSkillEnum.ICE) {
            return new FightingStateEvaluation(game, runa);
        } else {
            return new FightingStateDiceRoll(game, runa);
        }

    }
}
