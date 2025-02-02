package jimmy;

/**
 * The {@code ListCommand} class represents a command to display all tasks
 * in the task list. It provides feedback to the user via the UI, showing either
 * the list of tasks or a message indicating that the task list is empty.
 */
public class ListCommand extends Command {

    /**
     * Constructs a {@code ListCommand}.
     */
    public ListCommand() {}

    /**
     * Executes the list command by displaying all tasks in the task list.
     * If the list is empty, it notifies the user accordingly.
     *
     * @param tasks   the {@code TaskList} containing all current tasks.
     * @param ui      the {@code Ui} instance for displaying messages to the user.
     * @param storage the {@code Storage} instance (not used in this command).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if (tasks.size() == 0) {
            ui.showMessage("Your task list is empty.");
        } else {
            ui.showMessage("Here are the tasks in your list:");
            for (int i = 0; i < tasks.size(); i++) {
                ui.showMessage((i + 1) + ". " + tasks.getTask(i));
            }
        }
    }

    /**
     * Indicates whether this command should terminate the program.
     *
     * @return {@code false} as the list command does not exit the application.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
