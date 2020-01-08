package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.SubScene;
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
            InGameModel.getGameModel().resetAllModel();
            SpaceInvaderInGameView.getGameView().setAnimationTimer(false);
            SpaceInvaderController.getController().resetController();
            InGameModel.getGameModel().resetAllModel();
            SpaceInvaderInGameView.getGameView().resetGame();
            SpaceInvaderInGameView.getGameView().setAnimationTimer(true);
        }
    };

    public EventHandler<MouseEvent> enterMenu = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            System.out.println("enter menu");
            SpaceInvaderInGameView.getGameView().setAnimationTimer(false);
            SpaceInvaderController.getController().resetController();
            InGameModel.getGameModel().resetAllModel();
            SpaceInvaderInGameView.getGameView().resetGame();
            ViewManager.getViewManager().changeToInGameScene(false);
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
            SpaceInvaderInGameView.getGameView().initializeDeathSubScene(true);
        }
    };
    public EventHandler<MouseEvent>startGame=new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                ViewManager.getViewManager().changeToInGameScene(true);
                SpaceInvaderInGameView.getGameView().setAnimationTimer(true);
            }
            }
        };
    public EventHandler<MouseEvent>showHighScore=new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                if (SpaceInvaderMenuView.getSpaceInvaderMenuView().getCurrentSubScene()!=null) {
                    if (SpaceInvaderMenuView.getSpaceInvaderMenuView().getCurrentSubScene().getId().equals("highScoreScene")) {
                        SpaceInvaderMenuView.getSpaceInvaderMenuView().cleanCurrentSubScene(); }
                    else { SpaceInvaderMenuView.getSpaceInvaderMenuView().initializeHighScoreSubScene(); } }
                else { SpaceInvaderMenuView.getSpaceInvaderMenuView().initializeHighScoreSubScene(); }
            }
        }
    };

    public EventHandler<MouseEvent>showSettings=new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                if (SpaceInvaderMenuView.getSpaceInvaderMenuView().getCurrentSubScene()!=null) {
                    if (SpaceInvaderMenuView.getSpaceInvaderMenuView().getCurrentSubScene().getId().equals("settingScene")) {
                        SpaceInvaderMenuView.getSpaceInvaderMenuView().cleanCurrentSubScene(); }
                    else { SpaceInvaderMenuView.getSpaceInvaderMenuView().initializeSettingsSubScene(); } }
                else { SpaceInvaderMenuView.getSpaceInvaderMenuView().initializeSettingsSubScene(); }
            }
        }
    };

    public EventHandler<MouseEvent>showHelp=new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                if (SpaceInvaderMenuView.getSpaceInvaderMenuView().getCurrentSubScene()!=null) {
                    if (SpaceInvaderMenuView.getSpaceInvaderMenuView().getCurrentSubScene().getId().equals("helpScene")) {
                        SpaceInvaderMenuView.getSpaceInvaderMenuView().cleanCurrentSubScene(); }
                    else { SpaceInvaderMenuView.getSpaceInvaderMenuView().initializeHelpSubScene(); } }
                else { SpaceInvaderMenuView.getSpaceInvaderMenuView().initializeHelpSubScene(); }
            }
        }
    };

    public EventHandler<MouseEvent>showCredits=new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                if (SpaceInvaderMenuView.getSpaceInvaderMenuView().getCurrentSubScene()!=null) {
                    if (SpaceInvaderMenuView.getSpaceInvaderMenuView().getCurrentSubScene().getId().equals("creditScene")) {
                        SpaceInvaderMenuView.getSpaceInvaderMenuView().cleanCurrentSubScene(); }
                    else { SpaceInvaderMenuView.getSpaceInvaderMenuView().initializeCreditsSubScene(); } }
                else { SpaceInvaderMenuView.getSpaceInvaderMenuView().initializeCreditsSubScene(); }
            }
        }
    };

    public EventHandler<MouseEvent>exit=new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                ViewManager.getViewManager().initializeExitSubScene();
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

    // TODO add more event handlers below
}