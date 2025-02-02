public class AddTodoCommand extends Command {
    private final String description;

    public AddTodoCommand(String description) throws JimmyException {
        super();
        if (description == null || description.isBlank()) {
            throw new JimmyException("The description of a todo cannot be empty.");
        }
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JimmyException{
        Task todo = new Todo(description);
        tasks.addTask(todo);
        storage.save(tasks.getAllTasks());
        ui.showMessage("Got it. I've added this task:\n  " + todo + "\nNow you have " + tasks.size() + " tasks in the list.");
    }

    @Override
    public boolean isExit() {
        return false;
    }
}