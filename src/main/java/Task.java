public abstract class Task {
    protected String name;
    protected boolean isCompleted;
    
    public Task(String name) {
        this.name = name;
        this.isCompleted = false;
    }

    public void mark() {
        this.isCompleted = true;
    }
    
    public void unmark() {
        this.isCompleted = false;
    }

    public String getName() {
        return name;
    }
    
    public boolean isCompleted() {
        return isCompleted;
    }

    public String getStatus() {
        return isCompleted ? "X" : " ";
    }
    
    public abstract String toFileFormat();
}
