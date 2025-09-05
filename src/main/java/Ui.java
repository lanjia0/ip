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

    // prints error message
    public void showError() {
        show("Walao, cannot load data file leh!");
    }
}

