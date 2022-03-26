package edu.kit.informatik.runasstrive;

import edu.kit.informatik.runasstrive.ui.Session;
import edu.kit.informatik.runasstrive.ui.ressources.Message;

/**
 * This Class is Starts the Game Session.
 *
 * @author ucfoh
 * @version 1.0
 */
public class Application {

    /**
     * Main method of the program
     *
     * @param args to start the program
     */
    public static void main(String[] args) {

        if (args.length != 0) {
            Message.noArgumentAllowedMessage();
        } else {
            Session session = new Session();
            session.start();
        }


    }

}
