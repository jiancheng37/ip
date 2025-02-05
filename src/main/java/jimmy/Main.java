package jimmy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The {@code Main} class serves as the entry point for the Jimmy Chatbot application.
 * It initializes the GUI using JavaFX, allowing users to interact with the chatbot through
 * a simple interface consisting of a text area (for displaying messages) and a text field (for user input).
 */
public class Main extends Application {

    private TextArea chatArea;
    private TextField userInput;
    private Jimmy jimmy;

    /**
     * The {@code start} method initializes the JavaFX application window.
     * It sets up the chat interface with a text area for displaying messages
     * and a text field for user input.
     *
     * @param stage the primary stage for this application.
     */
    @Override
    public void start(Stage stage) {
        jimmy = new Jimmy("data/jimmy.txt");

        chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setWrapText(true);

        VBox.setVgrow(chatArea, Priority.ALWAYS);

        userInput = new TextField();
        userInput.setPromptText("Type your message here...");
        userInput.setOnAction(event -> handleUserInput());

        VBox layout = new VBox(10, chatArea, userInput);
        layout.setStyle("-fx-padding: 10; -fx-background-color: #f4f4f4;");

        Scene scene = new Scene(layout, 400, 600);
        stage.setTitle("Jimmy Chatbot");
        stage.setScene(scene);
        stage.show();

        chatArea.appendText("Hello! I'm Jimmy. How can I help you?\n\n");
    }

    /**
     * Handles the user input when the Enter key is pressed.
     * It reads the user's message, displays it in the chat area,
     * parses the command, and generates an appropriate response from Jimmy.
     */
    private void handleUserInput() {
        String input = userInput.getText();
        chatArea.appendText("You: " + input + "\n\n");

        try {
            Command command = Parser.parse(input);
            command.execute(jimmy.getTasks(), new Ui(chatArea), jimmy.getStorage());

            if (command.isExit()) {
                System.exit(0);
            }
        } catch (JimmyException e) {
            chatArea.appendText("Error: " + e.getMessage() + "\n");
        }

        chatArea.appendText("\n");
        userInput.clear();
    }

    /**
     * The {@code main} method is the entry point of the Java application.
     * It launches the JavaFX application.
     *
     * @param args command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        launch(args);
    }
}
