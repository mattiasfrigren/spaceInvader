package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Constants;


public class ViewManager{

    private static ViewManager view;

    private Scene mainScene;
    private Stage mainStage;
    private IViewState gameState;

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

        gameState = SpaceInvaderInGameView.getGameView();
        mainScene = ((SpaceInvaderInGameView) gameState).getGameScene();
        mainStage = stage;
        mainStage.setTitle("SpaceInvader");
        mainStage.setScene(mainScene);
        mainStage.setResizable(false);
        mainStage.sizeToScene();

        stage.show();
    }

    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
        mainStage.setScene(mainScene);
    }



}
