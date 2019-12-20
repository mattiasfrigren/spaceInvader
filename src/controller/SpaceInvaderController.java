package controller;

import javafx.stage.Stage;
import model.*;
import view.SpaceInvaderInGameView;
import view.ViewManager;

import java.util.ArrayList;
import java.util.Random;

public class SpaceInvaderController {

    private static SpaceInvaderController controller;
    private static SpaceInvaderListener listener;
    private static ViewManager view;
    private static InGameModel gameModel;

    private boolean soundOn = true;
    private boolean gamePaused = false;

    private boolean isShooting = false;
    private boolean isMovingLeft = false;
    private boolean isMovingRight = false;
    private boolean isMovingUp = false;
    private boolean isMovingDown = false;
    private boolean saveGameButtonClicked = false;


    public static SpaceInvaderController getController(Stage stage) {
        if (controller == null) {
            controller = new SpaceInvaderController(stage);
        }
        return controller;
    }

    public static SpaceInvaderController getController() {
        return controller;
    }

    public boolean isSoundOn() {
        return soundOn;
    }

    public void setSoundOn(boolean soundOn) {
        this.soundOn = soundOn;
    }

    public boolean isShooting() {
        return isShooting;
    }

    public void setShooting(boolean shooting) {
        isShooting = shooting;
    }

    public boolean isMovingLeft() {
        return isMovingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        isMovingLeft = movingLeft;
    }

    public boolean isMovingRight() {
        return isMovingRight;
    }

    public void setMovingRight(boolean movingRight) {
        isMovingRight = movingRight;
    }

    public boolean isMovingUp() {
        return isMovingUp;
    }

    public void setMovingUp(boolean movingUp) {
        isMovingUp = movingUp;
    }

    public boolean isMovingDown() {
        return isMovingDown;
    }

    public void setMovingDown(boolean movingDown) {
        isMovingDown = movingDown;
    }

    private SpaceInvaderController(Stage stage) {
        this.gameModel = InGameModel.getGameModel();
        this.view = ViewManager.getViewManager(stage);
        listener = SpaceInvaderListener.getListener();
    }


    public void pauseGame() {
        gamePaused = gamePaused ? false : true;
        SpaceInvaderInGameView.getGameView().setAnimationTimer(gamePaused);
    }

    public ArrayList<EnemyShip> checkWhatToSpawn() {
        if (gameModel.getPoints() == 0) {
            return spawnEnemies(3, "default");
        }
        return null;
    }

    public ArrayList<EnemyShip> spawnEnemies(int amount, String enemy) {
        ArrayList<EnemyShip> enemyModelsToView = new ArrayList<>();
        EnemyShip enemyShip = null;

        if (enemy.equals("default")) {
            enemyShip = new DefaultEnemy();
        }

        double currentYPos = -50;
        boolean toRight = true;
        double middleXPos = Constants.SCREENWIDTH/2 - (enemyShip.getItemWidth()/2);
        double currentXPos = middleXPos;
        double addToX = 0;
        for (int i = 0; i < amount; i++) {
            enemyModelsToView.add(enemyShip);
            enemyShip.setItemCoordX(currentXPos);
            enemyShip.setItemCoordY(currentYPos);

            if (toRight) {
                addToX += Constants.enemySpawnSpread;
                currentXPos = middleXPos + addToX;
                toRight = false;
            }
            else {
                currentXPos = middleXPos - addToX;
                toRight = true;
            }
            if (i%10 == 0) {
                currentYPos -= 50;
            }


        }

        return null;
    }


    //Creates 20 enemies and add them to enemeyModelList
    public void createDefaultEnemieWave() {
        for (int i = 0; i < 10; i++) {
            EnemyShip enemy = new DefaultEnemy();
            enemy.setItemCoordX(Constants.enemyShipStartPosX + (i * Constants.enemySpawnSpread));
            enemy.setItemCoordY(Constants.enemyShipStartPosY);
            gameModel.addEnemyModel(enemy);
        }

        for (int i = 0; i < 10; i++) {
            EnemyShip enemy = new DefaultEnemy();
            enemy.setItemCoordX(Constants.enemyShipStartPosX + (i * Constants.enemySpawnSpread));
            enemy.setItemCoordY(Constants.enemyShipStartPosY - 50);
            gameModel.addEnemyModel(enemy);
        }// will create a new set of EnemyShips

    } public void createEnemyDroneShipWave(){
        for (int i = 0; i < 10 ; i++) {
            EnemyShip enemyDrone = new EnemyDroneShip();
            enemyDrone.setItemCoordX(Constants.enemyShipStartPosX + (i *Constants.enemyDroneShipSpawnSpread));
            enemyDrone.setItemCoordY(Constants.enemyDroneShipStartPosY+50);
            gameModel.addEnemyModel(enemyDrone);
        }
    }
    public void createBigBoss() {
        EnemyShip boss = new EnemyBigBoss();
        boss.setItemCoordY(Constants.enemyBigBossStartPosY);
        boss.setItemCoordX(Constants.SCREENWIDTH/2 );
        gameModel.addEnemyModel(boss);
    }

