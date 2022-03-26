package edu.kit.informatik.runasstrive.ui.gamestates;

import edu.kit.informatik.runasstrive.model.RunasStrive;
import edu.kit.informatik.runasstrive.model.ressources.CharacterClass;
import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.ui.ressources.InputParser;

/**
 * This Class models the InitializingState of the game.
 *
 * @author ucfoh
 * @version 1.0
 */
public class InitializingState extends GameState {

    private static final int MAX_CHARACTER_SELECT = 3;
    private boolean firstTime = true;

    /**
     * Public constructor for the InitializingState
     *
     * @param game {@link RunasStrive}
     * @param runa {@link Runa}
     */
    public InitializingState(RunasStrive game, Runa runa) {
        super(game, runa);
    }

    @Override
    public boolean expectsInput() {
        return true;
    }

    @Override
    public void message() {
        if (firstTime) {
            System.out.println("Welcome to Runa's Strive");
            System.out.println("Select Runa's character class");
            System.out.println("1) Warrior");
            System.out.println("2) Mage");
            System.out.println("3) Paladin");
            firstTime = false;
        }
        System.out.println("Enter number [1--3]:");
    }

    @Override
    public boolean execute(String input) {

        int[] inputNumber;
        try {
            inputNumber = InputParser.parseInput(input, 1, MAX_CHARACTER_SELECT, false);
        } catch (IllegalArgumentException e) {
            return false;
        }

        switch (inputNumber[0]) {
            case 1:
                runa.setCharacterClass(CharacterClass.WARRIOR);
                break;
            case 2:
                runa.setCharacterClass(CharacterClass.MAGE);
                break;
            case MAX_CHARACTER_SELECT:
                runa.setCharacterClass(CharacterClass.PALADIN);
                break;
            default:
                return false;
        }
        game.initialize(1);
        return true;
    }

    @Override
    public void execute() {
        // This game state has no execution without input
    }

    @Override
    public GameState nextGameState() {
        return new ShuffleState(game, runa);
    }


}
