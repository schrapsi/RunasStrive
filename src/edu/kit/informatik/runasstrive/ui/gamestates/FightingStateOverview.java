package edu.kit.informatik.runasstrive.ui.gamestates;

import edu.kit.informatik.runasstrive.model.RunasStrive;
import edu.kit.informatik.runasstrive.model.Runa;

/**
 * This Class models the FightingStateOverview state of the game.
 *
 * @author ucfoh
 * @version 1.0
 */
public class FightingStateOverview extends GameState {

    /**
     * Public constructor for the FightingStateOverview state
     *
     * @param game {@link RunasStrive}
     * @param runa {@link Runa}
     */
    public FightingStateOverview(RunasStrive game, Runa runa) {
        super(game, runa);
    }

    @Override
    public boolean expectsInput() {
        return false;
    }

    @Override
    public void message() {
        System.out.println("----------------------------------------");
        System.out.println(runa.toString());
        System.out.println("vs.");
        System.out.println(game.monsterToStringWithStats());
        System.out.println("----------------------------------------");

    }

    @Override
    public boolean execute(String input) {
        return true;
    }

    @Override
    public void execute() {
        // This game state has no execution without input
    }

    @Override
    public GameState nextGameState() {
        return new FightingStateSelectCard(game, runa);
    }
}
