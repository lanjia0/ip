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

            if (Objects.equals(curr, "bye")) {
                running = false;
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

                System.out.printf("added: " + newTask.toString() + "\n", curr);
            }

        }

        System.out.println("Bye. Why you still here?!");
    }
}