    public void createMeteor() {
        Meteor meteor = new Meteor();
        meteor.setItemCoordX(Math.random() * 600);
        gameModel.addMeteorModel(meteor);
    }

    public void moveMeteorModel() {
        for (Meteor meteor : gameModel.getMeteorModelList()) {
            meteor.moveUp();
        }
    }//removes a meteor from modellist



    public void checkIfEnemyIsmoving() {
        ArrayList<EnemyShip> enemyShips = gameModel.getEnemyModelList();
        for (int i = 0; i < enemyShips.size() ; i++) {
            double moveinterval = enemyShips.get(i).getRandomMoveInterval();
            if (moveinterval >= Constants.enemyShipMovmentInterval && enemyShips.get(i).getItemCoordY() <= Constants.SCREENHEIGHT / 2){
                enemyShips.get(i).moveUp();
            }
        }
    }

    public ArrayList<IBullet> checkIfEnemyIsShooting() {
        ArrayList<IBullet> enemyModelBullets = new ArrayList<>();
        for (EnemyShip enemyModel : gameModel.getEnemyModelList()) {
            IBullet theEnemyBullet = enemyModel.performShootingAction();
            if (theEnemyBullet != null) {
                enemyModelBullets.add(theEnemyBullet);
                gameModel.addBullets(theEnemyBullet);
            }
        }
        return enemyModelBullets;
    }

    // when space is down check if you weapon manage to shoot.
    public IBullet checkIfPlayerIsShooting() {
        if (isShooting) {
            IBullet currentBullet = gameModel.getPlayerModel().performShootingAction();
            new SoundEffects().playSound(Constants.LASERSOUNDURL1);//PlayerShoot soundEffect.KM
            if (currentBullet != null) {
                gameModel.addBullets(currentBullet);
                System.out.println("bullet added to list");
                return currentBullet;
            }
        }
        return null;
    }

    private void checkIfPlayerIsMovingLeft() {
        if (isMovingLeft && gameModel.getPlayerModel().getItemCoordX() > 0) {
            gameModel.getPlayerModel().moveLeft();
        }
    }

    private void checkIfPlayerIsMovingRight() {
        if (isMovingRight && gameModel.getPlayerModel().getItemCoordX() < Constants.SCREENWIDTH - Constants.playerShipWidth) {
            gameModel.getPlayerModel().moveRight();
        }
    }

    private void checkIfPlayerIsMovingUp() {
        if (isMovingUp && gameModel.getPlayerModel().getItemCoordY() > Constants.SCREENHEIGHT / 2) {
            gameModel.getPlayerModel().moveUp();
        }
    }

    private void checkIfPlayIsMovingDown() {
        if (isMovingDown && gameModel.getPlayerModel().getItemCoordY() < (Constants.SCREENHEIGHT * 0.92) - Constants.playerShipHeight) {
            gameModel.getPlayerModel().moveDown();
        }
    }

    public void updatePlayerMovement() {
        checkIfPlayerIsMovingLeft();
        checkIfPlayerIsMovingRight();
        checkIfPlayerIsMovingUp();
        checkIfPlayIsMovingDown();
    }

    // Moving all bullets forward
    public void updateBullets() {
        for (IBullet bullet : gameModel.getBulletsModelList()) {
            OnScreenItems itemBullet = (OnScreenItems) bullet;
            itemBullet.moveUp();
        }
    }

    // check if something is out of screen
    private boolean checkIfOutOfScreen(double x, double y) {
        return y > Constants.SCREENHEIGHT + 50 || x > Constants.SCREENWIDTH + 50 || y < -50 || x < -50;
    }
    public ArrayList<IBullet> checkIfMeteorShoot() {
        ArrayList<IBullet> bulletsToRemove = new ArrayList<>();
        if (!gameModel.getBulletsModelList().isEmpty()) {
            for (int j = 0; j < gameModel.getBulletsModelList().size(); j++) {
                OnScreenItems bulletsToRemoveNow = (OnScreenItems) gameModel.getBulletsModelList().get(j);
                if (!bulletsToRemoveNow.isFacingPlayer()) {
                    for (int i = 0; i < gameModel.getMeteorModelList().size(); i++) {
                        if (gameModel.getMeteorModelList().get(i).getItemWidth() / 5 + bulletsToRemoveNow.getItemWidth() / 5 > distanceBetween(bulletsToRemoveNow, gameModel.getMeteorModelList().get(i))) {
                            gameModel.removeMeteorModel(gameModel.getMeteorModelList().get(i));
                            bulletsToRemove.add((IBullet) bulletsToRemoveNow);
                        }
                    }
                }
            }
        }
        return bulletsToRemove;
    }

