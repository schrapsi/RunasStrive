package edu.kit.informatik.runasstrive.ui.gamestates;

import edu.kit.informatik.runasstrive.model.RunasStrive;
import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.ui.ressources.InputParser;

/**
 * This Class models the ShuffleState of the game.
 *
 * @author ucfoh
 * @version 1.0
 */
public class ShuffleState extends GameState {

    private static final int MAX_INTEGER_VALUE = 2147483647;
    private boolean firstTime = true;

    /**
     * Public constructor for the ShuffleState
     *
     * @param game {@link RunasStrive}
     * @param runa {@link Runa}
     */
    public ShuffleState(RunasStrive game, Runa runa) {
        super(game, runa);
    }

    @Override
    public boolean expectsInput() {
        return true;
    }

    @Override
    public void message() {
        if (firstTime) {
            System.out.println("To shuffle ability cards and monsters, enter two seeds");
            firstTime = false;
        }
        System.out.println("Enter seeds [1--2147483647] separated by comma:");

    }

    @Override
    public boolean execute(String input) {
        int[] seeds;
        try {
            seeds = InputParser.parseInput(input, 2, MAX_INTEGER_VALUE, true);
        } catch (IllegalArgumentException e) {
            return false;
        }

        game.shuffle(seeds[0], seeds[1]);
        return true;
    }

    @Override
    public void execute() {
        // This game state has no execution without input
    }

    @Override
    public GameState nextGameState() {
        return new PreFightState(game, runa);
    }

}
