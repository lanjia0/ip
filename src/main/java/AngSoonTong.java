import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class AngSoonTong {
    public static void main(String[] args) {
        System.out.println("Eh! I'm Soon Tong\nWhat you want?!");

        String[] list = new String[100];
        boolean running = true;
        int index = 0;
        Scanner sc = new Scanner(System.in);

        while (running) {

            String curr = sc.nextLine();

            if (Objects.equals(curr, "bye")) {
                running = false;
            } else if (Objects.equals(curr, "list")) {
                int num = 0;

                while (num < index) {
                    System.out.printf("%d. %s\n", num + 1, list[num]);
                    num++;
                }

            } else {
                list[index] = curr;
                index++;

                System.out.printf("added: %s\n", curr);
            }

        }

        System.out.println("Bye. Why you still here?!");
    }
}
