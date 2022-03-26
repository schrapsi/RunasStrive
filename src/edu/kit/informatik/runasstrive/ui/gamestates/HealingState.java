package edu.kit.informatik.runasstrive.ui.gamestates;

import edu.kit.informatik.runasstrive.model.RunasStrive;
import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.skills.Skill;
import edu.kit.informatik.runasstrive.ui.ressources.InputParser;
import edu.kit.informatik.runasstrive.ui.ressources.Message;

import static edu.kit.informatik.runasstrive.model.RunasStrive.MAX_STAGE;

/**
 * This Class models the HealingState of the game.
 *
 * @author ucfoh
 * @version 1.0
 */
public class HealingState extends GameState {


    private static final int HEALTH_PER_SKILL = 10;
    private boolean firstTime = true;
    private GameState nextGameState;

    /**
     * Public constructor for the HealingState
     *
     * @param game {@link RunasStrive}
     * @param runa {@link Runa}
     */
    public HealingState(RunasStrive game, Runa runa) {
        super(game, runa);
    }

    @Override
    public boolean expectsInput() {
        return true;
    }

    @Override
    public void message() {
        if (firstTime) {
            System.out.println(runa.toStringHealthPoints() + " can discard ability cards for healing (or none)");
            System.out.println(runa.skillsToString());
            firstTime = false;
        }
        if (runa.getNumberOfSkills() > 2) {
            System.out.println("Enter numbers [1--" + runa.getNumberOfSkills() + "] separated by comma:");
        } else {
            System.out.println("Enter number [1--" + runa.getNumberOfSkills() + "]:");
        }


    }

    @Override
    public boolean execute(String input) {

        if (input.equals("")) {
            if (game.getCurrentStage() == MAX_STAGE) {
                game.nextLevel();
                nextGameState = new ShuffleState(game, runa);
            } else {
                game.nextStage();
                nextGameState = new PreFightState(game, runa);

            }
            return true;
        }

        int[] cards;
        try {
            cards = InputParser.healingParser(input, runa.getNumberOfSkills());
        } catch (IllegalArgumentException e) {
            return false;
        }

        Skill[] skills = new Skill[cards.length];
        for (int i = 0; i < cards.length; i++) {
            skills[i] = runa.getSkillAtIndex(cards[i] - 1);
        }

        for (Skill skill : skills) {
            runa.removeSkill(skill);
        }

        int additionalHealth = skills.length * HEALTH_PER_SKILL;
        if ((runa.getHealthPoints() + additionalHealth) > Runa.MAX_HEALTH) {
            Message.healingMessage(Runa.MAX_HEALTH - runa.getHealthPoints());
            runa.heal(Runa.MAX_HEALTH - runa.getHealthPoints());
        } else {
            runa.heal(additionalHealth);
            Message.healingMessage(additionalHealth);
        }


        if (game.getCurrentStage() == MAX_STAGE) {
            game.nextLevel();
            nextGameState = new ShuffleState(game, runa);
        } else {
            game.nextStage();
            nextGameState = new PreFightState(game, runa);

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
