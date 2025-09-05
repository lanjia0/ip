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
    public void showMessage(String message) {
        System.out.println(message);
    }

    // prints greeting
    public void showGreeting() {
        showMessage("Eh! I'm Soon Tong\nWhat you want?!");
    }

    // prints goodbye message
    public void showGoodbye() {
        showMessage("Bye. Why you still here?!");
    }

    // prints error message
    public void showError() {
        showMessage("Walao, cannot load data file leh!");
    }
}

