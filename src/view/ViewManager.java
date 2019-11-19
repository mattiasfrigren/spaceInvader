package view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Constants;
import model.SpaceInvaderModel;

public class ViewManager {
    private static ViewManager view;
    private AnchorPane mainPane;
    private Scene mainScene;

    public Stage getMainStage() {
        return mainStage;
    }

    private Stage mainStage;


    private ViewManager() {
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, Constants.SCREENWIDTH, Constants.SCREENHEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);

        SpaceInvaderModel.getModel().createAll(mainPane);
    }




    public static ViewManager getViewManager() {
        if (view == null) {
            view = new ViewManager();
        }
        return view;
    }

    public AnchorPane getMainPane() {
            return mainPane;
    }





}
