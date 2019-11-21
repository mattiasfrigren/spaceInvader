package view;

import controller.SpaceInvaderListener;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.*;

import java.util.ArrayList;

public class ViewManager {
    private static ViewManager view;
    private AnchorPane mainPane;
    private Scene mainScene;

    private boolean isShooting = false;

    public Stage getMainStage() {
        return mainStage;
    }

    private Stage mainStage;

    public boolean isShooting() {
        return isShooting;
    }

    public void setShooting(boolean shooting) {
        isShooting = shooting;
    }

    public ArrayList<OnScreenItems> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<OnScreenItems> enemies) {
        this.enemies = enemies;
    }

    public ArrayList<OnScreenItems> getBullets() {
        return bullets;
    }

    public void setBullets(ArrayList<OnScreenItems> bullets) {
        this.bullets = bullets;
    }

    public PlayerShip getPlayer() {
        return player;
    }

    public void setPlayer(PlayerShip player) {
        this.player = player;
    }

    private ArrayList<OnScreenItems> enemies;
    private ArrayList<OnScreenItems> bullets;
    private PlayerShip player;


    private ViewManager() {
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, Constants.SCREENWIDTH, Constants.SCREENHEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);


        initializeLevelToPane();
        initializeGameListener();

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

    private void initializeLevelToPane() {
        mainPane.getChildren().add(player);
    }

    private void initializeGameListener() {
        mainScene.setOnKeyPressed(SpaceInvaderListener.getListener(this));
        mainScene.setOnKeyReleased(SpaceInvaderListener.getListener(this));
    }





}
