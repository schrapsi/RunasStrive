package edu.kit.informatik.runasstrive.ui.gamestates;

import edu.kit.informatik.runasstrive.model.RunasStrive;
import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.ui.ressources.InputParser;
import edu.kit.informatik.runasstrive.ui.ressources.Message;

import static edu.kit.informatik.runasstrive.model.RunasStrive.MAX_STAGE;

/**
 * This Class models the RewardChooseState of the game.
 *
 * @author ucfoh
 * @version 1.0
 */
public class RewardChooseState extends GameState {

    private boolean firstTime = true;
    private GameState nextGameState;

    /**
     * Public constructor for the RewardChooseState
     *
     * @param game {@link RunasStrive}
     * @param runa {@link Runa}
     */
    public RewardChooseState(RunasStrive game, Runa runa) {
        super(game, runa);
    }

    @Override
    public boolean expectsInput() {
        return true;
    }

    @Override
    public void message() {
        if (firstTime) {
            System.out.println("Choose Runa's reward");
            System.out.println("1) new ability cards");
            if (game.notMaxDiceCheck()) {
                System.out.println("2) next player dice");
            }
            firstTime = false;
        }
        if (game.notMaxDiceCheck()) {
            System.out.println("Enter number [1--2]:");
        } else {
            System.out.println("Enter number [1--1]:");
        }

    }

    @Override
    public boolean execute(String input) {
        int[] inputAsNumber;
        int upperRange;
        if (game.notMaxDiceCheck()) {
            upperRange = 2;
        } else {
            upperRange = 1;
        }
        try {
            inputAsNumber = InputParser.parseInput(input, 1, upperRange, false);
        } catch (IllegalArgumentException e) {
            return false;
        }
        if (inputAsNumber[0] == 1) {
            nextGameState = new RewardChooseCardsState(game, runa);
        } else if (inputAsNumber[0] == 2) {
            game.increaseDice();
            Message.nextDice(game.getDice());
            if (runa.getHealthPoints() == Runa.MAX_HEALTH || runa.getNumberOfSkills() == 1) {
                if (game.getCurrentStage() == MAX_STAGE) {
                    game.nextLevel();
                    nextGameState = new ShuffleState(game, runa);
                } else {
                    game.nextStage();
                    nextGameState = new PreFightState(game, runa);

                }
            } else {
                nextGameState = new HealingState(game, runa);
            }

        } else {
            return false;
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
