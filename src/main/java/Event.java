public class Event extends Task {
    private String from;
    private String to;

    public Event(String name, String from, String to) {
        super(name);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toFileFormat() {
        return "E | " + (isCompleted ? "1" : "0") + " | " + name + " | " + from + " | " + to;
    }

    @Override
    public String toString() {
        return "[E][" + getStatus() + "] " + name + " (from: " + from + " to: " + to + ")";
    }
}
