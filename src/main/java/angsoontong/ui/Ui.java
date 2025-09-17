package angsoontong.ui;

import angsoontong.task.TaskList;
import angsoontong.task.Task;
import java.util.List;
import java.util.Scanner;

public class Ui {
    private Scanner sc;

    /**
     * constructor
     */
    public Ui() {
        this.sc = new Scanner(System.in);
    }

    // method to print custom message
    public String show(String message) {
        return message;
    }

    // prints greeting
    public String showGreeting() {
        return "Eh! I'm Soon Tong\nWhat you want?!";
    }

    // prints goodbye message
    public String showGoodbye() {
        return "Bye. Why you still here?!";
    }

    /**
     * method to print message for adding a task
     * @param task Task to be added into task list
     * @param size Size of task list after the task has been added
     */
    public String showAdded(Task task, int size) {
        return String.format("Steady! I add this already:\n  %s\nNow your list got %d tasks.\n",
                task, size);
    }

    /**
     * method to print message for deleting a task
     * @param task Task to be removed from task list
     * @param size Size of task list after the task has been deleted
     */
    public String showDeleted(Task task, int size) {
        return String.format("Ok la! I delete already ah:\n  %s\nNow you got %d task%s only.\n",
                task,
                size,
                size == 1 ? "" : "s");
    }

    /**
     * method to print out every task in the list to ui
     * @param tasks TaskList instance which is a list of all current tasks
     */
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

    public String showFindResults(List<Integer> indices, TaskList tasks) {
        if (indices.isEmpty()) {
            return "No matching tasks found lah.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Here are the matching tasks in your list:\n");
        int line = 1;
        for (Integer idx : indices) {
            sb.append(line++)
                    .append(".")
                    .append(tasks.get(idx)) // prints like [T][X] read book
                    .append("\n");
        }
        return sb.toString();
    }

    public String showTagged(Task task) {
        return "Ok tag already! :\n  " + task;
    }

    public String showMarked(Task task) {
        return "Ok la! Do already\n" + task + "\n";
    }

    public String showUnmarked(Task task) {
        return "Huh why haven't do?!\n" + task + "\n";
    }
}

