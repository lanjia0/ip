public class ToDo extends Task {

    public ToDo(String name) {
        super(name);
    }

    // custom toString representation
    @Override
    public String toString() {
        return String.format("[T]" + super.toString());
    }
}
