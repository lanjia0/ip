package angsoontong.parser;

import angsoontong.ui.Ui;
import angsoontong.storage.Storage;
import angsoontong.task.TaskList;
import angsoontong.task.Task;
import angsoontong.task.Deadline;
import angsoontong.task.Event;

public class Parser {
    public static String parse(String input, TaskList tasks, Ui ui, Storage storage) {
        String[] words = input.split(" ");
        String command = words[0];

        switch (command) {
            case "bye":
                return "Bye. Why you still here?!";

            case "list":
                return ui.showList(tasks);

            case "mark":
                int markIndex = Integer.parseInt(words[1]) - 1;
                Task marked = tasks.get(markIndex);
                marked.markDone();
                tasks.save(storage);
                return ui.showMarked(marked);

            case "unmark":
                int unmarkIndex = Integer.parseInt(words[1]) - 1;
                Task unmarked = tasks.get(unmarkIndex);
                unmarked.markUndone();
                tasks.save(storage);
                return ui.showUnmarked(unmarked);

            case "delete":
                int deleteIndex = Integer.parseInt(words[1]) - 1;
                Task deleted = tasks.get(deleteIndex);
                tasks.delete(deleteIndex);

                tasks.save(storage);
                return ui.showDeleted(deleted, tasks.size());

            case "todo":
                Task todo = new ToDo(input.substring(5));
                tasks.add(todo);
                tasks.save(storage);
                return ui.showAdded(todo, tasks.size());

            case "deadline":
                String[] deadlineParts = input.split("/by ");
                Task deadline = new Deadline(deadlineParts[0].substring(9), deadlineParts[1]);
                tasks.add(deadline);
                tasks.save(storage);
                return ui.showAdded(deadline, tasks.size());

            case "event":
                String[] eventParts = input.split("/from |/to ");
                Task event = new Event(eventParts[0].substring(6), eventParts[1], eventParts[2]);
                tasks.add(event);
                tasks.save(storage);
                return ui.showAdded(event, tasks.size());

            default:
                return "Eh! Say properly leh, I don't know what that means la!\n";
        }
    }
}
