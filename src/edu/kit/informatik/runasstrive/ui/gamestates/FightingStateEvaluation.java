package edu.kit.informatik.runasstrive.ui.gamestates;

import edu.kit.informatik.runasstrive.model.RunasStrive;
import edu.kit.informatik.runasstrive.model.Runa;

import static edu.kit.informatik.runasstrive.model.RunasStrive.MAX_STAGE;

/**
 * This Class models the FightingStateEvaluation state of the game.
 *
 * @author ucfoh
 * @version 1.0
 */
public class FightingStateEvaluation extends GameState {

    private GameState nextGameState;

    /**
     * Public constructor for the FightingStateEvaluation state
     *
     * @param game {@link RunasStrive}
     * @param runa {@link Runa}
     */
    public FightingStateEvaluation(RunasStrive game, Runa runa) {
        super(game, runa);
    }

    @Override
    public boolean expectsInput() {
        return false;
    }

    @Override
    public void message() {
        // This game state has no message to print
    }

    @Override
    public boolean execute(String input) {
        return false;
    }

    @Override
    public void execute() {

        game.evaluate();

        if (runa.isDead()) {
            nextGameState = new EndState(game, runa);
            return;
        }

        if (game.getMonsterInCurrentStage().isEmpty()) {
            if (game.getCurrentStage() == MAX_STAGE && game.getCurrentLevel() < 2) {
                nextGameState = new UpgradeState(game, runa);
            } else if ((game.getCurrentStage() == MAX_STAGE && game.getCurrentLevel() == 2)) {
                nextGameState = new EndState(game, runa);
            } else if (game.notMaxDiceCheck()) {
                nextGameState = new RewardChooseState(game, runa);
            } else {
                nextGameState = new RewardChooseCardsState(game, runa);
            }
        } else {
            nextGameState = new FightingStateOverview(game, runa);
        }


    }

    @Override
    public GameState nextGameState() {
        return nextGameState;


    }
}
