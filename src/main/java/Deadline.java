public class Deadline extends Task {
    private String dueDate;

    public Deadline(String name, String dueDate) {
        super(name);
        this.dueDate = dueDate.substring(3);
    }

    @Override
    public String toString() {
        return String.format("[D]" + super.toString() + "(by: %s)", dueDate);
    }
}
