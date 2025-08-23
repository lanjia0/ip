import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class AngSoonTong {
    public static void main(String[] args) {
        System.out.println("Eh! I'm Soon Tong\nWhat you want?!");

        Task[] list = new Task[100];
        boolean running = true;
        int index = 0;
        Scanner sc = new Scanner(System.in);

        while (running) {

            String curr = sc.nextLine();
            String[] words = curr.split(" "); // split by spaces
            String firstWord = words[0];      // take the first word
            String[] slash = curr.split("/");

            if (Objects.equals(curr, "bye")) {
                running = false;
            } else if (Objects.equals(words[0], "todo") ||
                       Objects.equals(words[0], "event") ||
                        Objects.equals(words[0], "deadline")) {
                String str = words[0];

                // checking for no task description after task keyword
                try {
                    String test = words[1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Oi! The description cannot be empty la!\n");
                    continue;
                }

                if (Objects.equals(str, "todo")) {
                    Task newTask = new ToDo(slash[0].substring(5));
                    list[index] = newTask;
                    index++;

                    System.out.printf("Steady! I add this already:\n  " + newTask + "\n");
                    System.out.printf("Now your list got %d tasks.\n", index);
                } else if (Objects.equals(str, "event")) {
                    Task newTask = new Event(slash[0].substring(6),slash[1], slash[2]);
                    list[index] = newTask;
                    index++;

                    System.out.printf("Steady! I add this already:\n  " + newTask + "\n");
                    System.out.printf("Now your list got %d tasks.\n", index);
                } else {
                    Task newTask = new Deadline(slash[0].substring(9), slash[1]);
                    list[index] = newTask;
                    index++;

                    System.out.printf("Steady! I add this already:\n  " + newTask + "\n");
                    System.out.printf("Now your list got %d tasks.\n", index);
                }
            } else if (Objects.equals(firstWord, "mark")) {
                int x = Integer.valueOf(words[1]);
                Task currTask = list[x - 1];
                currTask.markDone();

                System.out.println("Ok la! Do already\n" + currTask);
            } else if (Objects.equals(firstWord, "unmark")) {
                int x = Integer.valueOf(words[1]);
                Task currTask = list[x - 1];
                currTask.markUndone();

                System.out.println("Huh why haven't do?!\n" + currTask);
            } else if (Objects.equals(curr, "list")) {
                int num = 0;
                System.out.println("Oi! This one your list.");

                while (num < index) {
                    System.out.printf("%d." + list[num] + "\n", num + 1);
                    num++;
                }

            } else { // if no keywords are detected
                System.out.println("Eh! Say properly leh, I don't know what that means la!\n");
            }

        }

        System.out.println("Bye. Why you still here?!");
    }
}
