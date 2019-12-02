package view;

import controller.SpaceInvaderListener;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.*;

import java.util.ArrayList;

public class SpaceInvaderInGameView implements IViewState {


    private static SpaceInvaderInGameView gameView;
    private static InGameModel model;

    private static AnchorPane gamePane;
    private static Scene gameScene;

    private ImageView meteor = new ImageView(Constants.meteorImage);
    private ArrayList<ImageView> enemiesImageList = new ArrayList<>();
    private ArrayList<ImageView> bulletsImageList = new ArrayList<>();;
    private ImageView playerImage;
    private ImageView firstBackGroundImage = new ImageView(Constants.BackGroundImage);
    private ImageView secondBackGroundImage = new ImageView(Constants.BackGroundImage);

    private AnimationTimer inGameTimer;

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

        model = InGameModel.getGameModel();
        gamePane = new AnchorPane();
        gameScene = new Scene(gamePane, Constants.SCREENWIDTH, Constants.SCREENHEIGHT);


        initializeLevelToPane();  //adds all images to the pane.
        initializeGameListener(); // add key listener to game
        createGameLoop(); // starts animator.

    }

    private void createGameLoop() {
        inGameTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            // checks and update movement of images
                updateAllModels(); // update all models before checks.
                updateAllImageviews();
                updateIfPlayerIsShooting();
            }
        };

        inGameTimer.start();
    }

    //add all model updates here
    private void updateAllModels() {
        model.updateBullets();
        model.updateWeaponsState();
        model.updatePlayerMovement();
        model.moveMeteor();
    }

    //add all imagesviews here
    private void updateAllImageviews() {
        updateBackGround();
        updatePlayerImage();
        updateBulletsImage();
        moveMeteorImage();
    }
    private void updatePlayerImage(){
        PlayerShip player = model.getPlayerModel();
        playerImage.setX(player.getItemCoordX());
        playerImage.setY(player.getItemCoordY());
    }


