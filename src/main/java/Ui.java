import java.util.Scanner;

public class Ui {
    private final Scanner sc = new Scanner(System.in);

    public void showWelcome() {
        showLine();
        System.out.println("    Hello! I'm Jimmy. What can I do for you?");
        showLine();
    }

    public void showGoodbye() {
        System.out.println("    Bye. Hope to see you again soon!");
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public void showError(String message) {
        System.out.println("    Error: " + message);
    }

    public void showLoadingError() {
        System.out.println("    Error loading tasks from file.");
    }

    public void showLine() {
        System.out.println("    __________________________________________________");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
