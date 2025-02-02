public class AddEventCommand extends Command {
    private final String description;
    private final String from;
    private final String to;

    public AddEventCommand(String input) throws JimmyException {
        super();
        String[] parts = input.split(" /from | /to ");
        if (parts.length < 3) {
            throw new JimmyException("The event command must include '/from' and '/to'.");
        }
        this.description = parts[0].trim();
        this.from = parts[1].trim();
        this.to = parts[2].trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JimmyException {
        Task event = new Event(description, from, to);
        tasks.addTask(event);
        storage.save(tasks.getAllTasks());
        ui.showMessage("Got it. I've added this task:\n  " + event + "\nNow you have " + tasks.size() + " tasks in the list.");
    }

    @Override
    public boolean isExit() {
        return false;
    }
}