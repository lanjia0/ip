public class Task {
    private boolean isDone;
    private final String NAME;

    public Task(String name) {
        this.NAME = name;
        this.isDone = false;
    }

    public void markDone() {
        this.isDone = true;
    }

    public void markUndone() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        return String.format("[" + (isDone ? "X" : "") + "] %s", NAME);
    }
}
