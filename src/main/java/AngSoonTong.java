import java.util.Objects;
import java.util.Scanner;

public class AngSoonTong {
    public static void main(String[] args) {
        System.out.println("Eh! I'm Soon Tong\nWhat you want?!");

        boolean running = true;
        Scanner sc = new Scanner(System.in); // initialise scanner

        while (running) {
            String curr = sc.nextLine(); // to get user input

            if (Objects.equals(curr, "bye")) { // if user inputs bye, end while loop
                running = false;
            } else {
                System.out.printf("%s", curr); // echoes the user's input
            }
        }

        System.out.println("Bye. Why you still here?!"); // ending message
    }
}
