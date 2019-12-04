package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Constants;

import java.util.Scanner;


public class  ViewManager{

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

    private ViewManager(Stage stage) {

       /* if (changeGameState) {
            gameState = SpaceInvaderMenuView.getSpaceInvaderMenuView();
            mainScene = ((SpaceInvaderMenuView) gameState).getMenuScene();
            mainStage = stage;
            mainStage.setScene(mainScene);
        }*/
        //else {
            gameState = SpaceInvaderInGameView.getGameView();
            mainScene = ((SpaceInvaderInGameView) gameState).getGameScene();
            mainStage = stage;
            mainStage.setTitle("SpaceInvader");
            mainStage.setScene(mainScene);
            mainStage.setResizable(false);
            mainStage.sizeToScene();
       // }
        stage.show();


    }

    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
        mainStage.setScene(mainScene);
    }

}
