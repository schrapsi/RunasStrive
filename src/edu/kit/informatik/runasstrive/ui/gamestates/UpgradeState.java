package edu.kit.informatik.runasstrive.ui.gamestates;

import edu.kit.informatik.runasstrive.model.RunasStrive;
import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.ui.ressources.Message;

/**
 * This Class models the UpgradeState of the game.
 *
 * @author ucfoh
 * @version 1.0
 */
public class UpgradeState extends GameState {

    /**
     * Public constructor for the UpgradeState
     *
     * @param game {@link RunasStrive}
     * @param runa {@link Runa}
     */
    public UpgradeState(RunasStrive game, Runa runa) {
        super(game, runa);
    }

    @Override
    public boolean expectsInput() {
        return false;
    }

    @Override
    public void message() {
        // This game state has no execution without input
    }

    @Override
    public boolean execute(String input) {
        return false;
    }

    @Override
    public void execute() {
        game.initialize(2);
        Message.getSkillMessage(runa.getSkillAtIndex(runa.getNumberOfSkills() - 2));
        Message.getSkillMessage(runa.getSkillAtIndex(runa.getNumberOfSkills() - 1));

    }

    @Override
    public GameState nextGameState() {
        if (runa.getHealthPoints() == Runa.MAX_HEALTH || runa.getNumberOfSkills() == 1) {
            return new ShuffleState(game, runa);
        } else {
            return new HealingState(game, runa);
        }
    }
}
