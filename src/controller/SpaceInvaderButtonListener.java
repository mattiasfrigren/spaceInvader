package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class SpaceInvaderButtonListener {

    private static SpaceInvaderButtonListener buttonListener;

    public static SpaceInvaderButtonListener getButtonListener() {
        if (buttonListener == null) {
            buttonListener = new SpaceInvaderButtonListener();
        }
        return buttonListener;
    }


    public EventHandler<MouseEvent> resetGameEvent = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            System.out.println("reset game");
        }
    };

    public EventHandler<MouseEvent> saveScoreEvent = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            System.out.println("Score saved");
        }
    };

    // TODO add more event handlers below
}

