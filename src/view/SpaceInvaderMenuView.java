package view;

import controller.SpaceInvaderListener;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import model.Constants;

import java.util.Scanner;

public class SpaceInvaderMenuView implements IViewState {


    private static SpaceInvaderMenuView spaceInvaderMenuView;

    public static Scene getMenuScene() {
        return menuScene;
    }

    private static Scene menuScene;
    private static AnchorPane menuPane;


    public static SpaceInvaderMenuView getSpaceInvaderMenuView() {
        if (spaceInvaderMenuView==null) {
            spaceInvaderMenuView = new SpaceInvaderMenuView();
        }
        return spaceInvaderMenuView;
    }
    private SpaceInvaderMenuView() {
        menuPane = new AnchorPane();
        menuScene = new Scene(menuPane, Constants.SCREENWIDTH,Constants.SCREENHEIGHT);
        Button startButton = new Button("start Game");
        menuPane.getChildren().add(startButton);

    }

    //- menuView : SpaceInvaderMenuView
    //- menuPane : AnchorPane - menuScene : Scene - menuStage Stage

    //-SpaceInvaderMenuView()
    //+getStage:inGameStage


}
