package edu.kit.informatik.runasstrive.ui.gamestates;

import edu.kit.informatik.runasstrive.model.RunasStrive;
import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.ui.Session;
import edu.kit.informatik.runasstrive.ui.ressources.Message;

/**
 * This Class models the End state of the game.
 *
 * @author ucfoh
 * @version 1.0
 */
public class EndState extends GameState {

    /**
     * Public constructor for the End state
     *
     * @param game {@link RunasStrive}
     * @param runa {@link Runa}
     */
    public EndState(RunasStrive game, Runa runa) {
        super(game, runa);
    }

    @Override
    public boolean expectsInput() {
        return false;
    }

    @Override
    public void message() {
        if (runa.isDead()) {
            Message.runaDies();
        } else {
            Message.runaWins();
        }
    }

    @Override
    public boolean execute(String input) {
        return false;
    }

    @Override
    public void execute() {
        Session.endGame();
    }

    @Override
    public GameState nextGameState() {
        return null;
    }
}
