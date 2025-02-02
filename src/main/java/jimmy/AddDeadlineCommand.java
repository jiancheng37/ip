package jimmy;

/**
 * The {@code AddDeadlineCommand} class represents a command to add a new deadline task
 * to the task list. It parses the user's input to extract the task description and the due date,
 * validates the input format, and handles task creation and storage.
 */
public class AddDeadlineCommand extends Command {
    private final String description;
    private final String by;

    /**
     * Constructs an {@code AddDeadlineCommand} by parsing the user's input.
     *
     * @param input the input string containing the task description and due date.
     *              The input format should be: {@code description /by [due date]}.
     * @throws JimmyException if the input format is invalid or missing the required '/by' separator.
     */
    public AddDeadlineCommand(String input) throws JimmyException {
        super();
        String[] parts = input.split(" /by ");
        if (parts.length < 2) {
            throw new JimmyException("The deadline command must include '/by'.");
        }
        this.description = parts[0].trim();
        this.by = parts[1].trim();
    }

    /**
     * Executes the add-deadline command by creating a new deadline task, adding it to the task list,
     * saving the updated task list to storage, and notifying the user.
     *
     * @param tasks   the {@code TaskList} containing all current tasks.
     * @param ui      the {@code Ui} instance for displaying messages to the user.
     * @param storage the {@code Storage} instance responsible for saving tasks.
     * @throws JimmyException if an error occurs while creating or saving the deadline task.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JimmyException {
        Task deadline = new Deadline(description, by);
        tasks.addTask(deadline);
        storage.save(tasks.getAllTasks());
        ui.showMessage("Got it. I've added this task:\n  " + deadline + 
                       "\nNow you have " + tasks.size() + " tasks in the list.");
    }

    /**
     * Indicates whether this command should terminate the program.
     *
     * @return {@code false} as the add-deadline command does not exit the application.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
