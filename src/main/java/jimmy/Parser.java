package jimmy;

/**
 * The {@code Parser} class handles the interpretation of user input.
 * It converts raw input strings into corresponding {@code Command} objects
 * that can be executed by the program.
 */
public class Parser {

    /**
     * Parses the user input and returns the corresponding {@code Command} object.
     *
     * @param input the user's input string.
     * @return a {@code Command} representing the user's request.
     * @throws JimmyException if the command is invalid or the input is incomplete.
     */
    public static Command parse(String input) throws JimmyException {
        String[] words = input.trim().split(" ", 2);
        String commandWord = words[0];

        switch (commandWord) {
        case "bye":
            if (words.length > 1) {
                throw new JimmyException("The 'bye' command should not have additional arguments.");
            }
            return new ExitCommand();

        case "list":
            if (words.length > 1) {
                throw new JimmyException("The 'list' command does not require additional arguments.");
            }
            return new ListCommand();

        case "mark":
            if (words.length < 2 || words[1].isBlank()) {
                throw new JimmyException("The 'mark' command requires a task index. Example: mark 2");
            }
            return new MarkCommand(words[1]);

        case "unmark":
            if (words.length < 2 || words[1].isBlank()) {
                throw new JimmyException("The 'unmark' command requires a task index. Example: unmark 2");
            }
            return new UnmarkCommand(words[1]);

        case "delete":
            if (words.length < 2 || words[1].isBlank()) {
                throw new JimmyException("The 'delete' command requires a task index. Example: delete 3");
            }
            return new DeleteCommand(words[1]);

        case "todo":
            if (words.length < 2 || words[1].isBlank()) {
                throw new JimmyException("The 'todo' command requires a description. Example: todo read book");
            }
            return new AddTodoCommand(words[1]);

        case "deadline":
            if (words.length < 2 || words[1].isBlank()) {
                throw new JimmyException("The 'deadline' command requires a description and a due date. Example: deadline submit report /by 2024-12-31 2359");
            }
            return new AddDeadlineCommand(words[1]);

        case "event":
            if (words.length < 2 || words[1].isBlank()) {
                throw new JimmyException("The 'event' command requires a description, start time, and end time. Example: event project meeting /from 2024-12-01 1400 /to 2024-12-01 1600");
            }
            return new AddEventCommand(words[1]);

        case "find":
            if (words.length < 2 || words[1].isBlank()) {
                throw new JimmyException("The 'find' command requires a keyword to search for. Example: find meeting");
            }
            return new FindCommand(words[1]);

        default:
            throw new JimmyException("Invalid command. Please enter a valid command like 'list', 'todo', 'find', etc.");
        }
    }
}
