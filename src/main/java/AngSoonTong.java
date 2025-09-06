import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class AngSoonTong {
    public static void main(String[] args) {
        Storage storage = new Storage("./data/tasks.txt");
        // init list of tasks
        TaskList tasks = new TaskList();
        boolean running = true;
        // init Ui Object
        Ui ui = new Ui();

        ui.showGreeting(); // greeting message

        try {
            for (String line : storage.load()) {
                Task t = TaskDecoder.decode(line);
                tasks.add(t);
            }
        } catch (IOException e) {
            ui.show("Wah cannot read file leh: " + e.getMessage());
        }

        while (running) {

            String curr = ui.readCommand();
            String[] words = curr.split(" "); // split by spaces
            String firstWord = words[0]; // take the first word
            String[] slash = curr.split("/");

            if (Objects.equals(curr, "bye")) { // exiting the program
                running = false;

            } else if (Objects.equals(words[0], "todo") ||
                       Objects.equals(words[0], "event") ||
                        Objects.equals(words[0], "deadline")) { // handles the cases whereby a new kind of Task is created
                String str = words[0];

                // checking for no task description after task keyword
                try {
                    String test = words[1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    ui.show("Oi! The description cannot be empty la!\n");
                    continue;
                }

                if (Objects.equals(str, "todo")) {
                    Task newTask = new ToDo(slash[0].substring(5));
                    tasks.add(newTask);

                    ui.show("Steady! I add this already:\n  " + newTask + "\n");
                    ui.show(String.format("Now your list got %d tasks.\n", tasks.size()));


                    tasks.save(storage);

                } else if (Objects.equals(str, "event")) {
                    Task newTask = new Event(
                            slash[0].substring(6).trim(),
                            slash[1].substring(5).trim(),  // remove "from "
                            slash[2].substring(3).trim()   // remove "to "
                    );
                    tasks.add(newTask);

                    ui.show(String.format("Steady! I add this already:\n  " + newTask + "\n"));
                    ui.show(String.format("Now your list got %d tasks.\n", tasks.size()));

                    tasks.save(storage);

                } else {
                    Task newTask = new Deadline(slash[0].substring(9),
                            slash[1].substring(3).trim()); // remove "by"
                    tasks.add(newTask);

                    ui.show(String.format("Steady! I add this already:\n  " + newTask + "\n"));
                    ui.show(String.format("Now your list got %d task.\n", tasks.size()));

                    tasks.save(storage);

                }
            } else if (Objects.equals(firstWord, "mark")) { // marking a task as done
                int x = Integer.parseInt(words[1]);
                Task currTask = tasks.get(x - 1);
                currTask.markDone();

                ui.show("Ok la! Do already\n" + currTask);

                tasks.save(storage);

            } else if (Objects.equals(firstWord, "unmark")) { // unmarking a task
                int x = Integer.parseInt(words[1]);
                Task currTask = tasks.get(x - 1);
                currTask.markUndone();

                ui.show("Huh why haven't do?!\n" + currTask);

                tasks.save(storage);

            } else if (Objects.equals(curr, "list")) { // returning the full list
                ui.show("Oi! This one your list.");

                for (int i = 0; i < tasks.size(); i++) {
                    System.out.printf("%d. %s\n", i + 1, tasks.get(i));
                }

            } else if (Objects.equals(firstWord, "delete")) { // deleting a task
                int x = Integer.parseInt(words[1]);
                Task currTask = tasks.get(x - 1);
                tasks.delete(x - 1);

                tasks.save(storage);

                ui.show("Ok la! I delete already ah:\n" + currTask);
                ui.show(String.format("Now you got %d task only.\n", tasks.size()));
            } else { // if no keywords are detected
                ui.show("Eh! Say properly leh, I don't know what that means la!\n");
            }

        }

        ui.showGoodbye(); // ending message
    }
}
