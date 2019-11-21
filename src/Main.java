import controller.SpaceInvaderController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.SpaceInvaderModel;
import view.ViewManager;

public class Main extends Application {

    public static void main(String[] args) {
        SpaceInvaderController.getController();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            ViewManager manager = ViewManager.getViewManager();
            primaryStage = manager.getMainStage();

            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
