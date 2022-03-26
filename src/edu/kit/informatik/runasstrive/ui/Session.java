package edu.kit.informatik.runasstrive.ui;

import edu.kit.informatik.runasstrive.model.RunasStrive;
import edu.kit.informatik.runasstrive.ui.gamestates.GameState;
import edu.kit.informatik.runasstrive.ui.gamestates.InitializingState;

import java.util.Scanner;

/**
 * This Class models the Game session
 *
 * @author ucfoh
 * @version 1.0
 */
public class Session {

    private static boolean running = true;
    private final Scanner scanner;
    private final RunasStrive game = new RunasStrive();
    private boolean nextGameState = true;

    /**
     * Public constructor for the session.
     * It initializes the scanner.
     */
    public Session() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * This Method starts the game.
     * All the user inputs are handled inside the running loop.
     */
    public void start() {

        GameState gameState = new InitializingState(game, game.getRuna());
        while (running) {

            gameState.message();
            gameState.execute();
            if (gameState.expectsInput()) {
                String input = this.scanner.nextLine();
                if (input == null) {
                    return;
                }
                if (input.equals("quit")) {
                    endGame();
                } else {
                    nextGameState = gameState.execute(input);
                }
            }
            if (nextGameState) {
                gameState = gameState.nextGameState();
            }

        }
        scanner.close();

    }

    /**
     * Method to end the game by setting the running boolean to false.
     */
    public static void endGame() {
        running = false;
    }


}
