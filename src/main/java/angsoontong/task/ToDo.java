package angsoontong.task;

import angsoontong.ui.Ui;
import angsoontong.storage.Storage;
import angsoontong.parser.Parser;
import angsoontong.task.TaskList;
import angsoontong.task.Task;
import angsoontong.task.Deadline;
import angsoontong.task.Event;


public class ToDo extends angsoontong.task.Task {

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
