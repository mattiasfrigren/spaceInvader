package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SpaceInvaderButtonListener implements EventHandler<ActionEvent> {

    private static SpaceInvaderButtonListener buttonListener;

    public static SpaceInvaderButtonListener getButtonListener() {
        if (buttonListener == null) {
            buttonListener = new SpaceInvaderButtonListener();
        }
        return buttonListener;
    }

    public void catchUserInput(ActionEvent event){

    }

    @Override
    public void handle(ActionEvent event) {
        model.InGameModel.getGameModel().setSaveGameButtonClicked(true);
    }
}

