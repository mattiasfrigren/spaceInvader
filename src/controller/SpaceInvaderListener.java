package controller;


import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.InGameModel;
import view.IViewState;

public class SpaceInvaderListener implements EventHandler<KeyEvent> {

    private static SpaceInvaderListener listener;

    public static SpaceInvaderListener getListener() {
        if (listener == null) {
            listener = new SpaceInvaderListener();
        }
        return listener;
    }

    private SpaceInvaderListener() { }

    @Override
    public void handle(KeyEvent event) {
        if (event.getEventType().equals(KeyEvent.KEY_PRESSED)) {
            if (event.getCode() == KeyCode.SPACE) {
                InGameModel.getGameModel().setShooting(true);
            }
        }
        else if (event.getEventType().equals(KeyEvent.KEY_RELEASED)) {
            if (event.getCode() == KeyCode.SPACE) {
                InGameModel.getGameModel().setShooting(true);
            }
        }

    }
}
