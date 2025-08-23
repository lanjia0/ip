public class Task {
    private boolean isDone;
    private final String NAME;

    public Task(String name) {
        this.NAME = name;
        this.isDone = false;
    }

    // mark task as done
    public void markDone() {
        this.isDone = true;
    }

    // unmarks task, task is not done
    public void markUndone() {
        this.isDone = false;
    }

    // custom toString representation for task
    @Override
    public String toString() {
        return String.format("[" + (isDone ? "X" : "") + "] %s", NAME);
    }
}
