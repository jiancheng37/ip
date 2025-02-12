package jimmy;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code Parser} class handles the interpretation of user input.
 * It converts raw input strings into corresponding {@code Command} objects
 * that can be executed by the program.
 */
public class Parser {

    private static final String ERROR_INVALID_COMMAND = "Invalid command. Please enter a valid command like 'list', 'todo', 'find', etc.";
    private static final String ERROR_NO_ARGUMENTS = "The '%s' command requires additional arguments. Example: %s";
    private static final Map<String, String> COMMAND_ALIASES = new HashMap<>();
    
    static {
        COMMAND_ALIASES.put("t", "todo");
        COMMAND_ALIASES.put("d", "deadline");
        COMMAND_ALIASES.put("e", "event");
        COMMAND_ALIASES.put("m", "mark");
        COMMAND_ALIASES.put("u", "unmark");
        COMMAND_ALIASES.put("del", "delete");
        COMMAND_ALIASES.put("f", "find");
        COMMAND_ALIASES.put("li", "list");
    }
    /**
     * Parses the user input and returns the corresponding {@code Command} object.
     * @param input the user's input string.
     * @return a {@code Command} representing the user's request.
     * @throws JimmyException if the command is invalid or the input is incomplete.
     */
    public static Command parse(String input) throws JimmyException {
        assert input != null : "Input command should not be null";
        input = input.trim();
        assert !input.isEmpty() : "Command should not be empty";

        String[] words = input.split(" ", 2);
        String commandWord = words[0];
        if (COMMAND_ALIASES.containsKey(commandWord)) {
            commandWord = COMMAND_ALIASES.get(commandWord);
        }

        switch (commandWord) {
            case "bye":
                validateNoArguments(words, "bye");
                return new ExitCommand();
            case "list":
                validateNoArguments(words, "list");
                return new ListCommand();
            case "mark":
                validateHasArguments(words, "mark", "mark 2");
                return new MarkCommand(words[1]);
            case "unmark":
                validateHasArguments(words, "unmark", "unmark 2");
                return new UnmarkCommand(words[1]);
            case "delete":
                validateHasArguments(words, "delete", "delete 3");
                return new DeleteCommand(words[1]);
            case "todo":
                validateHasArguments(words, "todo", "todo read book");
                return new AddTodoCommand(words[1]);
            case "deadline":
                validateHasArguments(words, "deadline", "deadline submit report /by 2024-12-31 2359");
                return new AddDeadlineCommand(words[1]);
            case "event":
                validateHasArguments(words, "event", "event project meeting /from 2024-12-01 1400 /to 2024-12-01 1600");
                return new AddEventCommand(words[1]);
            case "find":
                validateHasArguments(words, "find", "find meeting");
                return new FindCommand(words[1]);
            default:
                throw new JimmyException(ERROR_INVALID_COMMAND);
        }
    }

    /**
     * Ensures that a command does not receive unnecessary arguments.
     * @param words the parsed command input.
     * @param command the command being validated.
     * @throws JimmyException if extra arguments are provided.
     */
    private static void validateNoArguments(String[] words, String command) throws JimmyException {
        if (words.length > 1) {
            throw new JimmyException(String.format("The '%s' command should not have additional arguments.", command));
        }
    }

    /**
     * Ensures that a command receives the required arguments.
     * @param words the parsed command input.
     * @param command the command being validated.
     * @param example example of correct usage.
     * @throws JimmyException if the required argument is missing.
     */
    private static void validateHasArguments(String[] words, String command, String example) throws JimmyException {
        if (words.length < 2 || words[1].isBlank()) {
            throw new JimmyException(String.format(ERROR_NO_ARGUMENTS, command, example));
        }
    }
}
