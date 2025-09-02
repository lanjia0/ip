public class Event extends Task{
    private String start;
    private String end;

    public Event(String name, String start, String end) {
        super(name);
        this.start = start.substring(5);
        this.end = end.substring(3);
    }

    @Override // custom toString representation for event
    public String toString() {
        return String.format("[E]" + super.toString() + "(from: %s to: %s)", start, end);
    }

    @Override
    public String toFileFormat() {
        return "D | " +
                (super.isDone() ? "1" : "0") +
                " | " + super.getName() +
                " | " + this.start + "-" + this.end;
    }
}
