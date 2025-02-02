import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task {
    
    private LocalDateTime from;
    private LocalDateTime to;
    protected static final DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    protected static final DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy, h:mm a");

    public Event(String name, String from, String to) throws JimmyException {
        super(name);
        try {
            this.from = LocalDateTime.parse(from, inputFormatter);
            this.to = LocalDateTime.parse(to, inputFormatter);
        } catch (DateTimeParseException e) {
            this.from = null;
            this.to = null;
            throw new JimmyException("Invalid date format. Please use yyyy-MM-dd HHmm (e.g., 2019-12-02 1800).");
        }
    }

    public LocalDateTime getTo() {
        return to;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    @Override
    public String toFileFormat() {
        return "E | " + (isCompleted ? "1" : "0") + " | " + name + " | " + from.format(inputFormatter) + " | " + to.format(inputFormatter);
    }

    @Override
    public String toString() {
        return "[E][" + getStatus() + "] " + name + " (from: " + from.format(outputFormatter) + " to: " + to.format(outputFormatter) + ")";
    }
}
