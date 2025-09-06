import java.io.IOException;
import java.util.Scanner;


public class AngSoonTong {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public AngSoonTong(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (Exception e) {
            ui.show("Eh got problem la!");
        }
    }

    public void run() throws IOException {
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
        new AngSoonTong("data/data.txt").run();
    }
}
