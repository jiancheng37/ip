import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    private LocalDateTime by;
    protected static final DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    protected static final DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy, h:mm a");


    public Deadline(String name, String by) {
        super(name);
        try {
            this.by = LocalDateTime.parse(by, inputFormatter);
        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date format. Please use yyyy-MM-dd HHmm (e.g., 2019-12-02 1800).");
            this.by = null;
        }
    }

    public LocalDateTime getBy() {
        return this.by;
    }
    @Override
    public String toFileFormat() {
        return "D | " + (isCompleted ? "1" : "0") + " | " + name + " | " + by.format(inputFormatter);
    }

    @Override
    public String toString() {
        return "[D][" + getStatus() + "] " + name + " (by: " + by.format(outputFormatter) + ")";
    }
}
