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

            if (Objects.equals(curr, "bye")) {
                running = false;
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

            } else {
                Task newTask = new Task(curr);
                list[index] = newTask;
                index++;

                System.out.printf("added: " + newTask + "\n", curr);
            }

        }

        System.out.println("Bye. Why you still here?!");
    }
}
