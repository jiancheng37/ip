package jimmy;

import java.util.Scanner;

/**
 * The Ui class handles all interactions with the user.
 * It provides methods to display messages, errors, and receive input from the user.
 */
public class Ui {
    private final Scanner sc = new Scanner(System.in);

    /**
     * Displays the welcome message when the application starts.
     */
    public void showWelcome() {
        showLine();
        System.out.println("    Hello! I'm Jimmy. What can I do for you?");
        showLine();
    }

    /**
     * Displays the goodbye message when the application exits.
     */
    public void showGoodbye() {
        System.out.println("    Bye. Hope to see you again soon!");
    }

    /**
     * Reads the next line of user input.
     *
     * @return the user's input as a String.
     */
    public String readCommand() {
        return sc.nextLine();
    }

    /**
     * Displays an error message to the user.
     *
     * @param message the error message to display.
     */
    public void showError(String message) {
        System.out.println("    Error: " + message);
    }

    /**
     * Displays an error message related to loading tasks from the file.
     */
    public void showLoadingError() {
        System.out.println("    Error loading tasks from file.");
    }

    /**
     * Displays a separator line for better readability.
     */
    public void showLine() {
        System.out.println("    _________________________________________________");
    }

    /**
     * Displays a general message to the user.
     *
     * @param message the message to display.
     */
    public void showMessage(String message) {
        System.out.println(message);
    }
}