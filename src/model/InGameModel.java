package model;

import java.sql.SQLException;
import java.util.ArrayList;

// All info in the game.
public class InGameModel {

    private static InGameModel gameModel;

    private PlayerShip playerModel;
    private ArrayList<IBullet> bulletsModelList = new ArrayList<>();
    private ArrayList<EnemyShip> enemiesModelList = new ArrayList<>();


    private boolean isShooting = false;
    private boolean isMovingLeft = false;
    private boolean isMovingRight = false;
    private boolean isMovingUp = false;
    private boolean isMovingDown = false;
    private boolean saveGameButtonClicked = false;

    private String nameInput;

    private int points = 0;

    /////////************** Getter and setters ***********************


    public boolean isSaveGameButtonClicked() {
        return saveGameButtonClicked;
    }

    public void setSaveGameButtonClicked(boolean saveGameButtonClicked) {
        this.saveGameButtonClicked = saveGameButtonClicked;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isShooting() {

        return isShooting;
    }

    public void setShooting(boolean shooting) {
        isShooting = shooting;
    }

    public void setMovingLeft(boolean moveLeft) {
        isMovingLeft = moveLeft;
    }

    public void setMovingRight(boolean moveRight) {
        isMovingRight = moveRight;
    }

    public void setMovingUp(boolean moveUp) {
        isMovingUp = moveUp;
    }

    public void setMovingDown(boolean moveDown) {
        isMovingDown = moveDown;
    }

    public static InGameModel getGameModel() {
        if (gameModel == null) {
            gameModel = new InGameModel();
        }
        return gameModel;
    }

    private InGameModel() {
        playerModel = new PlayerShip();
        createEnemiesLevelOne();
    }


    public PlayerShip getPlayerModel() {
        return playerModel;
    }

    public void setPlayerModel(PlayerShip playerModel) {
        this.playerModel = playerModel;
    }

    public ArrayList<IBullet> getBulletsModelList() {
        return bulletsModelList;
    }

    // add modelinfo
    public void addBullets(IBullet bullet) {
        bulletsModelList.add(bullet);
    }

    public IBullet getLastBullet() {
        return bulletsModelList.get(bulletsModelList.size() - 1);
    }


    public ArrayList<EnemyShip> getEnemyModelList() {
        return enemiesModelList;
    }

    //Adds enemies to enemieModelList
    public void addEnemyModel(EnemyShip enemy) {
        enemiesModelList.add(enemy);
    }

    ///// ******************* END OF GETTERS AND SETTERS  ******************************


    //Creates 10 enemies and add them to enemeyModelList
    public void createEnemiesLevelOne() {
        for (int i = 0; i < 10; i++) {
            EnemyShip enemy = new EnemyShip(); //Makes new enemy
            enemy.setItemCoordX(Constants.enemyShipStartPosX + (i * Constants.enemySpawnSpread)); //Moves each enemy on different spawnpoints on X-line.
            addEnemyModel(enemy);
        }
    }

    public ArrayList<IBullet> checkIfEnemyIsShooting() {
        ArrayList<IBullet> enemyModelBullets = new ArrayList<>();
        for (EnemyShip enemyModel : enemiesModelList) {
            IBullet theEnemyBullet = enemyModel.weapon.shoot();
            if (theEnemyBullet != null) {
                enemyModelBullets.add(theEnemyBullet);
                bulletsModelList.add(theEnemyBullet);
            }
        }
        return enemyModelBullets;
    }

    // when space is down check if you weapon manage to shoot.
    public IBullet checkIfPlayerIsShooting() {
        if (isShooting()) {
            IBullet currentBullet = playerModel.performShootingAction();
           SoundEffects.getSoundEffects().playLaser2Sound(); //PlayerShoot soundEffect.KM
            if (currentBullet != null) {
                bulletsModelList.add(currentBullet);
                System.out.println("bullet added to list");
                return currentBullet;
            }
        }
        return null;
    }

    private void checkIfPlayerIsMovingLeft() {
        if (isMovingLeft && playerModel.getItemCoordX() > 0) {
            playerModel.moveLeft();
        }
    }
    private void checkIfPlayerIsMovingRight() {
        if (isMovingRight && playerModel.getItemCoordX() < Constants.SCREENWIDTH - Constants.playerShipWidth) {
            playerModel.moveRight();
        }
    }

    private void checkIfPlayerIsMovingUp() {
        if (isMovingUp && playerModel.getItemCoordY() > Constants.SCREENHEIGHT / 2) {
            playerModel.moveUp();
        }
    }

    private void checkIfPlayIsMovingDown() {
        if (isMovingDown && playerModel.getItemCoordY() < Constants.SCREENHEIGHT - Constants.playerShipHeight) {
            playerModel.moveDown();
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
        for (IBullet bullet : bulletsModelList) {
            OnScreenItems itemBullet = (OnScreenItems) bullet;
            itemBullet.moveUp();
        }
    }

    // check if something is out of screen
    private boolean checkIfOutOfScreen(double x, double y) {
        return y > Constants.SCREENHEIGHT + 50 || x > Constants.SCREENWIDTH + 50 || y < -50 || x < -50;
    }

    // Checking if bullet is out of screen and return the index of the bullets that needs to be removed in our imageview list.
    public ArrayList<IBullet> getBulletRemoveList() {
        ArrayList<IBullet> bulletsToRemove = new ArrayList<>();
        for (int i = 0; i < bulletsModelList.size(); i++) {
            OnScreenItems itemBullet = (OnScreenItems) bulletsModelList.get(i);
            if (checkIfOutOfScreen(itemBullet.getItemCoordX(), itemBullet.getItemCoordY())) {
                bulletsToRemove.add(bulletsModelList.get(i));
            }
            // checking if bullet collided.
            if (itemBullet.isFacingPlayer()) {
                if (playerModel.getItemWidth() / 5 + itemBullet.getItemWidth() / 5 > distanceBetween(itemBullet, playerModel)) {
                    playerModel.looseLife(1);
                    bulletsToRemove.add(bulletsModelList.get(i));
                }
            } else { // commented out while waiting for enemies.
                for (EnemyShip enemy : enemiesModelList) {
                    if (enemy.getItemWidth() / 5 + itemBullet.getItemWidth() / 5 > distanceBetween(itemBullet, enemy)) {
                        SoundEffects.getSoundEffects().playPowerUpSound(); //Enemy deadSouncEffect.KM
                        enemy.looseLife(1);
                        bulletsToRemove.add(bulletsModelList.get(i));
                    }
                }
            }

        }


        return bulletsToRemove;
    }

    public ArrayList<EnemyShip> getDeadEnemies() {
        ArrayList<EnemyShip> deadEnemyList = new ArrayList<>();

        for (EnemyShip enemy : enemiesModelList) {
            if (enemy.getLifes() < 1) {
                deadEnemyList.add(enemy);
                points++;
            }
        }
        return deadEnemyList;
    }

    //adds +1 to our weaponState to make it ready when at it's state.
    public void updateWeaponsState() {
        playerModel.getWeapon().addToReadyToShoot();
        for (EnemyShip enemyShip : enemiesModelList) {
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

    public String generateHighScoreName(String nameInput){
            callHighScore();
        if (saveGameButtonClicked){
            this.nameInput = nameInput;
            System.out.println(nameInput);
            callHighScore();
        }
        return nameInput;
    }

    public static void callHighScore() {
        try {
            HighScore.handleHighScore();
        }
        catch (SQLException e){
            System.err.println(e);
        }

    }

}
