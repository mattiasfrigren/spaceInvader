package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Constants;
import model.InGameModel;

import java.util.Scanner;


public class ViewManager {

    private static ViewManager view;

    private Scene mainScene;
    private Stage mainStage;
    private IViewState gameState;

    private boolean changeGameState = true;

    public boolean isChangeGameState() {
        return changeGameState;
    }

    public void setChangeGameState(boolean changeGameState) {
        this.changeGameState = changeGameState;
    }

    public Stage getMainStage() {
        return mainStage;
    }

    public static ViewManager getViewManager(Stage stage) {
        if (view == null) {
            view = new ViewManager(stage);
        }
        return view;
    }

    public static ViewManager getViewManager() {
        return view;
    }


    private ViewManager(Stage stage) {

       /* if (changeGameState) {
            gameState = SpaceInvaderMenuView.getSpaceInvaderMenuView();
            mainScene = ((SpaceInvaderMenuView) gameState).getMenuScene();
            mainStage = stage;
            mainStage.setScene(mainScene);
        }*/
        //else {
        gameState = SpaceInvaderMenuView.getSpaceInvaderMenuView();
        // gameState = SpaceInvaderInGameView.getGameView();
        mainScene = ((SpaceInvaderMenuView) gameState).getMenuScene();
        mainStage = stage;
        mainStage.setTitle("SpaceInvader");
        mainStage.setScene(mainScene);
        mainStage.setResizable(false);
        mainStage.sizeToScene();
        // }
        stage.show();


    }

    public void resetGameScene() {
        SpaceInvaderInGameView.getGameView().resetGame();
        InGameModel.getGameModel().resetAllModel();
        changeToInGameScene(true);
    }

    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
        mainStage.setScene(mainScene);
    }

    public void changeToInGameScene(boolean isPlaying) {

        if (isPlaying) {
            gameState = SpaceInvaderInGameView.getGameView();
            mainScene = ((SpaceInvaderInGameView) gameState).getGameScene();
        } else {
            gameState = SpaceInvaderMenuView.getSpaceInvaderMenuView();
            mainScene = ((SpaceInvaderMenuView) gameState).getMenuScene();
        }
        mainStage.setScene(mainScene);


    }

}