    //Checks if meteor connetcs with the playership.
    public void checkIfMeteorCollide() {

        for (int i = 0; i < gameModel.getMeteorModelList().size(); i++) {
            int lastRemovedMeteorIndex =i;
            if (gameModel.getPlayerModel().getItemWidth() / 5 + gameModel.getMeteorModelList().get(i).getItemWidth() / 5 > distanceBetween(gameModel.getMeteorModelList().get(i), gameModel.getPlayerModel())) {
                gameModel.getPlayerModel().looseLife(1);
                gameModel.removeMeteorModel(gameModel.getMeteorModelList().get(lastRemovedMeteorIndex));
            }
        }
    }

    // Checking if bullet is out of screen and return the index of the bullets that needs to be removed in our imageview list.
    public ArrayList<IBullet> getBulletRemoveList() {
        ArrayList<IBullet> bulletsToRemove = new ArrayList<>();
        for (int i = 0; i < gameModel.getBulletsModelList().size(); i++) {
            OnScreenItems itemBullet = (OnScreenItems) gameModel.getBulletsModelList().get(i);
            if (checkIfOutOfScreen(itemBullet.getItemCoordX(), itemBullet.getItemCoordY())) {
                bulletsToRemove.add(gameModel.getBulletsModelList().get(i));
                continue;
            }
            // checking if bullet collided.
            if (itemBullet.isFacingPlayer()) {
                if (gameModel.getPlayerModel().getItemWidth() / 5 + itemBullet.getItemWidth() / 5 > distanceBetween(itemBullet, gameModel.getPlayerModel())) {
                    gameModel.getPlayerModel().looseLife(1);
                    bulletsToRemove.add(gameModel.getBulletsModelList().get(i));
                    continue;
                }
            } else {
                for (EnemyShip enemy : gameModel.getEnemyModelList()) {
                    if (enemy.getItemWidth() / 5 + itemBullet.getItemWidth() / 5 > distanceBetween(itemBullet, enemy)) {
                        enemy.looseLife(1);
                        bulletsToRemove.add(gameModel.getBulletsModelList().get(i));
                        break;
                    }
                }
            }

        }


        return bulletsToRemove;
    }

    public ArrayList<EnemyShip> getDeadEnemies() {
        ArrayList<EnemyShip> deadEnemyList = new ArrayList<>();

        for (EnemyShip enemy : gameModel.getEnemyModelList()) {
            if (enemy.getLifes() < 1) {
                deadEnemyList.add(enemy);
                gameModel.addPoints(1);
                new SoundEffects().playSound(Constants.POWERUPSOUNDURL); //Enemy deadSouncEffect.KM
            }
        }
        return deadEnemyList;
    }

    //adds +1 to our weaponState to make it ready when at it's state.
    public void updateWeaponsState() {
        gameModel.getPlayerModel().getWeapon().addToReadyToShoot();
        for (EnemyShip enemyShip : gameModel.getEnemyModelList()) {
            enemyShip.getWeapon().addToReadyToShoot();
        }
    }

    //Doing pythagoras rate to check distance between positions together with height and width of the objects..
    private double distanceBetween(double x1, double y1, double x2, double y2, double height1, double height2, double width1, double width2) {
        return Math.sqrt(Math.pow((x1 + (width1 / 2)) - (x2 + (width2 / 2)), 2) + Math.pow((y1 + (height1 / 2)) - (y2 + (height2 / 2)), 2));
    }

    private double distanceBetween(OnScreenItems firstObjc, OnScreenItems secondObjc) {
        return Math.sqrt(Math.pow((firstObjc.getItemCoordX() + (firstObjc.getItemWidth() / 2)) - (secondObjc.getItemCoordX() + (secondObjc.getItemWidth() / 2)), 2) + Math.pow((firstObjc.getItemCoordY() + (firstObjc.getItemHeight() / 2)) - (secondObjc.getItemCoordY() + (secondObjc.getItemHeight() / 2)), 2));
    }


    }


