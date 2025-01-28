public class Task {
    private String name;
    private boolean isCompleted;
    
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
}
