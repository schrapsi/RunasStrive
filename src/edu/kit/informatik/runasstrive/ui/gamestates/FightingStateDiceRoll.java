package edu.kit.informatik.runasstrive.ui.gamestates;

import edu.kit.informatik.runasstrive.model.RunasStrive;
import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.ui.ressources.InputParser;

/**
 * This Class models the FightingStateDiceRoll state of the game.
 *
 * @author ucfoh
 * @version 1.0
 */
public class FightingStateDiceRoll extends GameState {

    /**
     * Public constructor for the FightingStateDiceRoll state
     *
     * @param game {@link RunasStrive}
     * @param runa {@link Runa}
     */
    public FightingStateDiceRoll(RunasStrive game, Runa runa) {
        super(game, runa);
    }

    @Override
    public boolean expectsInput() {
        return true;
    }

    @Override
    public void message() {
        System.out.println("Enter dice roll [1--" + game.getDice() + "]:");

    }

    @Override
    public boolean execute(String input) {
        int[] inputAsNumber;
        try {
            inputAsNumber = InputParser.parseInput(input, 1, game.getDice(), false);
        } catch (IllegalArgumentException e) {
            return false;
        }

        game.setCurrentDiceThrow(inputAsNumber[0]);
        return true;
    }

    @Override
    public void execute() {
        // This game state has no execution without input
    }

    @Override
    public GameState nextGameState() {
        return new FightingStateEvaluation(game, runa);
    }
}
