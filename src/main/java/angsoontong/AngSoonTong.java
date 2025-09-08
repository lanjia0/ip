package angsoontong;

import angsoontong.ui.Ui;
import angsoontong.storage.Storage;
import angsoontong.parser.Parser;
import angsoontong.task.TaskList;
import java.io.IOException;
import java.util.Scanner;


public class AngSoonTong {
    private final Storage storage;
    private TaskList tasks;
    private final Ui ui;

    /**
     * constructor to initialize AngSoonTong
     * @param filePath outlines location for which tasks will be written to and saved
     */
    public AngSoonTong(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (Exception e) {
            // if loading fails, start with empty list and keep going
            this.tasks = new TaskList();
        }
    }

    public void run() {
        ui.showGreeting();
        boolean running = true;
        Scanner sc = new Scanner(System.in);

        while (running) {
            String input = sc.nextLine();
            if (input.equals("bye")) {
                ui.showGoodbye();
                running = false;
            } else {
                String response = Parser.parse(input, tasks, ui, storage);
                ui.show(response);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new AngSoonTong("data/tasks.txt").run();
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        return Parser.parse(input, tasks, ui, storage);
    }
}
