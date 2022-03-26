package edu.kit.informatik.runasstrive.ui.gamestates;

import edu.kit.informatik.runasstrive.model.RunasStrive;
import edu.kit.informatik.runasstrive.model.Runa;

/**
 * This Class models the PreFightState of the game.
 *
 * @author ucfoh
 * @version 1.0
 */
public class PreFightState extends GameState {

    /**
     * Public constructor for the PreFightState
     *
     * @param game {@link RunasStrive}
     * @param runa {@link Runa}
     */
    public PreFightState(RunasStrive game, Runa runa) {
        super(game, runa);
    }

    @Override
    public boolean expectsInput() {
        return false;
    }

    @Override
    public void message() {
        System.out.println("Runa enters Stage " + game.getCurrentStage() + " of Level " + game.getCurrentLevel());

    }

    @Override
    public boolean execute(String input) {
        return true;
    }

    @Override
    public void execute() {
        game.fightSetup();
    }

    @Override
    public GameState nextGameState() {
        return new FightingStateOverview(game, runa);
    }
}
