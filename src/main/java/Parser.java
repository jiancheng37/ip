public class Parser {
    public static Command parse(String input) throws JimmyException {
        String[] words = input.split(" ", 2);
        String commandWord = words[0];

        switch (commandWord) {
            case "bye":
                return new ExitCommand();
            case "list":
                return new ListCommand();
            case "mark":
                return new MarkCommand(words[1]);
            case "unmark":
                return new UnmarkCommand(words[1]);
            case "delete":
            
                return new DeleteCommand(words[1]);
            case "todo":
                return new AddTodoCommand(words[1]);
            case "deadline":
                return new AddDeadlineCommand(words[1]);
            case "event":
                return new AddEventCommand(words[1]);
            default:
                throw new JimmyException("Invalid command.");
        }
    }
}
