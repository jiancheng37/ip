public class Deadline extends Task {
    private String by;

    public Deadline(String name, String by) {
        super(name);
        this.by = by;
    }

    @Override
    public String toFileFormat() {
        return "D | " + (isCompleted ? "1" : "0") + " | " + name + " | " + by;
    }

    @Override
    public String toString() {
        return "[D][" + getStatus() + "] " + name + " (by: " + by + ")";
    }
}
