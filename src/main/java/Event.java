import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task{
    private LocalDate start;
    private LocalDate end;

    public Event(String name, String start, String end) {
        super(name);
        this.start = LocalDate.parse(start);
        this.end = LocalDate.parse(end);
    }

    @Override // custom toString representation for event
    public String toString() {
        return String.format("[E]" + super.toString() +
                "(from: " + start.format(DateTimeFormatter.ofPattern("MMM dd yyyy"))
                + " to: " + end.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + ")");
    }

    @Override
    public String toFileFormat() {
        return "D | " +
                (super.isDone() ? "1" : "0") +
                " | " + super.getName() +
                " | " + this.start + " | " + this.end;
    }
}
