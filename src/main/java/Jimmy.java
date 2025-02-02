public class Jimmy {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

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

    public static void main(String[] args) {
        new Jimmy("data/jimmy.txt").run();
    }
}
