package jimmy;

/**
 * The {@code Command} class represents an abstract command that can be executed
 * in the Jimmy application. Subclasses should implement specific command behaviors
 * such as adding tasks, deleting tasks, marking tasks, etc.
 */
public abstract class Command {

    /**
     * Constructs a {@code Command}.
     */
    public Command() {}

    /**
     * Executes the command with the given task list, user interface, and storage.
     * This method must be implemented by all subclasses to define specific command behavior.
     *
     * @param tasks   the {@code TaskList} containing all current tasks.
     * @param ui      the {@code Ui} instance for interacting with the user.
     * @param storage the {@code Storage} instance for saving or loading data.
     * @throws JimmyException if an error occurs during command execution.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws JimmyException;

    /**
     * Indicates whether this command should terminate the program.
     *
     * @return {@code true} if the command should exit the application, otherwise {@code false}.
     */
    public abstract boolean isExit();
}
