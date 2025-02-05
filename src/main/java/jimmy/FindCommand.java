package jimmy;

/**
 * The {@code FindCommand} class represents a command to search for tasks in the task list
 * that contain a specific keyword. The search is case-insensitive and displays all matching tasks.
 */
public class FindCommand extends Command {
    private final String input;

    /**
     * Constructs a {@code FindCommand} with the specified search keyword.
     *
     * @param input the keyword used to search for matching tasks in the task list.
     * @throws JimmyException if an error occurs during initialization (reserved for future validation).
     */
    public FindCommand(String input) throws JimmyException {
        super();
        this.input = input;
    }

    /**
     * Executes the find command by searching through the task list for tasks that contain the keyword.
     * The matching tasks are displayed to the user in a numbered list.
     *
     * @param tasks   the {@code TaskList} containing all current tasks.
     * @param ui      the {@code Ui} instance for displaying messages to the user.
     * @param storage the {@code Storage} instance (not used in this command).
     * @throws JimmyException if an error occurs during task retrieval (reserved for future enhancements).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JimmyException {
        ui.showMessage("Here are the matching tasks in your list:");
        int index = 1;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.getTask(i).getName().toLowerCase().contains(input.toLowerCase())) {
                ui.showMessage(index + ". " + tasks.getTask(i));
                index++;
            }
        }
    }

    /**
     * Indicates whether this command should terminate the program.
     *
     * @return {@code false} as the find command does not exit the application.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
