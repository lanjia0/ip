public class Deadline extends Task {
    private String dueDate;

    public Deadline(String name, String dueDate) {
        super(name);
        this.dueDate = dueDate.substring(3);
    }

    @Override // custom toString representation for deadline
    public String toString() {
        return String.format("[D]" + super.toString() + "(by: %s)", dueDate);
    }

    @Override
    public String toFileFormat() {
        return "D | " +
                (super.isDone() ? "1" : "0") +
                " | " + super.getName() +
                " | " + this.dueDate;
    }
}
