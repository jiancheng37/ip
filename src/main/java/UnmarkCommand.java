public class UnmarkCommand extends Command {
    private final int index;

    public UnmarkCommand(String index) throws JimmyException {
        super();
        try {
            this.index = Integer.parseInt(index) - 1;
        } catch (NumberFormatException e) {
            throw new JimmyException("Invalid index for unmark command.");
        }
    }

        @Override
        public void execute(TaskList tasks, Ui ui, Storage storage) throws JimmyException {
            if (index < 0 || index >= tasks.size()) {
                throw new JimmyException("Task index out of bounds.");
            }
            Task task = tasks.getTask(index);
            task.unmark();
            storage.save(tasks.getAllTasks());
            ui.showMessage("OK, I've marked this task as not done yet:\n  " + task);
        }

        @Override
        public boolean isExit() {
            return false;
        }
}
