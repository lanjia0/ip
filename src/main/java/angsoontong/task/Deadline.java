package angsoontong.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import angsoontong.ui.Ui;
import angsoontong.storage.Storage;
import angsoontong.parser.Parser;
import angsoontong.task.TaskList;
import angsoontong.task.Task;
import angsoontong.task.Deadline;
import angsoontong.task.Event;


public class Deadline extends Task {
    protected LocalDate dueDate;

    public Deadline(String name, String dueDate) {
        super(name);
        this.dueDate = LocalDate.parse(dueDate);
    }

    @Override // custom toString representation for deadline
    public String toString() {
        return String.format("[D]" + super.toString() +
                "(by: " + dueDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy")) + ")");
    }

    @Override
    public String toFileFormat() {
        return "D | " +
                (super.isDone() ? "1" : "0") +
                " | " + super.getName() +
                " | " + this.dueDate;
    }
}
