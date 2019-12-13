package controller;

import javafx.stage.Stage;
import model.InGameModel;
import view.SpaceInvaderInGameView;
import view.ViewManager;

public class SpaceInvaderController {

    private static SpaceInvaderController controller;
    private static SpaceInvaderListener listener;
    private static ViewManager view;
    private static InGameModel gameModel;

    private boolean soundOn = true;
    private boolean gamePaused = false;

    public static SpaceInvaderController getController(Stage stage) {
        if (controller == null) {
            controller = new SpaceInvaderController(stage);
        }
        return controller;
    }

    public static SpaceInvaderController getController() {
        return controller;
    }

    public boolean isSoundOn() {
        return soundOn;
    }

    public void setSoundOn(boolean soundOn) {
        this.soundOn = soundOn;
    }

    private SpaceInvaderController(Stage stage) {
        this.gameModel = InGameModel.getGameModel();
        this.view = ViewManager.getViewManager(stage);
        listener = SpaceInvaderListener.getListener();
    }


    public void pauseGame() {
        gamePaused = gamePaused ? false : true;
        SpaceInvaderInGameView.getGameView().setAnimationTimer(gamePaused);
    }


    }


