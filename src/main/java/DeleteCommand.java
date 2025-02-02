public class DeleteCommand extends Command {
    private final int index;

    public DeleteCommand(String index) throws JimmyException {
        super();
        try {
            this.index = Integer.parseInt(index) - 1;
        } catch (NumberFormatException e) {
            throw new JimmyException("Invalid index for delete command.");
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JimmyException {
        if (index < 0 || index >= tasks.size()) {
            throw new JimmyException("Task index out of bounds.");
        }
        Task removedTask = tasks.deleteTask(index);
        storage.save(tasks.getAllTasks());
        ui.showMessage("Noted. I've removed this task:\n  " + removedTask + "\nNow you have " + tasks.size() + " tasks in the list.");
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
