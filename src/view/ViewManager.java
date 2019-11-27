package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


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
        mainStage.setScene(mainScene);
        stage.show();
    }

    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
        mainStage.setScene(mainScene);
    }

}
