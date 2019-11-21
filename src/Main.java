import controller.SpaceInvaderController;
import javafx.application.Application;
import javafx.stage.Stage;
import view.SpaceInvaderInGameView;
import view.ViewManager;

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
