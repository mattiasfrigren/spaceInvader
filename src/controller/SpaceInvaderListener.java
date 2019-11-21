package controller;


import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import view.ViewManager;

public class SpaceInvaderListener implements EventHandler<KeyEvent> {

    private static SpaceInvaderListener listener;
    private static ViewManager view;

    public static SpaceInvaderListener getListener(ViewManager view) {
        if (listener == null) {
            listener = new SpaceInvaderListener(view);
        }
        return listener;
    }

    private SpaceInvaderListener(ViewManager view) {
        this.view = view;
    }

    @Override
    public void handle(KeyEvent event) {
        if (event.getEventType().equals(KeyEvent.KEY_PRESSED)) {
            if (event.getCode() == KeyCode.SPACE) {
                view.setShooting(true);
            }
        }
        else if (event.getEventType().equals(KeyEvent.KEY_RELEASED)) {
            if (event.getCode() == KeyCode.SPACE) {
                view.setShooting(false);
            }
        }

    }
}
