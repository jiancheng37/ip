package jimmy;

import javafx.scene.control.TextArea;
/**
 * The Ui class handles all interactions with the user.
 * It provides methods to display messages, errors, and receive input from the user.
 */
public class Ui {
    private TextArea chatArea;
    public Ui(TextArea chatArea) {
        this.chatArea = chatArea;
    }

    public void showMessage(String message) {
        if (chatArea != null) {
            chatArea.appendText("Jimmy: " + message + "\n");
        }
    }
}
