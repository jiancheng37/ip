public class AddDeadlineCommand extends Command {
    private final String description;
    private final String by;

    public AddDeadlineCommand(String input) throws JimmyException {
        super();
        String[] parts = input.split(" /by ");
        if (parts.length < 2) {
            throw new JimmyException("The deadline command must include '/by'.");
        }
        this.description = parts[0].trim();
        this.by = parts[1].trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JimmyException {
        Task deadline = new Deadline(description, by);
        tasks.addTask(deadline);
        storage.save(tasks.getAllTasks());
        ui.showMessage("Got it. I've added this task:\n  " + deadline + "\nNow you have " + tasks.size() + " tasks in the list.");
    }

    @Override
    public boolean isExit() {
        return false;
    }

}