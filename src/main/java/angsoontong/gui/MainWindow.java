package angsoontong.gui;

import angsoontong.AngSoonTong;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private AngSoonTong angSoonTong;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/AhBeng.png"));
    private Image ASTImage = new Image(this.getClass().getResourceAsStream("/images/AngSoonTong.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the AST instance */
    public void setAngSoonTong(AngSoonTong ast) {
        angSoonTong = ast;
        dialogContainer.getChildren().add(
                DialogBox.getASTDialog("Eh! I'm Soon Tong\nWhat you want?!", ASTImage)
        );
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = angSoonTong.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getASTDialog(response, ASTImage)
        );
        userInput.clear();

        // shutdown on 'bye' input
        if (input.trim().equalsIgnoreCase("bye")) {
            // delay a bit so user sees the final message
            new Thread(() -> {
                try {
                    Thread.sleep(1000); // 1 second delay
                } catch (InterruptedException e) {
                    // ignore
                }
                javafx.application.Platform.exit();
            }).start();
        }
    }
}
