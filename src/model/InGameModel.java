package model;

import java.util.ArrayList;

// All info in the game.
public class InGameModel {

    private static InGameModel gameModel;

    private PlayerShip playerModel;
    private EnemyShip singleEnemyShip;
    private ArrayList<IBullet> bulletsModelList = new ArrayList<>();
    private ArrayList<EnemyShip> enemiesModelList = new ArrayList<>();


    private boolean isShooting = false;
    private boolean isMovingLeft = false;
    private boolean isMovingRight = false;
    //TODO add all movement true or false;

    /////////************** Getter and setters ***********************
    public boolean isShooting() {

        return isShooting;
    }
    public void setShooting(boolean shooting) {
        isShooting = shooting;
    }

    public void setmovingLeft(boolean moveLeft){
        isMovingLeft = moveLeft;
    }
    public void setmovingRight(boolean moveRight){
        isMovingRight = moveRight;
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
        return bulletsModelList.get(bulletsModelList.size()-1);
    }


    public ArrayList<EnemyShip> getEnemy() {
        return enemiesModelList;
    }
//Adds enemies to enemieModelList
    public void addEnemy(EnemyShip enemy) {
        enemiesModelList.add(enemy);
    }
    //Creates 10 enemies and add them to enemeyModelList
    public void createEnemiesLevelOne(){
        for (int i = 0; i <10 ; i++) {
            EnemyShip enemy = new EnemyShip(); //Makes new enemy
            enemy.setItemCoordX(Constants.enemyShipStartPosX + (i * Constants.enemySpawnSpread) ); //Moves each enemy on different spawnpoints on X-line.
            addEnemy(enemy);
        }
    }

    ///// ******************* END OF GETTERS AND SETTERS  ******************************

    // when space is down check if you weapon manage to shoot.
    public IBullet checkIfPlayerIsShooting() {
        if (isShooting()) {
            IBullet currentBullet = playerModel.performShootingAction();
            if (currentBullet != null) {
                bulletsModelList.add(currentBullet);
                System.out.println("bullet added to list");
                return currentBullet;
            }
        }
        return null;
    }
    private void checkIfPlayerIsMovingLeft(){
       if (isMovingLeft && playerModel.getItemCoordX() > 0){
           playerModel.moveLeft();
        }
    }
    private void checkIfPlayerIsMovingRight() {
        if (isMovingRight && playerModel.getItemCoordX() < Constants.SCREENWIDTH) {
            playerModel.moveRight();
        }
    }

    public void updatePlayerMovement(){
        checkIfPlayerIsMovingLeft();
        checkIfPlayerIsMovingRight();
    }

    // Moving all bullets forward
    public void updateBullets() {
        for (IBullet bullet : bulletsModelList) {
            OnScreenItems itemBullet = (OnScreenItems)bullet;
            itemBullet.moveUp();
        }
    }

    // check if something is out of screen
    private boolean checkIfOutOfScreen(double x, double y) {
        return y > Constants.SCREENHEIGHT+50 || x > Constants.SCREENWIDTH+50 || y < -50 || x < -50;
    }

    // Checking if bullet is out of screen and return the index of the bullets that needs to be removed in our imageview list.
    public ArrayList<IBullet> getBulletRemoveList() {
        ArrayList<IBullet> bulletsToRemove = new ArrayList<>();
        for (int i = 0; i < bulletsModelList.size() ; i++) {
            OnScreenItems itemBullet = (OnScreenItems)bulletsModelList.get(i);
            if (checkIfOutOfScreen(itemBullet.getItemCoordX(), itemBullet.getItemCoordY())){
                bulletsToRemove.add(bulletsModelList.get(i));
            }
            // checking if bullet collided.
            if (itemBullet.isFacingPlayer()) {
                if (playerModel.getItemWidth()/2 + itemBullet.getItemWidth()/2 > distanceBetween(itemBullet, playerModel)) {
                    // TODO player loose hp
                    bulletsToRemove.add(bulletsModelList.get(i));
                }
            }
            else { // commented out while waiting for enemies.
              /*  for (EnemyShip enemy: enemiesModelList) {
                    if (enemy.getItemWidth() / 2 + itemBullet.getItemWidth() / 2 > distanceBetween(itemBullet, enemy)) {
                        // TODO Enemy loose hp
                        bulletsToRemove.add(bulletsModelList.get(i));
                    }
                } */
            }

        }


        return bulletsToRemove;
    }

    //adds +1 to our weaponState to make it ready when at it's state.
    public void updateWeaponsState() {
        playerModel.getWeapon().addToReadyToShoot();
       /* for (EnemyShip enemyShip: enemiesModelList) {
            enemyShip.getWeapon().addToReadyToShoot();
        }*/
    }

    //Doing pythagoras rate to check distance between positions together with height and width of the objects..
    private double distanceBetween(double x1, double y1, double x2, double y2, double height1, double height2, double width1, double width2) {
        return Math.sqrt(Math.pow((x1 + (width1/2)) - (x2 + (width2/2)), 2) + Math.pow((y1 + (height1/2)) - (y2 + (height2/2)), 2));
    }

    private double distanceBetween(OnScreenItems firstObjc, OnScreenItems secondObjc) {
        return Math.sqrt(Math.pow((firstObjc.getItemCoordX() + (firstObjc.getItemWidth()/2)) - (secondObjc.getItemCoordX() + (secondObjc.getItemWidth()/2)), 2) + Math.pow((firstObjc.getItemCoordY() + (firstObjc.getItemHeight()/2)) - (secondObjc.getItemCoordY() + (secondObjc.getItemHeight()/2)), 2));
    }



}
