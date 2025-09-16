package angsoontong.parser;

import angsoontong.task.*;
import angsoontong.ui.Ui;
import angsoontong.storage.Storage;

public class Parser {
    // helper that runs runnable, and then subsequently saves mutated task list
    private static void mutateAndSave(Runnable mutation, TaskList tasks, Storage storage) {
        mutation.run();
        tasks.save(storage);
    }

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

                mutateAndSave(() -> marked.markDone(), tasks, storage);
                return ui.showMarked(marked);

            case "unmark":
                int unmarkIndex = Integer.parseInt(words[1]) - 1;
                Task unmarked = tasks.get(unmarkIndex);

                mutateAndSave(() -> unmarked.markUndone(), tasks, storage);
                return ui.showUnmarked(unmarked);

            case "delete":
                int deleteIndex = Integer.parseInt(words[1]) - 1;
                Task deleted = tasks.delete(deleteIndex);

                tasks.save(storage);
                return ui.showDeleted(deleted, tasks.size());

            case "find":
                String keyword = input.length() > 4 ? input.substring(5).trim() : "";
                if (keyword.isEmpty()) {
                    ui.show("Eh, tell me what to find leh! (e.g., find book)");
                }
                var indices = tasks.findIndices(keyword);
                return ui.showFindResults(indices, tasks);

            case "todo":
                Task todo = new ToDo(input.substring(5));

                mutateAndSave(() -> tasks.add(todo), tasks, storage);
                return ui.showAdded(todo, tasks.size());

            case "deadline":
                String[] deadlineParts = input.split("/by ");
                Task deadline = new Deadline(deadlineParts[0].substring(9), deadlineParts[1]);

                mutateAndSave(() -> tasks.add(deadline), tasks, storage);
                return ui.showAdded(deadline, tasks.size());

            case "event":
                String[] eventParts = input.split("/from |/to ");
                Task event = new Event(eventParts[0].substring(6), eventParts[1], eventParts[2]);

                mutateAndSave(() -> tasks.add(event), tasks, storage);
                return ui.showAdded(event, tasks.size());

            default:
                return "Eh! Say properly leh, I don't know what that means la!\n";
        }
    }
}
