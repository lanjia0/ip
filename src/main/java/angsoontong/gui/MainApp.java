package angsoontong.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainApp extends Application {
    private static final String DEFAULT_FILE_PATH = "data/tasks.txt";
    // ...

    // Existing constructor
    public MainApp(String filePath) {
        // ...
    }

    // Overloaded constructor
    public MainApp() {
        this(DEFAULT_FILE_PATH);
    }

    @Override
    public void start(Stage stage) {
        Label helloWorld = new Label("Hello World!"); // Creating a new Label control
        Scene scene = new Scene(helloWorld); // Setting the scene to be our Label

        stage.setScene(scene); // Setting the stage to show our scene
        stage.show(); // Render the stage.
    }
}
