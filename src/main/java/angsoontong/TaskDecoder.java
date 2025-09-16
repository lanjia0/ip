package angsoontong;

import angsoontong.task.Task;
import angsoontong.task.Deadline;
import angsoontong.task.Event;
import angsoontong.task.ToDo;


public class TaskDecoder {
    public static Task decode(String line) {
        assert line != null : "decode line is null";
        String[] parts = line.split(" \\| ");
        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String description = parts[2];

        Task task;
        switch (type) {
            case "T":
                task = new ToDo(description);
                break;
            case "D":
                task = new Deadline(description, parts[3]);
                break;
            case "E":
                task = new Event(description, parts[3], parts[4]);
                break;
            default:
                throw new IllegalArgumentException("Unknown task type: " + type);
        }
        if (isDone) {
            task.markDone();
        }
        return task;
    }
}
