package controller;

import javafx.application.Application;
import javafx.stage.Stage;

public class SpaceInvaderController extends Application {

    private static SpaceInvaderController controller;

    public static SpaceInvaderController getController (String[] args) {
        if (controller == null) {
            controller = new SpaceInvaderController(args);
        }
        return controller;
    }

    private SpaceInvaderController(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // add menu....
//
    }


    //-SpaceInvaderListener : listener


    }


