package jimmy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * The {@code Deadline} class represents a task with a specific deadline.
 * It includes a due date ({@code by}) and provides methods for formatting
 * the task for both display and file storage.
 */
public class Deadline extends Task {
    private LocalDateTime by;

    /** Formatter for parsing input date-time strings (e.g., "yyyy-MM-dd HHmm"). */
    private final static DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");

    /** Formatter for displaying date-time in a user-friendly format (e.g., "MMM dd yyyy, h:mm a"). */
    private final static DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy, h:mm a");

    /**
     * Constructs a {@code Deadline} task with the specified name and due date.
     *
     * @param name the name or description of the task.
     * @param by   the due date of the task in the format "yyyy-MM-dd HHmm".
     * @throws JimmyException if the date format is invalid.
     */
    public Deadline(String name, String by) throws JimmyException {
        super(name);
        try {
            this.by = LocalDateTime.parse(by, inputFormatter);
        } catch (DateTimeParseException e) {
            this.by = null;
            throw new JimmyException("Invalid date format. Please use yyyy-MM-dd HHmm (e.g., 2019-12-02 1800).");
        }
    }

    /**
     * Retrieves the due date of the deadline task.
     *
     * @return the {@code LocalDateTime} representing the task's due date.
     */
    public LocalDateTime getBy() {
        return this.by;
    }

    /**
     * Converts the deadline task to a file-friendly format for saving.
     * The format is:
     * <pre>
     * D | [1 or 0] | [task name] | [due date]
     * </pre>
     *
     * @return the string representation of the task for file storage.
     */
    @Override
    public String toFileFormat() {
        return "D | " + (isCompleted ? "1" : "0") + " | " + name + " | " + by.format(inputFormatter);
    }

    /**
     * Returns the string representation of the deadline task for display in the UI.
     * The format is:
     * <pre>
     * [D][] Task Name (by: Dec 02 2019, 6:00 PM)
     * </pre>
     *
     * @return the formatted string representation of the deadline task.
     */
    @Override
    public String toString() {
        return "[D][" + getStatus() + "] " + name + " (by: " + by.format(outputFormatter) + ")";
    }
}
