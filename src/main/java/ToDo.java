public class ToDo extends Task {

    public ToDo(String name) {
        super(name);
    }

    // custom toString representation
    @Override
    public String toString() {
        return String.format("[T]" + super.toString());
    }

    // write to file format

    @Override
    public String toFileFormat() {
        return "T | " +
                (super.isDone() ? "1" : "0") +
                " | " + super.getName();
    }
}
