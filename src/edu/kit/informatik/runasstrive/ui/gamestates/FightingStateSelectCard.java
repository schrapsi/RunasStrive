package edu.kit.informatik.runasstrive.ui.gamestates;

import edu.kit.informatik.runasstrive.model.RunasStrive;
import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.ressources.SkillEnum;
import edu.kit.informatik.runasstrive.ui.ressources.InputParser;
import edu.kit.informatik.runasstrive.ui.ressources.Message;

/**
 * This Class models the FightingStateSelectCard state of the game.
 *
 * @author ucfoh
 * @version 1.0
 */
public class FightingStateSelectCard extends GameState {

    private boolean firstTime = true;
    private GameState nextGameState;

    /**
     * Public constructor for the FightingStateSelectCard state
     *
     * @param game {@link RunasStrive}
     * @param runa {@link Runa}
     */
    public FightingStateSelectCard(RunasStrive game, Runa runa) {
        super(game, runa);
    }

    @Override
    public boolean expectsInput() {
        return true;
    }

    @Override
    public void message() {
        if (firstTime) {
            System.out.println("Select card to play");
            System.out.println(runa.skillsToString());
            firstTime = false;
        }
        System.out.println("Enter number [1--" + runa.getNumberOfSkills() + "]:");
    }

    @Override
    public boolean execute(String input) {
        int[] inputAsNumber;
        try {
            inputAsNumber = InputParser.parseInput(input, 1, runa.getNumberOfSkills(), false);
        } catch (IllegalArgumentException e) {
            return false;
        }
        runa.setNextSkill(inputAsNumber[0]);
        if (runa.getNextSkill().isDefensive()) {
            Message.runaUseSkill(runa.getNextSkill());
            nextGameState = new FightingStateEvaluation(game, runa);
        } else if (game.getMonsterInCurrentStage().size() == 1) {
            game.setCurrentTarget(0);
            if (runa.getNextSkill().getType().equals(SkillEnum.LIGHTNING)
                    || runa.getNextSkill().getType().equals(SkillEnum.WATER)
                    || runa.getNextSkill().getType().equals(SkillEnum.FIRE)
                    || runa.getNextSkill().getType().equals(SkillEnum.ICE)) {
                nextGameState = new FightingStateEvaluation(game, runa);
            } else {
                nextGameState = new FightingStateDiceRoll(game, runa);
            }
            Message.runaUseSkill(runa.getNextSkill());
        } else {
            nextGameState = new FightingStateChooseTarget(game, runa);
        }
        return true;
    }

    @Override
    public void execute() {
        // This game state has no execution without input
    }

    @Override
    public GameState nextGameState() {
        return nextGameState;
    }
}
