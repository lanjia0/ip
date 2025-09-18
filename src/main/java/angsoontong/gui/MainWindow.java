package angsoontong.gui;

import angsoontong.AngSoonTong;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;


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

    private static class LyricLine {
        final double atSec;   // when to show (seconds from start)
        final String text;
        LyricLine(double atSec, String text) { this.atSec = atSec; this.text = text; }
    }

    // lyrics
    private final java.util.List<LyricLine> LYRICS = java.util.List.of(
            new LyricLine(0.3,  "希望你以后不会后悔没选择我"),
            new LyricLine(6.4,  "也相信你有更好的生活"),
            new LyricLine(13.0,  "我会在心里"),
            new LyricLine(15.5,  "默默地为你而执着~")
    );

    private AngSoonTong angSoonTong;
    private Timeline lyricsTimeline;
    private MediaPlayer player;

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

    private void sing() {
        // setup media
        String path = getClass().getResource("/audio/song.wav").toExternalForm();
        player = new MediaPlayer(new Media(path));
        player.setStopTime(Duration.seconds(21));

        // lyric timeline
        if (lyricsTimeline != null) lyricsTimeline.stop();
        lyricsTimeline = new Timeline();
        lyricsTimeline.setCycleCount(1);

        // add keyframe for each lyric line
        for (LyricLine line : LYRICS) {
            lyricsTimeline.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(line.atSec), e -> showResponse(line.text))
            );
        }

        player.play();
        lyricsTimeline.play();

        // cleanup when media ends
        player.setOnEndOfMedia(() -> {
            if (lyricsTimeline != null) lyricsTimeline.stop();
        });
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

        if (input.equalsIgnoreCase("sing")) {
            sing();
            userInput.clear();
            return;
        }

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

    /**
     * Adds a line of text to the chat window as the chatbot's response.
     */
    public void showResponse(String text) {
        Label label = new Label(text);
        label.setWrapText(true);
        dialogContainer.getChildren().add(label);

        // ensure we’re not setting a bound property
        javafx.application.Platform.runLater(() -> {
            scrollPane.vvalueProperty().unbind();   // <— important
            scrollPane.setVvalue(1.0);
        });
    }

}
