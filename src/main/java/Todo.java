public class Todo extends Task{
    public Todo(String name) {
        super(name);
    }

    @Override
    public String toFileFormat() {
        return "T | " + (isCompleted ? "1" : "0") + " | " + name;
    }

    @Override
    public String toString() {
        return "[T][" + getStatus() + "] " + name;
    }
}
