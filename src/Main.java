import controller.SpaceInvaderController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class. Launches the program and gets the stage.
 *
 * @author Ludvig Lundin, Mattias Frigren
 * @version 1.2
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            SpaceInvaderController.getController(stage);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
