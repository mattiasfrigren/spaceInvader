package controller;

import javafx.stage.Stage;
import model.InGameModel;
import view.ViewManager;

public class SpaceInvaderController {

    private static SpaceInvaderController controller;
    private static SpaceInvaderListener listener;
    private static ViewManager view;
    private static InGameModel gameModel;

    public static SpaceInvaderController getController(Stage stage) {
        if (controller == null) {
            controller = new SpaceInvaderController(stage);
        }
        return controller;
    }


    private SpaceInvaderController(Stage stage) {
        this.gameModel = InGameModel.getGameModel();
        this.view = ViewManager.getViewManager(stage);
        listener = SpaceInvaderListener.getListener();

        


    }




    }


