package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import model.HighScore;
import model.InGameModel;
import model.SoundEffects;
import view.SpaceInvaderInGameView;
import view.SpaceInvaderMenuView;
import view.ViewManager;
import java.sql.SQLException;

/**
 * This class takes care of the menu scene of the game, a menu with the options to start playing, view the high score,
 * learn how to play, read credits or quit the program.
 *
 * @author Isabelle Romhagen, Ludvig Lundin, Mattias Frigren, Khazar Mehraban
 * @version 1.2
 */
public class SpaceInvaderButtonListener {

    private static SpaceInvaderButtonListener buttonListener;

    public static SpaceInvaderButtonListener getButtonListener() {
        if (buttonListener == null) {
            buttonListener = new SpaceInvaderButtonListener();
        }
        return buttonListener;
    }

    /**
     * Resets to the initial game state.
     */
    public EventHandler<MouseEvent> resetGameEvent = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            SpaceInvaderInGameView.getGameView().setAnimationTimer(false);
            SpaceInvaderController.getController().resetController();
            InGameModel.getGameModel().resetAllModel();
            SpaceInvaderInGameView.getGameView().resetGame();
            SpaceInvaderInGameView.getGameView().setAnimationTimer(true);
        }
    };

    /**
     * Sets state to menu view.
     */
    public EventHandler<MouseEvent> enterMenu = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            System.out.println("enter menu");
            SoundEffects.stopMusic();
            SpaceInvaderInGameView.getGameView().setAnimationTimer(false);
            SpaceInvaderController.getController().resetController();
            InGameModel.getGameModel().resetAllModel();
            SpaceInvaderInGameView.getGameView().resetGame();
            ViewManager.getViewManager().changeToInGameScene(false);
        }
    };

    /**
     * Passes on player alias and score to the high score class and disables the save button.
     */
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

    /**
     * Changes view to in game view and starts the game
     */
    public EventHandler<MouseEvent>startGame=new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                ViewManager.getViewManager().changeToInGameScene(true);
                SpaceInvaderInGameView.getGameView().setAnimationTimer(true);
            }
            }
        };

    /**
     * Closes high score sub scene if active, opens it if not.
     */
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

    /**
     * Opens subsceen to pick a ship.
     */
    public EventHandler<MouseEvent>chooseShip=new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                if (SpaceInvaderMenuView.getSpaceInvaderMenuView().getCurrentSubScene()!=null) {
                    if (SpaceInvaderMenuView.getSpaceInvaderMenuView().getCurrentSubScene().getId().equals("shipChoose")) {
                        SpaceInvaderMenuView.getSpaceInvaderMenuView().cleanCurrentSubScene(); }
                    else
                        { SpaceInvaderMenuView.getSpaceInvaderMenuView().initializeChooseShipSubScene(); } }
                else { SpaceInvaderMenuView.getSpaceInvaderMenuView().initializeChooseShipSubScene(); }
            }
        }
    };

    /**
     * Closes settings sub scene if active, opens it if not.
     */

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

    /**
     * Closes help sub scene if active, opens it if not.
     */
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

    /**
     * Closes credits sub scene if active, opens it if not.
     */
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

    /**
     * Opens the exit sub scene.
     */
    public EventHandler<MouseEvent>exit=new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                ViewManager.getViewManager().initializeExitSubScene();
            }
        }
    };

    /**
     * Exits program if yes button was pressed.
     */
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