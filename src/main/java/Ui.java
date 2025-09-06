import java.util.Scanner;

public class Ui {
    private Scanner sc;

    // constructor
    public Ui() {
        this.sc = new Scanner(System.in);
    }

    // to receive next input from user
    public String readCommand() {
        return sc.nextLine();
    }

    // method to print custom message
    public void show(String message) {
        System.out.println(message);
    }

    // prints greeting
    public void showGreeting() {
        show("Eh! I'm Soon Tong\nWhat you want?!");
    }

    // prints goodbye message
    public void showGoodbye() {
        show("Bye. Why you still here?!");
    }

    // methods for different actions
    public String showAdded(Task task, int size) {
        return String.format("Steady! I add this already:\n  %s\nNow your list got %d tasks.\n",
                task, size);
    }

    public String showDeleted(Task task, int size) {
        return String.format("Ok la! I delete already ah:\n  %s\nNow you got %d task%s only.\n",
                task,
                size,
                size == 1 ? "" : "s");
    }

    public String showList(TaskList tasks) {
        if (tasks.size() == 0) {
            return "Eh your list empty sia!";
        }
        StringBuilder sb = new StringBuilder("Oi! This one your list:\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append(String.format("%d.%s\n", i + 1, tasks.get(i)));
        }
        return sb.toString();
    }

    public String showMarked(Task task) {
        return "Ok la! Do already\n" + task + "\n";
    }

    public String showUnmarked(Task task) {
        return "Huh why haven't do?!\n" + task + "\n";
    }
}