// update the bullets images to mirror the model bullets.
    private void updateBulletsImage() {
        ArrayList<IBullet> bulletsModelList = model.getBulletsModelList();

        if (!bulletsImageList.isEmpty()) {
                for (int i = 0; i < bulletsImageList.size(); i++) {
                    ImageView theImageBullet = bulletsImageList.get(i);
                    OnScreenItems theModelBullet = (OnScreenItems) bulletsModelList.get(i);

                    theImageBullet.setX(theModelBullet.getItemCoordX());
                    theImageBullet.setY(theModelBullet.getItemCoordY());
                }
        }

        ArrayList<IBullet> bulletsToRemove = model.getBulletRemoveList(); // adds all bullets who are out of screen and those who collided.
        if (!bulletsToRemove.isEmpty()) {
            for (int i = 0; i < bulletsToRemove.size(); i++) {
                IBullet theModelBullet = bulletsToRemove.get(i);
                int bulletModelIndex = model.getBulletsModelList().indexOf(theModelBullet);  // gets index of the model bullet.
                ImageView theBulletImage = bulletsImageList.get(bulletModelIndex);
                removeFromGamePane(theBulletImage); // removes bullet image from pane.
                bulletsImageList.remove(theBulletImage); // removes bullet image from our bullet image list.
                System.out.println("Bullet removed");
            }
        }

    }

    private void updateIfPlayerIsShooting() {
        IBullet currentBullet = model.checkIfPlayerIsShooting();
        if (currentBullet != null) {
          createBullet(currentBullet);
        }
    }

    private void updateBackGround() {
        firstBackGroundImage.setY(firstBackGroundImage.getY()+5);
        secondBackGroundImage.setY(secondBackGroundImage.getY()+5);
        if (firstBackGroundImage.getY()>=Constants.SCREENHEIGHT) {
            firstBackGroundImage.setY(-Constants.SCREENHEIGHT);
        }
        if (secondBackGroundImage.getY() >= Constants.SCREENHEIGHT) {
            secondBackGroundImage.setY(-Constants.SCREENHEIGHT);
        }
    }

    // sets the imageView based on the model Ibullet.
    private void createBullet(IBullet bullet) {
        OnScreenItems itemBullet = (OnScreenItems) bullet;
        System.out.println("bullet image created at x: " + itemBullet.getItemCoordX() + " y: " + itemBullet.getItemCoordY());
        ImageView imageBullet = new ImageView(itemBullet.getImageUrl());
        imageBullet.setX(itemBullet.getItemCoordX());
        imageBullet.setY(itemBullet.getItemCoordY());
        imageBullet.setPreserveRatio(true);
        imageBullet.setFitHeight(itemBullet.getItemHeight());
        imageBullet.setFitWidth(itemBullet.getItemWidth());
               //imageBullet.resize(itemBullet.getItemWidth(), itemBullet.getItemHeight());

        if (itemBullet.isFacingPlayer()) {
            imageBullet.setRotate(180);
        }

        bulletsImageList.add(imageBullet);
        addToGamePane(imageBullet);
    }

    private void createBackGround() {
        firstBackGroundImage.setPreserveRatio(true);
        firstBackGroundImage.setFitWidth(Constants.SCREENWIDTH);
        firstBackGroundImage.setFitHeight(Constants.SCREENHEIGHT);
        addToGamePane(firstBackGroundImage);
        secondBackGroundImage.setPreserveRatio(true);
        secondBackGroundImage.setFitWidth(Constants.SCREENWIDTH);
        secondBackGroundImage.setFitHeight(Constants.SCREENHEIGHT);
        secondBackGroundImage.setY(-Constants.SCREENHEIGHT);
        addToGamePane(secondBackGroundImage);
    }
    private void createMeteor() {
        meteor.setY(model.getMeteor().getItemCoordY());
        meteor.setX(model.getMeteor().getItemCoordX());
        addToGamePane(meteor);
    }
    private void moveMeteorImage() {
        meteor.setY(meteor.getY()+10);
        if (meteor.getY()>=Constants.SCREENHEIGHT+100) {
            removeFromGamePane(meteor);
            createMeteor();
        }
    }

    private void initializeLevelToPane() {
        createBackGround();
        initializePlayer();
        initializeEnemies();
        createMeteor();
        //TODO add all starting images.
    }

    private void initializeEnemies() {

        ArrayList<EnemyShip> enemyModelList = model.getEnemy();
        for (int i = 0; i <enemyModelList.size(); i++) {
            EnemyShip enemyModel = enemyModelList.get(i);
            ImageView enemyImage = new ImageView(new Image(Constants.enemyShipURL));
            enemyImage.setX(enemyModel.getItemCoordX());
            enemyImage.setY(enemyModel.getItemCoordY());
            enemyImage.setPreserveRatio(true);
            enemyImage.setFitHeight(enemyModel.getItemHeight());
            enemyImage.setFitWidth(enemyModel.getItemWidth());
            addToGamePane(enemyImage);
            enemiesImageList.add(enemyImage);
        }
    }

    //Creates the image of the player and set it's position and add to pane.
    private void initializePlayer() {
        PlayerShip playerModel = model.getPlayerModel();
        playerImage = new ImageView(playerModel.getImageUrl());
        playerImage.setX(playerModel.getItemCoordX());
        playerImage.setY(playerModel.getItemCoordY());
        playerImage.setPreserveRatio(true);
        playerImage.setFitHeight(playerModel.getItemHeight());
        playerImage.setFitWidth(playerModel.getItemWidth());
        System.out.println(playerImage.getX() + " Player start pos");
        //playerImage.resize(playerModel.getItemWidth(), playerModel.getItemHeight());
        addToGamePane(playerImage);
    }

    // starts the listeners.
    private void initializeGameListener() {
        gameScene.setOnKeyPressed(SpaceInvaderListener.getListener());
        gameScene.setOnKeyReleased(SpaceInvaderListener.getListener());
    }

    private void addToGamePane(ImageView imageItem) {
        gamePane.getChildren().add(imageItem);

    }

    private void removeFromGamePane(ImageView imageItem) {
        gamePane.getChildren().remove(imageItem);
    }




}
