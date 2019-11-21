package view;

import controller.SpaceInvaderListener;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Constants;
import model.InGameModel;
import model.PlayerShip;

import java.util.ArrayList;

public class SpaceInvaderInGameView implements IViewState {


    private static SpaceInvaderInGameView gameView;

    private static AnchorPane gamePane;
    private static Scene gameScene;

    private ArrayList<ImageView> enemies = new ArrayList<>();
    private ArrayList<ImageView> bullets = new ArrayList<>();;
    private ImageView player;

    public static Scene getGameScene() {
        return gameScene;
    }

    public static SpaceInvaderInGameView getGameView() {
        if (gameView == null) {
            gameView = new SpaceInvaderInGameView();
        }
        return gameView;
    }

    private SpaceInvaderInGameView() {
        gamePane = new AnchorPane();
        gameScene = new Scene(gamePane, Constants.SCREENWIDTH, Constants.SCREENHEIGHT);


        initializeLevelToPane();
        initializeGameListener();


    }

    private void initializeLevelToPane() {
        initializePlayer();
    }

    private void initializePlayer() {
        PlayerShip playerModel = InGameModel.getGameModel().getPlayer();
        player = new ImageView(playerModel.getImageUrl());
        player.setX(playerModel.getItemCoordX());
        player.setY(playerModel.getItemCoordY());
        player.resize(playerModel.getItemWidth(), playerModel.getItemHeight());

        addToGamePane(player);
    }

    private void initializeGameListener() {
        gameScene.setOnKeyPressed(SpaceInvaderListener.getListener());
        gameScene.setOnKeyReleased(SpaceInvaderListener.getListener());
    }

    private void addToGamePane(ImageView imageItem) {
        gamePane.getChildren().add(imageItem);
    }




}
