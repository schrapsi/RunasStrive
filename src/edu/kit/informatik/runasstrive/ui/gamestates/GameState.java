package edu.kit.informatik.runasstrive.ui.gamestates;

import edu.kit.informatik.runasstrive.model.RunasStrive;
import edu.kit.informatik.runasstrive.model.Runa;

/**
 * This Class models the Game states of the Runa`s Strive
 *
 * @author ucfoh
 * @version 1.0
 */
public abstract class GameState {

    /**
     * The Player {@link Runa}
     */
    protected Runa runa;
    /**
     * The game {@link RunasStrive}
     */
    protected RunasStrive game;

    /**
     * public constructor for the game states
     *
     * @param game {@link RunasStrive}
     * @param runa {@link Runa}
     */
    protected GameState(RunasStrive game, Runa runa) {
        this.game = game;
        this.runa = runa;
    }

    /**
     * If the game state expects an input or not
     *
     * @return if input is expected
     */
    public abstract boolean expectsInput();

    /**
     * Prints the Message of the game state
     */
    public abstract void message();

    /**
     * Execute method for the game state with an input
     *
     * @param input player input
     * @return if the execution was successful or not
     */
    public abstract boolean execute(String input);

    /**
     * Execute method for the game state without an input
     */
    public abstract void execute();

    /**
     * Method to get the next game state
     *
     * @return the next gamestate
     */
    public abstract GameState nextGameState();

}
