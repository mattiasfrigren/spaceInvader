package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import model.HighScore;
import model.InGameModel;
import view.SpaceInvaderInGameView;
import view.SpaceInvaderMenuView;
import view.ViewManager;

import java.sql.SQLException;

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
            ViewManager.getViewManager().resetGameScene();
        }
    };

    public EventHandler<MouseEvent> saveScoreEvent = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            String name = SpaceInvaderInGameView.getGameView().getEnterNameField().getText();
            try {
                HighScore.getHighScore().saveNewHighscore(name, InGameModel.getGameModel().getPoints());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("Score saved");
        }
    };
    public EventHandler<MouseEvent>startGame=new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                ViewManager.getViewManager().changeToInGameScene(true);
            }
            }
        };
    public EventHandler<MouseEvent>showHighScore=new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                SpaceInvaderMenuView.getSpaceInvaderMenuView().initializeHighScoreSubScene();
            }
        }
    };

    public EventHandler<MouseEvent>showSettings=new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                SpaceInvaderMenuView.getSpaceInvaderMenuView().initializeSettingsSubScene();
            }
        }
    };

    public EventHandler<MouseEvent>showHelp=new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                SpaceInvaderMenuView.getSpaceInvaderMenuView().initializeHelpSubScene();
            }
        }
    };

    public EventHandler<MouseEvent>showCredits=new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                SpaceInvaderMenuView.getSpaceInvaderMenuView().initializeCreditsSubScene();
            }
        }
    };

    public EventHandler<MouseEvent>exit=new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                SpaceInvaderMenuView.getSpaceInvaderMenuView().initializeExitSubScene();

            }
        }
    };

    public EventHandler<MouseEvent>reallyExit=new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                System.exit(0);

            }
        }
    };

    public EventHandler<MouseEvent>exitToMenu=new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getButton().equals(MouseButton.PRIMARY)) {

                SpaceInvaderMenuView.getSpaceInvaderMenuView().closeCurrentSubScene();

            }
        }
    };

    // TODO add more event handlers below
}