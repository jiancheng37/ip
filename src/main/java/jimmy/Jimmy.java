package jimmy;

/**
 * The {@code Jimmy} class serves as the main entry point of the application.
 * It initializes the user interface, storage, and task list, and manages the
 * main program loop for handling user commands.
 */
public class Jimmy {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Constructs a {@code Jimmy} instance with the specified file path for data storage.
     * Initializes the UI, loads tasks from storage, and handles loading errors gracefully.
     *
     * @param filePath the path to the file where tasks are stored.
     */
    public Jimmy(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (JimmyException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * Runs the main program loop, which continuously reads user commands,
     * processes them, and handles any exceptions until an exit command is issued.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (JimmyException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * The main method that serves as the application's entry point.
     * Initializes the {@code Jimmy} application with the default data file path.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        new Jimmy("data/jimmy.txt").run();
    }
}
