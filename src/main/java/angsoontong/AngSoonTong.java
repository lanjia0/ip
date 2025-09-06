package angsoontong;

import angsoontong.ui.Ui;
import angsoontong.storage.Storage;
import angsoontong.parser.Parser;
import angsoontong.task.TaskList;
import java.io.IOException;
import java.util.Scanner;


public class AngSoonTong {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

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
            ui.show("Eh got problem la!");
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
}
