package controller;

import javafx.stage.Stage;
import model.*;
import view.SpaceInvaderInGameView;
import view.ViewManager;

import java.util.ArrayList;
import java.util.Random;
// Controller that talks with View and Model and changing the state of the game.
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
    private boolean spawnMeteor = true;
    private int lastSpawnedAt = -1;

    /////////************** Getter and setters ***********************

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

    public boolean isGamePaused() {
        return gamePaused;
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

    /////////************** End of Getter and setters ***********************

    private SpaceInvaderController(Stage stage) {
        this.gameModel = InGameModel.getGameModel();
        this.view = ViewManager.getViewManager(stage);
        listener = SpaceInvaderListener.getListener();
    }

    public void resetController() {
        isShooting = false;
        isMovingLeft = false;
        isMovingRight = false;
        isMovingUp = false;
        isMovingDown = false;
        lastSpawnedAt = -1;

    }

    public void pauseGame() {
        gamePaused = gamePaused ? false : true;
        SpaceInvaderInGameView.getGameView().setAnimationTimer(gamePaused);
    }

    public ArrayList<EnemyShip> checkWhatToSpawn() {
        if (shouldSpawnAtPoint(0)) {
            lastSpawnedAt = 0;
            return spawnEnemies(5, "default");
        }
        else if (shouldSpawnAtPoint(5)) {
            lastSpawnedAt = 5;
            return spawnEnemies(10, "default");
        }
       else if (shouldSpawnAtPoint(15)) {
            lastSpawnedAt = 15;
            return spawnEnemies(20, "default");
        }
       else if (shouldSpawnAtPoint(35)) {
           lastSpawnedAt = 35;
           return  spawnEnemies(10,"default");
        }
       else if (shouldSpawnAtPoint(36)) {
           lastSpawnedAt = 36;
            return spawnEnemies(10,"drone");
        }
       else if (shouldSpawnAtPoint(55)) {
           lastSpawnedAt = 55;
           return  spawnEnemies(20,"drone");
        }
       else if (shouldSpawnAtPoint(75)) {
           lastSpawnedAt = 75;
           return spawnEnemies(20,"default");
        }
       else if (shouldSpawnAtPoint(76)) {
           lastSpawnedAt =76;
           return spawnEnemies(20,"drone");
        }
       else if (shouldSpawnAtPoint(115)) {
            lastSpawnedAt = 115;
            return spawnEnemies(40,"drone");
        }
       else if (shouldSpawnAtPoint(155)) {
           lastSpawnedAt = 155;
           return spawnEnemies(60,"drone");
        }
       if (shouldSpawnMeteorAtPoint(gameModel.getPoints())) {
              gameModel.setModelMeteor(new Meteor());
                gameModel.getModelMeteor().setItemCoordX(Math.random() * Constants.SCREENWIDTH);
                SpaceInvaderInGameView.getGameView().initializeMeteor();
                spawnMeteor = false;
        }
        return null;
    }
    private boolean shouldSpawnMeteorAtPoint(int points) {
        if (points == 20 || points == 40 || points == 60 || points == 80 || points == 100 || points == 120 || points == 140) {
       return spawnMeteor;
        }
        else if (points == 21 || points == 41 || points == 61 || points == 81 || points == 101 || points == 121 || points == 141) {
            spawnMeteor = true;
        }
        return false;
    }
    private boolean shouldSpawnAtPoint(int points) {
        return gameModel.getPoints() == points && lastSpawnedAt != points;
    }

    private ArrayList<EnemyShip> spawnEnemies(int amount, String enemy) {
        ArrayList<EnemyShip> enemyModelsToView = new ArrayList<>();
        EnemyShip enemyShip = null;

        if (enemy.equals("default")) {
            enemyShip = new DefaultEnemy();
        }
        if (enemy.equals("drone")) {
            enemyShip = new EnemyDroneShip();
        }
        if (enemy.equals("boss")) {
            enemyShip = new EnemyBigBoss();
        }

        double startXPos = Constants.SCREENWIDTH/2 - (enemyShip.getItemWidth()/2);
        boolean toRight = true;
        double currentYPos = -50;
        double currentXPos = startXPos;
        double currentDistanceFromCenter = 0;

        for (int i = 0; i < amount; i++) {

            if (enemy.equals("default")) {
                enemyShip = new DefaultEnemy();
            }
            if (enemy.equals("drone")) {
                enemyShip = new EnemyDroneShip();
            }
            if (enemy.equals("boss")){
                enemyShip = new EnemyBigBoss();
            }

            if (i%10 == 0) {
                currentDistanceFromCenter = 0;
                currentXPos = startXPos;
                currentYPos -= 100;
                toRight = true;
            }
            else {
                if (toRight) {
                    currentDistanceFromCenter += Constants.enemySpawnSpread;
                    currentXPos = startXPos + currentDistanceFromCenter;
                    toRight = false;
                }
                else {
                    currentXPos = startXPos - currentDistanceFromCenter;
                    toRight = true;
                }
            }
            enemyShip.setItemCoordX(currentXPos + (new Random().nextInt(20)));
            enemyShip.setItemCoordY(currentYPos + (new Random().nextInt(20)));

            enemyModelsToView.add(enemyShip);
            gameModel.addEnemyModel(enemyShip);
        }

        return enemyModelsToView;
    }

    public void createBigBoss() {
        EnemyShip boss = new EnemyBigBoss();
        boss.setItemCoordY(Constants.enemyBigBossStartPosY);
        boss.setItemCoordX(Constants.SCREENWIDTH/2 );
        gameModel.addEnemyModel(boss);
    }

    public void moveMeteorModel() {
        if (gameModel.getModelMeteor() !=null) {
            gameModel.getModelMeteor().moveUp();
            if (gameModel.getModelMeteor().getItemCoordY() >= Constants.SCREENHEIGHT+300) {
                gameModel.setModelMeteor(null);
                System.out.println("meteor removed");
            }
        }
    }

    public void checkIfEnemyIsmoving() {
        ArrayList<EnemyShip> enemyShips = gameModel.getEnemyModelList();
        for (int i = 0; i < enemyShips.size() ; i++) {

            if (enemyShips.get(i).getItemCoordY() <= Constants.SCREENHEIGHT / 2 && enemyShips.get(i).isMoveStateUpDown()==true){
                enemyShips.get(i).moveUp();
                if (enemyShips.get(i).getItemCoordY() >= Constants.SCREENHEIGHT/2) {
                    enemyShips.get(i).setMoveStateUpDown(false);
                }
            }
            if (enemyShips.get(i).getItemCoordY() < Constants.SCREENHEIGHT && enemyShips.get(i).isMoveStateUpDown() ==false) {
                enemyShips.get(i).moveDown();
                if (enemyShips.get(i).getItemCoordY() <= 0) {
                    enemyShips.get(i).setMoveStateUpDown(true);
                }
            }
            if (enemyShips.get(i).getItemCoordX() <= (Constants.SCREENWIDTH-30) && enemyShips.get(i).isMoveStateRightLeft()==true){
                enemyShips.get(i).moveLeft();
                if (enemyShips.get(i).getItemCoordX() >= Constants.SCREENWIDTH-30) {
                    enemyShips.get(i).setMoveStateRightLeft(false);
                }
            }
            if (enemyShips.get(i).getItemCoordX() < Constants.SCREENWIDTH  && enemyShips.get(i).isMoveStateRightLeft()==false){
                enemyShips.get(i).moveRight();
                if (enemyShips.get(i).getItemCoordX() <=0) {
                    enemyShips.get(i).setMoveStateRightLeft(true);
                }
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
        if (isMovingUp && gameModel.getPlayerModel().getItemCoordY() > (Constants.SCREENHEIGHT / 2)+(gameModel.getPlayerModel().getItemHeight()/2)) {
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

    private boolean checkIfOutOfScreen(double x, double y, double width) {
        return y > Constants.SCREENHEIGHT + width || x > Constants.SCREENWIDTH + width || y < -width || x < -width;
    }

    public ArrayList<IBullet> checkIfMeteorShoot() {
        if (gameModel.getModelMeteor()!=null) {
            ArrayList<IBullet> bulletsToRemove = new ArrayList<>();
            if (!gameModel.getBulletsModelList().isEmpty()) {
                for (int j = 0; j < gameModel.getBulletsModelList().size(); j++) {
                    OnScreenItems bulletsToRemoveNow = (OnScreenItems) gameModel.getBulletsModelList().get(j);
                    if (!bulletsToRemoveNow.isFacingPlayer()) {
                        if (gameModel.getModelMeteor().getItemWidth() / 5 + bulletsToRemoveNow.getItemWidth() / 5 > distanceBetween(bulletsToRemoveNow, gameModel.getModelMeteor())) {
                            gameModel.setModelMeteor(null);
                            bulletsToRemove.add((IBullet) bulletsToRemoveNow);
                            gameModel.getPlayerModel().setLifes(gameModel.getPlayerModel().getLifes()+1);
                        }
                    }
                }
            }
            return bulletsToRemove;
        }
        return null;
    }

    //Checks if meteor connetcs with the playership.
    public void checkIfMeteorCollide() {
        if (gameModel.getModelMeteor()!=null) {
            if (gameModel.getPlayerModel().getItemWidth() / 5 + gameModel.getModelMeteor().getItemWidth() / 5 > distanceBetween(gameModel.getModelMeteor(), gameModel.getPlayerModel())) {
                gameModel.getPlayerModel().looseLife(1);
                gameModel.setModelMeteor(null);
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


